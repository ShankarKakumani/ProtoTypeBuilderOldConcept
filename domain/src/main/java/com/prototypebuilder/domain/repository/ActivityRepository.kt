package com.prototypebuilder.domain.repository

import com.prototypebuilder.domain.core.base.ActivityModel
import kotlinx.coroutines.flow.Flow

interface ActivityRepository {
    suspend fun getActivityById(activityId: Long): Flow<ActivityModel?>
    suspend fun getActivityList(): Flow<List<ActivityModel>>
    suspend fun getActivityListByAppId(appId: Long): Flow<List<ActivityModel>>
    suspend fun insertActivity(activityModel: ActivityModel): Boolean
    suspend fun deleteActivity(activityId: Long): Boolean
}