package com.sunilkv.tmdbclient.data.model.tvshow
import com.google.gson.annotations.SerializedName
import com.sunilkv.tmdbclient.data.model.tvshow.TvShow

data class TvShowList(
    @SerializedName("results")
    val results: List<TvShow>
)