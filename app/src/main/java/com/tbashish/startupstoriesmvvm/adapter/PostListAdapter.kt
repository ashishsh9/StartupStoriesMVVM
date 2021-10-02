package com.tbashish.startupstoriesmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tbashish.startupstoriesmvvm.R
import com.tbashish.startupstoriesmvvm.model.Post

class PostListAdapter : ListAdapter<Any, RecyclerView.ViewHolder> (PostListDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListViewHolder {
        print("On create ViewHolder")
        var viewHolder : RecyclerView.ViewHolder? = null
        val inflater = LayoutInflater.from(parent.context)
        when(viewType){
            R.layout.postcard -> viewHolder = PostListViewHolder.create(inflater, parent)
        }
        return  (viewHolder as PostListViewHolder?)!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        print("On BindViewHOlder")
        val item = getItem(position)
        when(holder){
            is PostListViewHolder -> holder.bind(item as Post)
        }
    }

    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        val item = getItem(position)
        var itemViewType = 0
        when(item){
            is Post -> itemViewType = R.layout.postcard
        }
        return itemViewType
    }

    public override fun getItem(position: Int): Any {
        return super.getItem(position)
    }


}