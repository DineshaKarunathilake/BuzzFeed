package me.projects.buzzfeed.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class HeadlineDao {

    private val headlineData = MutableLiveData<Headline>()

    fun getHeadlineData() = headlineData as LiveData<Headline>

}