package com.tbashish.startupstoriesmvvm.repositiory

import androidx.lifecycle.MutableLiveData
import com.tbashish.startupstoriesmvvm.model.MediaModel

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

        var postList =  withContext(Dispatchers.IO) {
            val async = async {
                request.getPosts()

            }

            var postListResponse = async.await()
            postListResponse
        }

        println("POstLIstResonse ${postList}")

//        for (post in postList){
//            val featuredMedia = post.featured_media
//            println("FeaturedMedia = ${featuredMedia}");
//            var mediaModel : MediaModel
//            mediaModel = withContext(Dispatchers.IO) {
//                val response = async {
//                    request.getPostImage(featuredMedia)
//                }.await()
//                response
//            }
//            var imagePath = mediaModel.guid["rendered"]
//            print("ImagePath = ${imagePath}")
//            post.imagePath = imagePath.toString()
//
//
//
//
//        }
        return postList

    }

//    suspend fun getImages(request : RetrofitServices, postListResponse : List<Post>): List<Post>{
//
//        for (post in postListResponse){
//            val featuredMedia = post.featured_media
//            var mediaModel : MediaModel
//            withContext(Dispatchers.IO) {
//               mediaModel =  async {
//                    request.getPostImage(featuredMedia)
//                }.await()
//
//            }
//            var imagePath = mediaModel.guid["rendered"]
//
//            if (imagePath != null) {
//                post.imagePath = imagePath
//            }
//
//
//        }
//
//        return postListResponse
//    }
}