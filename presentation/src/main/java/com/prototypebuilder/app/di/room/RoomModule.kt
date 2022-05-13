package com.prototypebuilder.app.di.room

import android.content.Context
import androidx.room.Room
import com.prototypebuilder.data.local.room.dao.AppDao
import com.prototypebuilder.data.local.room.db.RoomDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext appContext: Context): RoomDataBase {
        return Room
            .databaseBuilder(appContext, RoomDataBase::class.java, "prototype_table")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Singleton
    @Provides
    fun provideAppDao(simpleRoomDatabase: RoomDataBase): AppDao {
        return simpleRoomDatabase.getAppDao()
    }

}