/*
 * Copyright 2014 Ranjan Kumar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.restfeel.controller.rest;

import java.util.List;

import javax.annotation.Resource;

import com.restfeel.constant.StatusType;
import com.restfeel.dao.UserRepository;
import com.restfeel.dto.PasswordDTO;
import com.restfeel.dto.PasswordResetDTO;
import com.restfeel.dto.UserDTO;
import com.restfeel.entity.User;
import com.restfeel.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@ComponentScan
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/api/users", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    UserDTO create(@RequestBody PasswordDTO passwordDTO) {
        logger.debug("Creating a new user with information: " + passwordDTO);

        // TODO add validation

        User user = new User();
        user.setName(passwordDTO.getName());
        user.setDescription(passwordDTO.getDescription());

        String userEmail = passwordDTO.getEmail();

        user.setEmail(userEmail);

        user.setPassword(
            CommonUtil.isNotEmpty(passwordDTO.getPassword()) ? passwordEncoder.encode(passwordDTO.getPassword())
                : passwordEncoder
                    .encode("default"));

        user.setStatus(StatusType.ACTIVE.name());

        User savedUser = userRepository.save(user);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(savedUser.getId());
        userDTO.setName(savedUser.getName());
        userDTO.setEmail(savedUser.getEmail());

        return userDTO;
    }

    /**
     * 系统后门：配置系统超级管理员
     * @param name
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "/api/admin", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public UserDTO createAdmin(
        @RequestParam(value = "name") String name,
        @RequestParam(value = "email") String email,
        @RequestParam(value = "password") String password) {
        logger.debug("Creating a new user with information: " + name + "/" + email + "/" + password);

        User user = new User();
        user.setName(name);
        user.setEmail(email);

        user.setPassword(
            CommonUtil.isNotEmpty(password) ? passwordEncoder.encode(password)
                : passwordEncoder
                    .encode("default"));

        user.setStatus(StatusType.ACTIVE.name());

        User savedUser = userRepository.save(user);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(savedUser.getId());
        userDTO.setName(savedUser.getName());
        userDTO.setEmail(savedUser.getEmail());

        return userDTO;
    }

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public
    @ResponseBody
    void delete(@PathVariable("id") String id) {
        logger.debug("Deleting user with id: " + id);

        User deleted = userRepository.findOne(id);

        userRepository.delete(deleted);
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public
    @ResponseBody
    List<User> findAll() {
        logger.debug("Finding all users");

        return userRepository.findAll();
    }

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    User findById(@PathVariable("id") String id) {
        logger.debug("Finding user by id: " + id);

        return userRepository.findOne(id);
    }

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public
    @ResponseBody
    UserDTO update(@PathVariable("id") Long id, @RequestBody UserDTO updated) {
        logger.debug("Updating user with information: " + updated);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if (principal != null && principal instanceof User) {
            User loggedInUser = (User)principal;
            User user = userRepository.findOne(loggedInUser.getId());

            user.setName(updated.getName());
            user.setDescription(updated.getDescription());
            user.setEmail(updated.getEmail());
            userRepository.save(user);
        }

        return updated;
    }

    @RequestMapping(value = "/api/users/current-user", method = RequestMethod.GET)
    public
    @ResponseBody
    UserDTO getCurrentUser() {
        UserDTO userDTO = new UserDTO();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if (principal != null && principal instanceof User) {
            User loggedInUser = (User)principal;
            User user = userRepository.findOne(loggedInUser.getId());
            userDTO.setName(user.getName());
            userDTO.setDescription(user.getDescription());
            userDTO.setEmail(user.getEmail());
        }
        return userDTO;
    }

    @RequestMapping(value = "/api/users/change-password", method = RequestMethod.POST,
        headers = "Accept=application/json")
    public
    @ResponseBody
    void changePassword(@RequestBody PasswordResetDTO passwordResetDTO) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if (principal != null && principal instanceof User) {
            User loggedInUser = (User)principal;
            User user = userRepository.findOne(loggedInUser.getId());
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setPassword(passwordEncoder.encode(passwordResetDTO.getRetypedPassword()));
            userRepository.save(user);
        }

    }

    @RequestMapping(value = "/api/users/set-password", method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE)
    String setPassword(@PathVariable("token") String token) {

        return null;
    }

}
