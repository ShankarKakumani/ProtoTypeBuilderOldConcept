package dev.shankarkakumani.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.shankarkakumani.data.repository.ProtoTypeRepository
import dev.shankarkakumani.data.repository.PrototypeRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun provideProtoTypeRepo(prototypeRepositoryImpl: PrototypeRepositoryImpl) : ProtoTypeRepository
}