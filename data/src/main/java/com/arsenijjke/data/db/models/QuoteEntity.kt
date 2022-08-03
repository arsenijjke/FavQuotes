package com.arsenijjke.data.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.arsenijjke.domain.models.QuoteOfTheDay

@Entity(tableName = "Quotes_DB")
data class QuoteEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "author")
    val author: String,

    @ColumnInfo(name = "body")
    val body: String
)