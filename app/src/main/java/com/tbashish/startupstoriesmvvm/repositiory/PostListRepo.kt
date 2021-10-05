package com.tbashish.startupstoriesmvvm.repositiory

import androidx.lifecycle.MutableLiveData
import com.tbashish.startupstoriesmvvm.model.MediaModel

import com.tbashish.startupstoriesmvvm.model.Post
import com.tbashish.startupstoriesmvvm.service.RetrofitClient
import com.tbashish.startupstoriesmvvm.service.RetrofitServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class PostListRepo {

    suspend fun fetchPostData(): List<Post> {
        val retrofit = RetrofitClient().getInstance()
        val request = retrofit.create(RetrofitServices::class.java)
        //println("Fetching PostList...")

        var postList =  withContext(Dispatchers.IO) {
            val async = async {
                request.getPosts()

            }

            val postListResponse = async.await()
            postListResponse
        }


        // Is this correct way? Calling another API below
        // Can add and populate as soon as one is received?

        val request2 = retrofit.create(RetrofitServices::class.java)

        for (post in postList){
            val featuredMedia = post.featured_media.toString()
            println("FeaturedMedia = ${featuredMedia}");
            val mediaModel = GlobalScope.async(Dispatchers.IO) {
                println("Calling Function to Get Image ${featuredMedia}")
                val resp = request2.getPostImage(featuredMedia)
                println("Resp Received")
                resp

            }.await()

            val imagePath = mediaModel.guid["rendered"]
            print("ImagePath = ${imagePath}")
            post.imagePath = imagePath.toString()




        }
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