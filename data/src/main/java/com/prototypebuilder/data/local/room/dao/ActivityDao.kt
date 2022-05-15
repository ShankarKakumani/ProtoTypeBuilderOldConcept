/**
 * Author : Mani Shankar Kakumani,
 * Created on : 13 May, 2022.
 */

package com.prototypebuilder.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.prototypebuilder.data.local.room.entity.RMActivityEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ActivityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertActivity(rmActivityEntity: RMActivityEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertActivity(rmActivityListEntity: List<RMActivityEntity>)

    @Query("SELECT * FROM tableActivityList")
    fun getActivityList(): Flow<List<RMActivityEntity>?>

    @Query("SELECT * FROM tableActivityList where activityId = :activityId")
    fun getActivityById(activityId: Long): Flow<RMActivityEntity?>

    @Query("SELECT * FROM tableActivityList where appId = :appId")
    fun getActivityListByAppId(appId: Long): Flow<List<RMActivityEntity>?>

    @Query("DELETE FROM tableActivityList where activityId =:activityId")
    suspend fun deleteActivityById(activityId: Long): Int

    @Query("DELETE FROM tableActivityList where appId = :appId")
    suspend fun deleteActivityByAppId(appId: Long) : Int

    @Query("DELETE FROM tableActivityList")
    suspend fun deleteAll()
}