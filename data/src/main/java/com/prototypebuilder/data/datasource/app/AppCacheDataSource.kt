/**
 * Author : Mani Shankar Kakumani,
 * Created on : 13 May, 2022.
 */

package com.prototypebuilder.data.datasource.app

import com.prototypebuilder.data.local.room.entity.RMAppEntity
import kotlinx.coroutines.flow.Flow

interface AppCacheDataSource {

    suspend fun getAppsList(): Flow<List<RMAppEntity>>
    suspend fun getAppById(appId: Long): Flow<RMAppEntity?>
    suspend fun insertApp(rmAppEntity: RMAppEntity): Boolean
    suspend fun deleteApp(appId: Long) : Boolean

}