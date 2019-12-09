package me.projects.buzzfeed.factory

import me.projects.buzzfeed.data.FeedRepository
import me.projects.buzzfeed.ui.FeedViewModelFactory
import me.projects.buzzfeed.util.DataReaderUtil

object ViewModelFactory {

    fun provideFeedViewModelFactory(): FeedViewModelFactory {
        val feedRepository = FeedRepository.getInstance(DataReaderUtil())
        return FeedViewModelFactory(feedRepository)
    }
}