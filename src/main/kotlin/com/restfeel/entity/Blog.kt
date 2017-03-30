package com.restfeel.entity

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*
import javax.persistence.Id
import javax.persistence.Version

@Document(collection = "blog") // 如果不指定collection，默认遵从命名规则
class Blog {
    var title: String = ""
    var content: String = ""
    var author: String = ""
    var gmtCreated: Date = Date()
    var gmtModified: Date = Date()
    var isDeleted: Int = 0 //1 Yes 0 No
    var deletedDate: Date = Date()
    //指定生成MongoDB: '_id'
    @Id
    var id: String = ObjectId.get().toString()
    @Version
    var version: Long = 0

    override fun toString(): String {
        return "Blog(title='$title', content='$content', author='$author', gmtCreated=$gmtCreated, gmtModified=$gmtModified, isDeleted=$isDeleted, deletedDate=$deletedDate, id='$id', version=$version)"
    }

}
