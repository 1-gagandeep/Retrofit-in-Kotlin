package com.example.retrofitexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PostsViewModelFactory(
    private val repo: Repo
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostsViewModel(repo) as T
    }
}