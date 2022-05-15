package com.prototypebuilder.data.datasource.activity

import com.prototypebuilder.data.local.room.entity.RMActivityEntity
import kotlinx.coroutines.flow.Flow

interface ActivityCDS {
    suspend fun getActivityById(activityId: Long): Flow<RMActivityEntity?>
    suspend fun getActivityList(): Flow<List<RMActivityEntity>>
    suspend fun getActivityListByAppId(appId: Long): Flow<List<RMActivityEntity>>
    suspend fun insertActivity(rmActivityEntity: RMActivityEntity): Boolean
    suspend fun deleteActivity(activityId: Long): Boolean
}