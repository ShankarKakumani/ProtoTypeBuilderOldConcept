package dev.shankarkakumani.data.repository

interface ProtoTypeRepository {

    suspend fun getAppsList()
    suspend fun getScreensListByAppId(appId: String)
}