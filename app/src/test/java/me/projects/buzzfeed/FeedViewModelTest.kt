package me.projects.buzzfeed

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import me.projects.buzzfeed.data.Feed
import me.projects.buzzfeed.data.FeedRepository
import me.projects.buzzfeed.ui.FeedViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

class FeedViewModelTest  {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: FeedViewModel

    private val observer: Observer<Feed> = mock()

    @Before
    fun before() {
        viewModel = FeedViewModel(FeedRepository.getInstance())
        viewModel.getFeed().observeForever(observer)
    }

    @Test
    fun getHeadline() {
        val captor = ArgumentCaptor.forClass(Feed::class.java)
        captor.run {
            verify(observer, times(1)).onChanged(capture())
            assertEquals("Headlines", value.name)
        }
    }

    @Test
    fun testTeasersNotNull() {
        val captor = ArgumentCaptor.forClass(Feed::class.java)
        captor.run {
            verify(observer, times(1)).onChanged(capture())
            assertNotNull(value.teasers)
        }
    }
}