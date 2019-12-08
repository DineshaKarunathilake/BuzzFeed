package me.projects.buzzfeed.factory

import me.projects.buzzfeed.data.FeedRepository
import me.projects.buzzfeed.ui.FeedViewModelFactory

object ViewModelFactory {

    fun provideFeedViewModelFactory(): FeedViewModelFactory {
        val feedRepository = FeedRepository.getInstance()
        return FeedViewModelFactory(feedRepository)
    }
}