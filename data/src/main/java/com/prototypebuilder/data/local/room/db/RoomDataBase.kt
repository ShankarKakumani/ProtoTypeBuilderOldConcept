/**
 * Created by Ankit Pareek on 18/02/22.
 */

package com.prototypebuilder.data.local.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prototypebuilder.data.local.room.dao.AppDao
import com.prototypebuilder.data.local.room.entity.RMAppEntity

@Database(
    version = 1,
    exportSchema = false,
    entities = [RMAppEntity::class]
)

abstract class RoomDataBase : RoomDatabase() {
    abstract fun getAppDao(): AppDao
}



