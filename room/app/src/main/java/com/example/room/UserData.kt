package com.example.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
@Dao
interface UserData{

   @Query("select * from user order by id Asc ")
   fun  getAllUser():LiveData<List<user>>
    @Insert
    suspend fun insertUser(user:user)
    @Update
    suspend fun updateUser(user:user)
    @Delete
    suspend fun deleteUser(user:user)

}