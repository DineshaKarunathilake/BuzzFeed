package me.projects.buzzfeed.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_headline.*
import me.projects.buzzfeed.R
import me.projects.buzzfeed.data.Teaser
import me.projects.buzzfeed.utilities.InjectorUtils
import kotlin.properties.Delegates

class HeadlineActivity : AppCompatActivity() {

    private var teaserAdapter: TeaserAdapter by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_headline)
        displayHeadline()
    }

    private fun displayHeadline() {
        val factory = InjectorUtils.provideHeadlineViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(HeadlineViewModel::class.java)

        viewModel.getHeadline().observe(this, Observer { headline ->
            headlineTitle.setText(headline.name)
            setUpTeasersRecyclerView(headline.teasers)
        })


    }

    private fun setUpTeasersRecyclerView (teasers: List<Teaser>) {
        val manager = LinearLayoutManager(this)
        teaserAdapter = TeaserAdapter(teasers)
        teasersRecyclerView.layoutManager = manager
        teasersRecyclerView.adapter = teaserAdapter
    }
}
