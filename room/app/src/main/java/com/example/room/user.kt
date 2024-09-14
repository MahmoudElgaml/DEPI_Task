package com.example.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class user(
   @PrimaryKey(autoGenerate = true) val  id:Int,
    val name:String,
    val lastName:String,

)
