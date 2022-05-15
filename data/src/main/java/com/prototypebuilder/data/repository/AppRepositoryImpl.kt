/**
 * Author : Mani Shankar Kakumani,
 * Created on : 13 May, 2022.
 */

package com.prototypebuilder.data.repository

import com.prototypebuilder.data.datamapper.mapCacheListToDomainList
import com.prototypebuilder.data.datamapper.mapCacheToDomain
import com.prototypebuilder.data.datamapper.mapDomainToCache
import com.prototypebuilder.data.datasource.app.AppCacheDataSource
import com.prototypebuilder.domain.core.base.AppModel
import com.prototypebuilder.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val cacheDataSource: AppCacheDataSource,
) : AppRepository {
    override suspend fun getAppsList(): Flow<List<AppModel>> {
        return cacheDataSource.getAppsList().map {
            return@map it.mapCacheListToDomainList()
        }
    }

    override suspend fun getAppById(appId: Long): Flow<AppModel?> {
        return cacheDataSource.getAppById(appId).map {
            return@map it?.mapCacheToDomain()
        }
    }

    override suspend fun insertApp(appModel: AppModel): Boolean {
        return cacheDataSource.insertApp(appModel.mapDomainToCache())
    }

    override suspend fun deleteApp(appId: Long): Boolean {
        return cacheDataSource.deleteApp(appId)
    }
}