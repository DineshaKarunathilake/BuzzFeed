package me.projects.buzzfeed.utilities

import me.projects.buzzfeed.data.HeadlineRepository
import me.projects.buzzfeed.ui.HeadlineViewModelFactory

object InjectorUtils {

    fun provideHeadlineViewModelFactory(): HeadlineViewModelFactory {
        // ViewModelFactory needs a repository, which in turn needs a DAO from a database
        // The whole dependency tree is constructed right here, in one place
        val headlineRepository = HeadlineRepository.getInstance()
        return HeadlineViewModelFactory(headlineRepository)
    }
}