package com.tbashish.startupstoriesmvvm.service
import com.tbashish.startupstoriesmvvm.model.MediaModel
import com.tbashish.startupstoriesmvvm.model.Post
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {

        @GET("posts")
        suspend fun getPosts(): List<Post>

        @GET("media/{id}")
        suspend fun getPostImage(@Query("id") id : Int): MediaModel

}