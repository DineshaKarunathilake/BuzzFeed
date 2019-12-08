package me.projects.buzzfeed

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import me.projects.buzzfeed.data.Headline
import me.projects.buzzfeed.data.HeadlineRepository
import me.projects.buzzfeed.ui.HeadlineViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

class HeadlineViewModelTest  {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: HeadlineViewModel

    private val observer: Observer<Headline> = mock()

    @Before
    fun before() {
        viewModel = HeadlineViewModel(HeadlineRepository.getInstance())
        viewModel.getHeadline().observeForever(observer)
    }

    @Test
    fun getHeadline() {
        val captor = ArgumentCaptor.forClass(Headline::class.java)
        captor.run {
            verify(observer, times(1)).onChanged(capture())
            assertEquals("Headlines", value.name)
        }
    }

    @Test
    fun testTeasersNotNull() {
        val captor = ArgumentCaptor.forClass(Headline::class.java)
        captor.run {
            verify(observer, times(1)).onChanged(capture())
            assertNotNull(value.teasers)
        }
    }
}