package com.vedmitryapps.characters.data.repository

import com.vedmitryapps.characters.data.source.CharacterSource
import com.vedmitryapps.characters.network.api.CharacterApi
import com.vedmitryapps.characters.network.response.CharacterResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response

class CharacterRepository (val characterApi: CharacterApi) : CharacterSource {

    override fun getCharacters(page: Int): Deferred<Response<CharacterResponse>> {

        return characterApi.getCharacters(page)
    }
}