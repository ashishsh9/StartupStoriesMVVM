package com.tbashish.startupstoriesmvvm.repositiory

enum class Status{
    SUCCESS,
    FAILED,
    RUNNING
}
class PostListNetworkState(val status: Status, val msg: String) {

    companion object{
        val LOADED : PostListNetworkState
        val LOADING : PostListNetworkState
        val ERROR : PostListNetworkState

        init{
            LOADED = PostListNetworkState(Status.SUCCESS, "Success")
            LOADING = PostListNetworkState(Status.RUNNING, "Loading")
            ERROR = PostListNetworkState(Status.FAILED, "Something went wrong")
        }
    }
}