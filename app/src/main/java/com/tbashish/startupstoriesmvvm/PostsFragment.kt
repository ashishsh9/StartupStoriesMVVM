package com.tbashish.startupstoriesmvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.*
import com.tbashish.startupstoriesmvvm.viewmodel.PostListViewModel
import com.tbashish.startupstoriesmvvm.viewmodel.PostListViewModelFactory

class PostsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }


    companion object {
        fun newInstance() = PostsFragment()

    }

    private fun init(){
        initViewModel()
    }

    private lateinit var postListViewModel: PostListViewModel
    private fun initViewModel(){
        postListViewModel = ViewModelProviders.of(this, PostListViewModelFactory())
                .get(PostListViewModel::class.java)
        println("initviewmodel")


    }
}