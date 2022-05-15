package com.prototypebuilder.app.di.cache

import com.prototypebuilder.data.local.cache.activity.ActivityCache
import com.prototypebuilder.data.local.cache.activity.ActivityCacheImpl
import com.prototypebuilder.data.local.cache.app.AppCache
import com.prototypebuilder.data.local.cache.app.AppCacheImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideAppCache(appCacheImpl: AppCacheImpl): AppCache {
        return appCacheImpl
    }


    @Singleton
    @Provides
    fun provideActivityCache(activityCacheImpl: ActivityCacheImpl): ActivityCache {
        return activityCacheImpl
    }

}