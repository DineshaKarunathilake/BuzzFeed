package me.projects.buzzfeed.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import me.projects.buzzfeed.ui.FeedActivity
import me.projects.buzzfeed.util.DataReaderUtil


class FeedRepository private constructor(val dataReaderUtil: DataReaderUtil) {

    private var gson: Gson? = null
    private var feed = MutableLiveData<Feed?>()

    companion object {

        @Volatile
        private var instance: FeedRepository? = null

        fun getInstance(dataReaderUtil: DataReaderUtil) =
            instance ?: synchronized(this) {
                instance ?: FeedRepository(dataReaderUtil).also { instance = it }
            }
    }

    fun getFeedData(): LiveData<Feed> {

        val gsonBuilder = GsonBuilder()
        gson = gsonBuilder.create()

        feed = MutableLiveData(gson?.fromJson(dataReaderUtil.getFeedDataFromFile(), Feed::class.java))

        return feed as LiveData<Feed>
    }

    private fun getFeedString(): String? {
        val text = FeedActivity.context?.assets?.open("feed.json")?.bufferedReader().use {it?.readText()}

        return text
    }

}