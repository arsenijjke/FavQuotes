package com.arsenijjke.data.db.models

import androidx.room.TypeConverter
import com.arsenijjke.domain.models.Quote

@TypeConverter
fun byteArrayToQuote(data: String?): Quote? {
    var author: String = TODO()
    var body: String = TODO()
    var id: Int = TODO()
    return Quote(author, body, id)
}

@TypeConverter
fun quoteToString(quote: Quote): String {
    return quote.author + " " + quote.body + " " + quote.id.toString()
}