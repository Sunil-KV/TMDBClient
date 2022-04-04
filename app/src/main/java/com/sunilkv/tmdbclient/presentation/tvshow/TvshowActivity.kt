package com.sunilkv.tmdbclient.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sunilkv.tmdbclient.R
import com.sunilkv.tmdbclient.databinding.ActivityTvshowBinding
import com.sunilkv.tmdbclient.presentation.di.Injector
import com.sunilkv.tmdbclient.presentation.movie.TvshowAdaptor
import javax.inject.Inject

class TvshowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvshowViewModelFactory
    private lateinit var tvshowViewModel: TvshowViewModel
    private lateinit var adaptor: TvshowAdaptor

    private lateinit var binding:ActivityTvshowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tvshow)
        (application as Injector).createTvshowSubcomponent()
            .inject(this)
        tvshowViewModel = ViewModelProvider(this, factory)
            .get(TvshowViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.tvshowRecyclerView.layoutManager = LinearLayoutManager(this)
        adaptor = TvshowAdaptor()
        binding.tvshowRecyclerView.adapter = adaptor
        displayPopularTvshows()
    }

    private fun displayPopularTvshows(){
        binding.tvshowProgressBar.visibility = View.VISIBLE
        val responseLiveData= tvshowViewModel.getTvshows()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adaptor.setList(it)
                adaptor.notifyDataSetChanged()
                binding.tvshowProgressBar.visibility = View.GONE
            }else{
                binding.tvshowProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No Data Available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflator: MenuInflater = menuInflater
        inflator.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update ->{
                updateTvshows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateTvshows(){
        binding.tvshowProgressBar.visibility = View.VISIBLE
        val response = tvshowViewModel.updateTvshows()
        response.observe(this, Observer {
            if(it!=null){
                adaptor.setList(it)
                adaptor.notifyDataSetChanged()
                binding.tvshowProgressBar.visibility = View.GONE
            }else{
                binding.tvshowProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No Data Available", Toast.LENGTH_LONG).show()
            }
        })
    }
}