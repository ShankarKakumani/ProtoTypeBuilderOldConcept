/**
 * Author : Mani Shankar Kakumani,
 * Created on : 13 May, 2022.
 */

package com.prototypebuilder.data.datamapper

import com.prototypebuilder.data.local.room.entity.RMAppEntity
import com.prototypebuilder.domain.core.base.AppModel

fun RMAppEntity.mapCacheToDomain(): AppModel {
    return AppModel(
        appName = appName,
        appId = appId
    )
}

fun List<AppModel>.mapDomainListToCacheList(): List<RMAppEntity> {
    return this.map {
        return@map it.mapDomainToCache()
    }
}

fun AppModel.mapDomainToCache(): RMAppEntity {
    return RMAppEntity(
        appName = appName
    )
}


fun List<RMAppEntity>.mapCacheListToDomainList(): List<AppModel> {
    return this.map {
        return@map it.mapCacheToDomain()
    }
}


