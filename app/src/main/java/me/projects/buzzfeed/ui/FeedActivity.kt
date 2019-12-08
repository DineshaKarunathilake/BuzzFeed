package me.projects.buzzfeed.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_feed.*
import me.projects.buzzfeed.R
import me.projects.buzzfeed.data.Teaser
import me.projects.buzzfeed.factory.ViewModelFactory
import kotlin.properties.Delegates
import android.content.Context


class FeedActivity : AppCompatActivity() {

    private var teaserAdapter: TeaserAdapter by Delegates.notNull()
    private val mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(me.projects.buzzfeed.R.layout.activity_feed)
        displayFeed()
    }

    private fun displayFeed() {
        val factory = ViewModelFactory.provideFeedViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(FeedViewModel::class.java)

        viewModel.getFeed().observe(this, Observer { feed ->
            feedTitle.text = feed.name
            setUpTeasersRecyclerView(feed.teasers)
        })


    }

    private fun setUpTeasersRecyclerView (teasers: List<Teaser>) {
        val manager = LinearLayoutManager(this)
        teaserAdapter = TeaserAdapter(teasers)
        teasersRecyclerView.layoutManager = manager
        teasersRecyclerView.adapter = teaserAdapter
    }
}
