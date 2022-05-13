/**
 * Author : Mani Shankar Kakumani,
 * Created on : 13 May, 2022.
 */

package com.prototypebuilder.data.datasource

import com.prototypebuilder.data.local.cache.app.AppCache
import com.prototypebuilder.data.local.room.entity.RMAppEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppCacheDataSourceImpl @Inject constructor(
    private val appCache: AppCache
) : AppCacheDataSource {
    override suspend fun getAppsList(): Flow<List<RMAppEntity>> {
        return appCache.getAppsList()
    }

    override suspend fun getAppById(appId: Int): RMAppEntity? {
        return appCache.getAppById(appId)
    }

    override suspend fun insertApp(rmAppEntity: RMAppEntity): Boolean {
        return appCache.insertApp(rmAppEntity)
    }

    override suspend fun deleteApp(appId: Int): Boolean {
        return appCache.deleteApp(appId)
    }

}