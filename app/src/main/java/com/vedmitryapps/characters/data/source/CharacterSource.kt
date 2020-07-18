package com.vedmitryapps.characters.data.source

import com.vedmitryapps.characters.network.response.CharacterResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface CharacterSource {

    fun getCharacters(page: Int) : Deferred<Response<CharacterResponse>>

}