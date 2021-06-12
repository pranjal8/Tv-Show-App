package com.pranjal.moviebag.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.pranjal.moviebag.databinding.TvShowLayoutAdapterBinding
import com.pranjal.moviebag.model.TvShowItems

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.MyViewHolder>() {

    inner class MyViewHolder(var binding : TvShowLayoutAdapterBinding) :
        RecyclerView.ViewHolder(binding.root)

        private val diffCallback = object : DiffUtil.ItemCallback<TvShowItems>() {
            override fun areItemsTheSame(oldItem: TvShowItems, newItem: TvShowItems): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvShowItems, newItem: TvShowItems): Boolean {
                return newItem == oldItem
            }
        }

    private val differ = AsyncListDiffer(this, diffCallback)
    var tvShows: List<TvShowItems>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            TvShowLayoutAdapterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTvShow = tvShows[position]

        holder.binding.apply {
            textView.text = currentTvShow.name

            imageView.load(currentTvShow.image.original) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun getItemCount()= tvShows.size
}