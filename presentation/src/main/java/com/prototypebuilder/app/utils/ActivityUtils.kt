/**
 * Author : Mani Shankar Kakumani,
 * Created on : 14 May, 2022.
 */

package com.prototypebuilder.app.utils

import android.app.Activity
import android.content.Intent

fun <T> Activity.navigateAway(destination: Class<T>, finish: Boolean = false) {
    startActivity(Intent(this, destination))
    if(finish) {
        finish()
    }
}

fun Activity.navigateAway(intent: Intent, finish: Boolean = false) {
    startActivity(intent)
    if(finish) {
        finish()
    }
}