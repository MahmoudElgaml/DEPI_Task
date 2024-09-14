package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel :ViewModel(){
    private var  _score1=MutableLiveData<Int>()

    val score1 :MutableLiveData<Int> get()=_score1
    private  var _score2=MutableLiveData<Int>()
    val score2 :MutableLiveData<Int> get()=_score2

    fun increamentTeam1(){
        val current=_score1.value?:0
        _score1.value= current+1
    }
    fun increamentTeam2(){
        val current=_score2.value?:0
        _score2.value= current+1
    }




}