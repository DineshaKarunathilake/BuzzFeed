package me.projects.buzzfeed

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import me.projects.buzzfeed.data.Feed
import me.projects.buzzfeed.data.FeedRepository
import me.projects.buzzfeed.ui.FeedViewModel
import me.projects.buzzfeed.util.DataReaderUtil
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

class FeedViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: FeedViewModel

    private val observer: Observer<Feed> = mock()

    var mockDataReaderUtil: DataReaderUtil = Mockito.mock(DataReaderUtil::class.java)

    @Before
    fun before() {
        setMockDataReader()
        viewModel = FeedViewModel(FeedRepository.getInstance(mockDataReaderUtil))
        viewModel.getFeed().observeForever(observer)
    }

    @Test
    fun testHeadline() {
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

    private fun setMockDataReader() {

        val mockFeedData = "{\n" +
                "  \"name\": \"Headlines\",\n" +
                "  \"teasers\": [\n" +
                "    {\n" +
                "      \"title\": \"»Jeder einzelne Tag \\nmeines Lebens war schlecht\",\n" +
                "      \"text\": \"Wenn stimmt, was in ihrem Pass eingetragen ist, wird die Tschetschenin\n" +
                "      nächsten Monat 129 Jahre alt. Mit Dankbarkeit erfüllt sie das nicht.\",\n" +
                "      \"isPaid\": true,\n" +
                "      \"type\": \"teaser\"\n" +
                "    }\n" +
                "  ]\n" +
                "}"


        Mockito.`when`(mockDataReaderUtil.getFeedDataFromFile()).thenReturn(mockFeedData)

    }
}