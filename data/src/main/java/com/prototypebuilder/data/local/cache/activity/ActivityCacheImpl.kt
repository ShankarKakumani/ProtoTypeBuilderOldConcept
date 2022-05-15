package com.prototypebuilder.data.local.cache.activity

import com.prototypebuilder.data.local.room.dao.ActivityDao
import com.prototypebuilder.data.local.room.entity.RMActivityEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ActivityCacheImpl @Inject constructor(
    private val activityDao: ActivityDao
) : ActivityCache {
    override suspend fun getActivityById(activityId: Long): Flow<RMActivityEntity?> {
        return activityDao.getActivityById(activityId)
    }

    override suspend fun getActivityList(): Flow<List<RMActivityEntity>> {
        return activityDao.getActivityList().map {
            return@map it ?: emptyList()
        }
    }

    override suspend fun getActivityListByAppId(appId: Long): Flow<List<RMActivityEntity>> {
        return activityDao.getActivityListByAppId(appId).map {
            return@map it ?: emptyList()
        }
    }

    override suspend fun insertActivity(rmActivityEntity: RMActivityEntity): Boolean {
        val insert = activityDao.insertActivity(rmActivityEntity)
        return insert > 0
    }

    override suspend fun deleteActivity(activityId: Long): Boolean {
        val delete = activityDao.deleteActivityById(activityId)
        return delete > 0
    }

    override suspend fun deleteActivityByAppId(appId: Long): Boolean {
        val delete = activityDao.deleteActivityByAppId(appId)
        return delete > 0
    }

}