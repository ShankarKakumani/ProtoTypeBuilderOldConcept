/**
 * Author : Mani Shankar Kakumani,
 * Created on : 13 May, 2022.
 */

package com.prototypebuilder.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.prototypebuilder.data.local.room.entity.RMAppEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertApp(rmAppEntity: RMAppEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertApp(rmAppListEntity: List<RMAppEntity>)

    @Query("SELECT * FROM tableAppsList")
    fun getApps(): Flow<List<RMAppEntity>?>

    @Query("SELECT * FROM tableAppsList where appId = :appId")
    fun getAppById(appId: Long): Flow<RMAppEntity?>

    @Query("DELETE FROM tableAppsList where appId =:appId")
    suspend fun deleteAppById(appId: Long) : Int

    @Query("DELETE FROM tableAppsList")
    suspend fun deleteAll()
}