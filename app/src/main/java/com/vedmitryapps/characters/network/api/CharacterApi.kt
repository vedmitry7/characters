package com.vedmitryapps.characters.network.api

import com.vedmitryapps.characters.network.response.CharacterResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET("api/character/")
    fun getCharacters(
        @Query("page") page: Int?
    ): Deferred<Response<CharacterResponse>>

}