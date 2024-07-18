package com.example.retrofitexample

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitexample.data.RetrofitBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var postsViewModel: PostsViewModel
    private lateinit var postsViewModelFactory: PostsViewModelFactory
    private lateinit var repo: Repo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        init()

        postsViewModel.postsLiveData.observe(this) {
            // we can use sampleJsonModel as we want
            Log.i("postsLiveData",it.toString())
        }
    }

    private fun init() {
        repo = Repo(RetrofitBuilder.getInstance())
        postsViewModelFactory = PostsViewModelFactory(repo)
        postsViewModel = ViewModelProvider(this, postsViewModelFactory).get(PostsViewModel::class.java)
    }

}