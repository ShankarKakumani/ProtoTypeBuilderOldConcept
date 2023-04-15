package dev.shankarkakumani.data.repository

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class PrototypeRepositoryImpl {

    val database = Firebase.database
    val myRef = database.getReference("message")

    fun insertMessage() {
        myRef.setValue("Hello bitch")
    }

    fun getAppsList() {
        myRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                TODO("Not yet implemented")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}