package com.prototypebuilder.app.di.repository

import com.prototypebuilder.data.repository.AppRepositoryImpl
import com.prototypebuilder.domain.repository.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideAppRepository(appRepositoryImpl: AppRepositoryImpl): AppRepository {
        return appRepositoryImpl
    }

}