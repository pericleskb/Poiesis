package com.moomis.poiesis.data.dto

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