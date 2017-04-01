package com.restfeel.service

import com.restfeel.entity.Blog
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.query.Param

interface BlogService : MongoRepository<Blog, String> {

    @Query("{ 'title' : ?0 }")
    fun findByTitle(@Param("title") title: String): Iterable<Blog>

}
