package com.example.fire_base

import javax.inject.Inject

class AlbumRepo @Inject constructor(
    private  val  apiService: ApiService
) {
   suspend fun getList():List<Albums>{
        return apiService.getAlbumList()
    }
}