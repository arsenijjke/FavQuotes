package com.arsenijjke.data.db.models

import androidx.room.TypeConverter
import com.arsenijjke.domain.models.Quote

class TypeConverterQuote {
    @TypeConverter
    fun stringToQuote(data: String?): Quote {
        var author = ""
        var body = ""
        var id = 0
        val list = mutableListOf<Any>(author, body, id)

        if (data != null) {
            var i = 0
            var j = 0
            var temp: String = ""

            while (data[i] != data.last()) {
                temp += data[i]
                if (data[i] == '#') {
                    list[j] = temp
                    temp = ""
                    j++
                }
                i++
            }
        }
        return Quote(author = author, body = body, id = id)
    }

    @TypeConverter
    fun quoteToString(quote: Quote): String {
        return quote.author + "#" + quote.body + "#" + quote.id.toString()
    }

}