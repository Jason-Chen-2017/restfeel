package com.restfeel.security;

import static com.restfeel.util.CommonUtil.isEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.restfeel.dao.UserRepository;
import com.restfeel.entity.User;

@Service
public class RfUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {

	if (isEmpty(email)) {
	    return null;
	}
	return userRepository.findByEmail(email);
    }

}
