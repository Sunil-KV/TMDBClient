package com.sunilkv.tmdbclient.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sunilkv.tmdbclient.R
import com.sunilkv.tmdbclient.data.model.movie.Movie
import com.sunilkv.tmdbclient.data.model.tvshow.TvShow
import com.sunilkv.tmdbclient.databinding.ListItemBinding

class TvshowAdaptor(): RecyclerView.Adapter<TvshowViewHolder>() {
    private val tvshowList = ArrayList<TvShow>()

    fun setList(tvshows:List<TvShow>){
        tvshowList.clear()
        tvshowList.addAll(tvshows)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvshowViewHolder {
        val layoutInflator:LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflator,
            R.layout.list_item,
            parent,
            false
        )
        return TvshowViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tvshowList.size
    }

    override fun onBindViewHolder(holder: TvshowViewHolder, position: Int) {
        holder.bind(tvshowList[position])
    }
}

class TvshowViewHolder(val binding: ListItemBinding):
    RecyclerView.ViewHolder(binding.root){

    fun bind(tvshows:TvShow){
        binding.titleTextView.text = tvshows.name
        binding.descriptionTextView.text=tvshows.overview
        val posterURL = "https://image.tmdb.org/t/p/w500"+tvshows.posterPath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)
    }
}