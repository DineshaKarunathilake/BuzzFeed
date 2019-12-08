package me.projects.buzzfeed.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.projects.buzzfeed.data.HeadlineRepository

class HeadlineViewModelFactory (private val headlineRepository: HeadlineRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HeadlineViewModel(headlineRepository) as T
    }
}