package com.vedmitryapps.characters.base.activity

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.vedmitryapps.characters.di.Injectable
import javax.inject.Inject


abstract class BaseActivity : FragmentActivity(), Injectable {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

}