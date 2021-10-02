package com.tbashish.startupstoriesmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tbashish.startupstoriesmvvm.model.Post
import com.tbashish.startupstoriesmvvm.repositiory.PostListRepo
import kotlinx.coroutines.launch

class PostListViewModel : ViewModel() {
    val postRepo = PostListRepo()
    val postList : MutableLiveData<List<Post>> = MutableLiveData()

    fun getPostList(){
        viewModelScope.launch{
            try {
                val response = postRepo.fetchPostData()
                if (response != null) {
                    onGetPostListResponseSuccess(response)
                }
            } catch (e: Exception) {

            }
        }
    }

    private fun onGetPostListResponseSuccess(response: List<Post>) {
       postList.value = response
    }


}