/**
 * Author : Mani Shankar Kakumani,
 * Created on : 13 May, 2022.
 */

package com.prototypebuilder.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tableActivityList")
data class RMActivityEntity(
    @PrimaryKey(autoGenerate = true)
    val activityId: Long = 0,
    val appId: Long,
    val activityName: String?,
    val background: Int?,
    val statusBarColor: Int?,
    val statusBarDarkIcons: Boolean?,
    val navigationBarColor: Int?,
    val navigationBarDarkIcons: Boolean?,
)