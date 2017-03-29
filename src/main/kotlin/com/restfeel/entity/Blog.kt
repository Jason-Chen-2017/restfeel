package com.restfeel.entity

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*
import javax.persistence.Id
import javax.persistence.Version

@Document
class Blog(
        val title: String,
        val content: String,
        val author: String,
        val gmtCreated: Date,
        val gmtModified: Date,
        val isDeleted: Int, //1 Yes 0 No
        val deletedDate: Date,
        @Id
        val id: Long,
        @Version
        val version: Long) {
    override fun toString(): String {
        return "Blog(title='$title', content='$content', author='$author', gmtCreated=$gmtCreated, gmtModified=$gmtModified, isDeleted=$isDeleted, deletedDate=$deletedDate, id=$id, version=$version)"
    }

}
