package com.vedmitryapps.characters.di.module


import com.vedmitryapps.characters.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity
}