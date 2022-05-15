/**
 * Author : Mani Shankar Kakumani,
 * Created on : 13 May, 2022.
 */

package com.prototypebuilder.domain.repository

import com.prototypebuilder.domain.core.base.AppModel
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    suspend fun getAppsList(): Flow<List<AppModel>>
    suspend fun getAppById(appId: Long): Flow<AppModel?>
    suspend fun insertApp(appModel: AppModel) : Boolean
    suspend fun deleteApp(appId: Long) : Boolean
}