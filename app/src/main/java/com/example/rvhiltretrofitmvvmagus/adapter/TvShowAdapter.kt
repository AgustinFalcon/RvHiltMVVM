package com.example.rvhiltretrofitmvvmagus.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rvhiltretrofitmvvmagus.databinding.ItemRecyclerviewBinding
import com.example.rvhiltretrofitmvvmagus.models.TvShowItem


class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.MyViewHolder>(){

    //Capture a item_recyclerview for the binding
    inner class MyViewHolder(val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root){

    }

    private val diffCallback = object : DiffUtil.ItemCallback<TvShowItem>(){
        override fun areItemsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var tvShows: List<TvShowItem>
    get() = differ.currentList
    set(value) = differ.submitList(value)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTvShow = tvShows[position]

        holder.binding.apply {

            tvTitle.text = currentTvShow.name
            ivFoto.load(currentTvShow.image.original){
                crossfade(true)
                crossfade(1000)
            }

        }
    }

    override fun getItemCount(): Int = tvShows.size
}

