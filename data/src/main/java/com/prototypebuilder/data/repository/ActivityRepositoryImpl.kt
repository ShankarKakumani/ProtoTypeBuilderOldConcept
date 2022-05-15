package com.prototypebuilder.data.repository

import com.prototypebuilder.data.datamapper.mapCacheListToDomainList
import com.prototypebuilder.data.datamapper.mapCacheToDomain
import com.prototypebuilder.data.datamapper.mapDomainToCache
import com.prototypebuilder.data.datasource.activity.ActivityCDS
import com.prototypebuilder.domain.core.base.ActivityModel
import com.prototypebuilder.domain.repository.ActivityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ActivityRepositoryImpl @Inject constructor(
    private val activityCDS: ActivityCDS
) : ActivityRepository {

    override suspend fun getActivityById(activityId: Long): Flow<ActivityModel?> {
        return activityCDS.getActivityById(activityId).map {
            return@map it?.mapCacheToDomain()
        }
    }

    override suspend fun getActivityList(): Flow<List<ActivityModel>> {
        return activityCDS.getActivityList().map {
            return@map it.mapCacheListToDomainList()
        }
    }

    override suspend fun getActivityListByAppId(appId: Long): Flow<List<ActivityModel>> {
        return activityCDS.getActivityListByAppId(appId).map {
            return@map it.mapCacheListToDomainList()
        }
    }

    override suspend fun insertActivity(activityModel: ActivityModel): Boolean {
        return activityCDS.insertActivity(activityModel.mapDomainToCache())
    }

    override suspend fun deleteActivity(activityId: Long): Boolean {
        return activityCDS.deleteActivity(activityId)
    }

}