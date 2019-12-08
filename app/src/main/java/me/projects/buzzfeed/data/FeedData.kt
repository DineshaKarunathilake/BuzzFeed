package me.projects.buzzfeed.data

data class Teaser (
    val title: String,
    val text: String,
    val isPaid: Boolean,
    val type: String
){
    constructor(title: String, text: String, type: String): this(title, text, false, type)
}

data class Feed (
    val name: String,
    val teasers: List<Teaser>
)