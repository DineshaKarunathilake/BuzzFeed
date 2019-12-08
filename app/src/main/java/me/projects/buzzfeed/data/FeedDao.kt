package me.projects.buzzfeed.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FeedDao {

    private val feedData = MutableLiveData<Feed>()

    fun getFeedData() = feedData as LiveData<Feed>

}