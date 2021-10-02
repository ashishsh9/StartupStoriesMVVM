package com.tbashish.startupstoriesmvvm.service
import com.tbashish.startupstoriesmvvm.model.Post
import retrofit2.http.GET

interface RetrofitServices {

        @GET("posts")
        suspend fun getPosts(): List<Post>

}