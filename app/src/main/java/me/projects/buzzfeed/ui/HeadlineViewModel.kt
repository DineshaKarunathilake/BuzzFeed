package me.projects.buzzfeed.ui

import androidx.lifecycle.ViewModel
import me.projects.buzzfeed.data.HeadlineRepository

class HeadlineViewModel (private val headlineRepository: HeadlineRepository): ViewModel() {

    fun getHeadline() = headlineRepository.getHeadlineData()

}