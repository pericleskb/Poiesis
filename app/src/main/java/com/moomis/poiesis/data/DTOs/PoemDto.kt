package com.moomis.poiesis.data.DTOs

import com.moomis.poiesis.data.models.Poem

data class PoemDto (
    val author: String,
    val title: String,
    val linecount: Int,
    val lines: List<String>,
)

//fun PoemDto.toModel() : Poem {
//    return Poem(
//        author,
//        title,
//        linecount,
//        lines.reduce { acc, string -> acc + "\n" + string  },
//        false
//    )
//}