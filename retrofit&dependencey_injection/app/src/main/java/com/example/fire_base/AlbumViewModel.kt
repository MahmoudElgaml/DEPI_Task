package com.example.fire_base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class AlbumViewModel @Inject constructor(
    private  val albumRepo: AlbumRepo
):ViewModel() {
init {
    getData()
}

    private  val albumList=MutableLiveData<List<Albums>>()
    val album:LiveData<List<Albums>> = albumList

    fun getData(){
        viewModelScope.launch {
            val response=albumRepo.getList()
            albumList.postValue(response)
        }
    }

}