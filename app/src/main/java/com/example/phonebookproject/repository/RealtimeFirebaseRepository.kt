package com.example.phonebookproject.repository

import com.example.phonebookproject.model.PhoneNumber
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.UUID

class RealtimeFirebaseRepository {

    private val db = Firebase.database.reference


    fun addPhone(name: String, number: String) {

        db.child("phoneNumber").child(Firebase.auth.currentUser?.uid ?: "")
            .child(UUID.randomUUID().toString())
            .setValue(PhoneNumber(name, number, Firebase.auth.currentUser?.uid ?: ""))
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {

                } else {
                    task.exception?.let {

                    }
                }

            }
    }

    fun getPhone(onChange: (list: ArrayList<PhoneNumber>) -> Unit) {

        db.child("phoneNumber").child(Firebase.auth.currentUser?.uid ?: "")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val list = arrayListOf<PhoneNumber>()
                    snapshot.children.forEach { snapshot ->
                        (snapshot.getValue(PhoneNumber::class.java))?.let { phoneNumber ->
                            list.add(phoneNumber)

                        }

                    }
                    onChange(list)
                }

                override fun onCancelled(error: DatabaseError) {
//
                }
            })


    }
}