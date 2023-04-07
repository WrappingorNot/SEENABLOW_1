package com.example.seenablow.DataRoom

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "user")
class User ( @PrimaryKey var id : Long?,

    @ColumnInfo(name = "username") var username: String?,
             @ColumnInfo(name = "age") var age: Int?,
             @ColumnInfo(name = "gender") var gender: String?,


             ){
    constructor(): this(1, "Gosungwook", 20, "man")

}