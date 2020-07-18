package com.vedmitryapps.characters.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vedmitryapps.characters.data.source.CharacterSource
import com.vedmitryapps.characters.network.response.Character
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(val characterSource: CharacterSource) : ViewModel() {

    val allCharacters = MutableLiveData<List<Character>>()
    val newCharacterItems = MutableLiveData<List<Character>?>()
    val totalItems = MutableLiveData<Int>()

    fun getCharacters(page: Int) {
        viewModelScope.launch {
            val response = characterSource.getCharacters(page).await()
            if (response.isSuccessful) {
                response.body()?.let {
                    newCharacterItems.postValue(it.results)
                    totalItems.postValue(it.info.count)
                }
            }
        }
    }

}