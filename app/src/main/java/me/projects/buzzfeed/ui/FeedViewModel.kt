package me.projects.buzzfeed.ui

import androidx.lifecycle.ViewModel
import me.projects.buzzfeed.data.FeedRepository

class FeedViewModel (private val feedRepository: FeedRepository): ViewModel() {

    fun getFeed() = feedRepository.getFeedData()

}