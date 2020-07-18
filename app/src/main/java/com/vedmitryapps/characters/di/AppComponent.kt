package com.vedmitryapps.characters.di

import com.vedmitryapps.characters.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import com.vedmitryapps.characters.di.module.DataModule
import com.vedmitryapps.characters.di.module.MainActivityModule
import com.vedmitryapps.characters.di.module.ViewModelModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ViewModelModule::class,
        DataModule::class,
        MainActivityModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}