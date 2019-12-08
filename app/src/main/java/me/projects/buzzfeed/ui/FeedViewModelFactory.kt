package me.projects.buzzfeed.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.projects.buzzfeed.data.FeedRepository

class FeedViewModelFactory (private val feedRepository: FeedRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FeedViewModel(feedRepository) as T
    }
}