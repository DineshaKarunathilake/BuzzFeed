package me.projects.buzzfeed

import androidx.lifecycle.ViewModelProviders
import me.projects.buzzfeed.data.HeadlineRepository
import me.projects.buzzfeed.ui.HeadlineViewModel
import me.projects.buzzfeed.utilities.InjectorUtils
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {


    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

//    @Test
//    fun jsonParsingIsCorrect() {
//
//        var headlineData = HeadlineRepository.getInstance().getHeadlineData()
//        assertEquals("Headlines", headlineData)
//
//    }


    @Test
    fun viewModelTest() {

//        val factory = InjectorUtils.provideHeadlineViewModelFactory()
//        val viewModel = ViewModelProviders.of(, factory)
//            .get(HeadlineViewModel::class.java)
//

    }
}
