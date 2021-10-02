package com.tbashish.startupstoriesmvvm.repositiory

import androidx.lifecycle.MutableLiveData

import com.tbashish.startupstoriesmvvm.model.Post
import com.tbashish.startupstoriesmvvm.service.RetrofitClient
import com.tbashish.startupstoriesmvvm.service.RetrofitServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class PostListRepo {

    private val _networkState = MutableLiveData<PostListNetworkState>()
    val _PostListResponse = MutableLiveData<List<Post>>()

    suspend fun fetchPostData(): List<Post> {
        val retrofit = RetrofitClient().getInstance()
        val request = retrofit.create(RetrofitServices::class.java)

        return withContext(Dispatchers.IO) {
            val async = async {
                request.getPosts()
            }

            val postListResponse = async.await()
            postListResponse
        }
    }
}