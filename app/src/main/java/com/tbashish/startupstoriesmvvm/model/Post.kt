package com.tbashish.startupstoriesmvvm.model

data class Post(
    val id : Int,
    val date : String,
    val title : Map<String, String>,
    val content : Map<String, String>,
    val excerpt : Map<String, String>,
    val featured_media : Int,
    val author : Int,
    var imagePath : String
)