package com.prototypebuilder.data.datasource.activity

import com.prototypebuilder.data.local.cache.activity.ActivityCache
import com.prototypebuilder.data.local.room.entity.RMActivityEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ActivityCDSImpl @Inject constructor(
    private val activityCache: ActivityCache
) : ActivityCDS {

    override suspend fun getActivityById(activityId: Long): Flow<RMActivityEntity?> {
        return activityCache.getActivityById(activityId)
    }

    override suspend fun getActivityList(): Flow<List<RMActivityEntity>> {
        return activityCache.getActivityList()
    }

    override suspend fun getActivityListByAppId(appId: Long): Flow<List<RMActivityEntity>> {
        return activityCache.getActivityListByAppId(appId)
    }

    override suspend fun insertActivity(rmActivityEntity: RMActivityEntity): Boolean {
        return activityCache.insertActivity(rmActivityEntity)
    }

    override suspend fun deleteActivity(activityId: Long): Boolean {
        return activityCache.deleteActivity(activityId)
    }

    override suspend fun deleteActivityByAppId(appId: Long): Boolean {
        return activityCache.deleteActivityByAppId(appId)
    }

}