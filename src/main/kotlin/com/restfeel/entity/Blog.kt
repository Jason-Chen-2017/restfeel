package com.restfeel.entity

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Version

@Document(collection = "blog") // 如果不指定collection，默认遵从命名规则
class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: String = ObjectId.get().toString()
    @Version
    var version: Long = 0
    var title: String = ""
    var content: String = ""
    var author: String = ""
    var gmtCreated: Date = Date()
    var gmtModified: Date = Date()
    var isDeleted: Int = 0 //1 Yes 0 No
    var deletedDate: Date = Date()
    override fun toString(): String {
        return "Blog(id='$id', version=$version, title='$title', content='$content', author='$author', gmtCreated=$gmtCreated, gmtModified=$gmtModified, isDeleted=$isDeleted, deletedDate=$deletedDate)"
    }

}

