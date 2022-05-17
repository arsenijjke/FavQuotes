package com.arsenijjke.data.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Quotes_DB")
data class FavouriteQuote(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
