package com.sunilkv.tmdbclient.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sunilkv.tmdbclient.R
import com.sunilkv.tmdbclient.databinding.ActivityHomeBinding
import com.sunilkv.tmdbclient.presentation.artist.ArtistActivity
import com.sunilkv.tmdbclient.presentation.movie.MovieActivity
import com.sunilkv.tmdbclient.presentation.tvshow.TvshowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.movieButton.setOnClickListener{
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }
        binding.artistsButton.setOnClickListener {
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }
        binding.tvshowButton.setOnClickListener {
            val intent = Intent(this, TvshowActivity::class.java)
            startActivity(intent)
        }
    }
}