/**
 * Author : Mani Shankar Kakumani,
 * Created on : 13 May, 2022.
 */

package com.prototypebuilder.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tableAppsList")
data class RMAppEntity(
    @PrimaryKey(autoGenerate = true)
    val appId: Int,
    val appName: String
) {
    constructor(appName: String) : this(0, appName)
}