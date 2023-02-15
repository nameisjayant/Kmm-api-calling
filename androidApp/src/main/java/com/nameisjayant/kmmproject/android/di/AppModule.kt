package com.nameisjayant.kmmproject.android.di

import com.nameisjayant.kmmproject.android.feature.ui.viewmodel.PostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        PostViewModel(get())
    }
}