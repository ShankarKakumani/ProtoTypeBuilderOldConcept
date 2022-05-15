/**
 * Author : Mani Shankar Kakumani,
 * Created on : 13 May, 2022.
 */

package com.prototypebuilder.data.local.cache.app

import androidx.annotation.WorkerThread
import com.prototypebuilder.data.local.room.dao.AppDao
import com.prototypebuilder.data.local.room.entity.RMAppEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppCacheImpl @Inject constructor(
    private val appDao: AppDao,
) : AppCache {
    override suspend fun getAppsList(): Flow<List<RMAppEntity>> {
        return appDao.getApps().map {
            return@map it ?: emptyList()
        }.distinctUntilChanged()
    }

    override suspend fun getAppById(appId: Long): Flow<RMAppEntity?> {
        return appDao.getAppById(appId)
    }

    @WorkerThread
    override suspend fun insertApp(rmAppEntity: RMAppEntity): Boolean {
        val insert = appDao.insertApp(rmAppEntity)
        return insert > 0
    }

    override suspend fun deleteApp(appId: Long): Boolean {
        val delete = appDao.deleteAppById(appId)
        return delete > 0
    }

}