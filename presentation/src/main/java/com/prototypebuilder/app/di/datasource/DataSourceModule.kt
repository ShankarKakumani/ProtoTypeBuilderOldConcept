package com.prototypebuilder.app.di.datasource

import com.prototypebuilder.data.datasource.AppCacheDataSource
import com.prototypebuilder.data.datasource.AppCacheDataSourceImpl
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

}