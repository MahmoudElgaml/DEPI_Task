package com.example.fire_base

import retrofit2.http.GET

interface ApiService {
    @GET("albums")
suspend fun getAlbumList():List<Albums>
}