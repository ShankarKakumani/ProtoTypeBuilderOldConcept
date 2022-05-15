/**
 * Author : Mani Shankar Kakumani,
 * Created on : 13 May, 2022.
 */

package com.prototypebuilder.data.datamapper

import com.prototypebuilder.data.local.room.entity.RMActivityEntity
import com.prototypebuilder.data.local.room.entity.RMAppEntity
import com.prototypebuilder.domain.core.base.ActivityModel
import com.prototypebuilder.domain.core.base.AppModel


fun List<ActivityModel>.mapDomainListToCacheList(): List<RMActivityEntity> {
    return this.map {
        return@map it.mapDomainToCache()
    }
}

fun List<RMActivityEntity>.mapCacheListToDomainList(): List<ActivityModel> {
    return this.map {
        return@map it.mapCacheToDomain()
    }
}

fun RMActivityEntity.mapCacheToDomain(): ActivityModel {
    return ActivityModel(
        activityId = activityId,
        activityName = activityName,
        appId = appId,
        background = background,
        statusBarColor = statusBarColor,
        statusBarDarkIcons = statusBarDarkIcons,
        navigationBarColor = navigationBarColor,
        navigationBarDarkIcons = navigationBarDarkIcons
    )
}

fun ActivityModel.mapDomainToCache(): RMActivityEntity {
    return RMActivityEntity(
        activityId = activityId,
        activityName = activityName,
        appId = appId,
        background = background,
        statusBarColor = statusBarColor,
        statusBarDarkIcons = statusBarDarkIcons,
        navigationBarColor = navigationBarColor,
        navigationBarDarkIcons = navigationBarDarkIcons,
    )
}
