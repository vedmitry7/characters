package com.vedmitryapps.characters.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.vedmitryapps.characters.R
import com.vedmitryapps.characters.base.activity.BaseActivity
import com.vedmitryapps.characters.di.Injectable
import com.vedmitryapps.characters.network.response.Character
import com.vedmitryapps.characters.presentation.support.CharacterAdapter
import dagger.android.DispatchingAndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity(), Injectable {

    @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    lateinit var mainViewModel: MainViewModel
    lateinit var adapter : CharacterAdapter
    var currentPage = 0
    lateinit var layoutManager : LinearLayoutManager
    var isLoading = false

    var charactersObserver = Observer<List<Character>?> {
        it?.let {list -> adapter.addItems(list) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        setupViews()

        mainViewModel.newCharacterItems.observe(this, charactersObserver)

        mainViewModel.getCharacters(currentPage)
    }



    private fun setupViews() {
        adapter = CharacterAdapter()
        layoutManager = LinearLayoutManager(this)
        recycler_view_MA.layoutManager = layoutManager
        recycler_view_MA.adapter = adapter

       /* recycler_view_MA.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (mIsLoading) return
                val visibleItemCount: Int = layoutManager.childCount
                val totalItemCount: Int = layoutManager.itemCount
                val pastVisibleItems: Int = layoutManager.findFirstVisibleItemPosition()
                if (pastVisibleItems + visibleItemCount >= totalItemCount) {
                    if ((adapter.itemCount < mainViewModel.totalItems.value!!)) {
                        currentPage++
                        mainViewModel.getCharacters(currentPage)
                    }
                }
            }
        })*/
    }

}

