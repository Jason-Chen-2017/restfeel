package com.restfeel.service

import com.restfeel.entity.Blog
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.query.Param

interface BlogService : MongoRepository<Blog, String> {

    //    @Query(value = "{ 'title' : ?0}")
    @Query(value = "{ 'title' : {\$regex: ?0, \$options: 'i'}}") //我们这里设置 $options 为 $i，意思是检索不区分大小写。
    fun findByTitle(@Param("title") title: String): Iterable<Blog>

}
