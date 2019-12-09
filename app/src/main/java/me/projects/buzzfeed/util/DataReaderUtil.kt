package me.projects.buzzfeed.util

import me.projects.buzzfeed.ui.FeedActivity

open class DataReaderUtil {

        fun getFeedDataFromFile () = FeedActivity.context?.assets?.
                open("feed.json")?.bufferedReader().use {it?.readText()}

}