package com.tbashish.startupstoriesmvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tbashish.startupstoriesmvvm.adapter.PostListAdapter
import com.tbashish.startupstoriesmvvm.model.Post
import com.tbashish.startupstoriesmvvm.viewmodel.PostListViewModel
import com.tbashish.startupstoriesmvvm.viewmodel.PostListViewModelFactory
import kotlinx.android.synthetic.main.fragment_posts.*

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
        initData()
        initViewModelObserver()
        initAdapter()
    }

    private lateinit var postListViewModel: PostListViewModel
    private fun initViewModel(){
        postListViewModel = ViewModelProviders.of(this, PostListViewModelFactory())
                .get(PostListViewModel::class.java)
        println("initviewmodel")
    }

    private fun initData(){
        postListViewModel.getPostList()
    }

    private fun initViewModelObserver(){
        postListViewModel.postList.observe(viewLifecycleOwner, {
            onGetPostListResponse(it)
        })
    }

    private lateinit var linearLayoutManager: LinearLayoutManager
    val adapter = PostListAdapter()
    private fun initAdapter() {
        println("initadapter")
        linearLayoutManager = LinearLayoutManager(activity , RecyclerView.VERTICAL , false)
        postsRecycler.adapter = adapter
        postsRecycler.layoutManager = linearLayoutManager
    }

    private fun onGetPostListResponse(resultResponse : List<Post>?){
        if (resultResponse != null) {
            adapterListSubmit(resultResponse)
        }
    }

    lateinit var data : ArrayList<*>
    private fun adapterListSubmit(resultResponse: List<Post>?){
        data = resultResponse as ArrayList<*>
        adapter.submitList(data)
    }


}