package com.prototypebuilder.app.di.datasource

import com.prototypebuilder.data.datasource.activity.ActivityCDS
import com.prototypebuilder.data.datasource.activity.ActivityCDSImpl
import com.prototypebuilder.data.datasource.app.AppCacheDataSource
import com.prototypebuilder.data.datasource.app.AppCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideAppCacheDataSource(appCacheDataSourceImpl: AppCacheDataSourceImpl): AppCacheDataSource {
        return appCacheDataSourceImpl
    }

    @Singleton
    @Provides
    fun provideActivityCDS(activityCDSImpl: ActivityCDSImpl): ActivityCDS {
        return activityCDSImpl
    }

}