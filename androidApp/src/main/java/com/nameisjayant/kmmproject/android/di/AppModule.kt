package com.nameisjayant.kmmproject.android.di

import com.nameisjayant.kmmproject.android.feature.ui.viewmodel.CatViewModel
import com.nameisjayant.kmmproject.android.feature.ui.viewmodel.PostViewModel
import com.nameisjayant.kmmproject.data.repository.CatRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        PostViewModel(get())
    }
    viewModel {
        CatViewModel(get())
    }
}