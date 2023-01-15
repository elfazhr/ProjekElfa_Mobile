package com.example.projekelfa_mobile

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class activity_register : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    var databaseReference :  DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("profile")

        register()

    }

    private fun register() {
        btnRegister.setOnClickListener {

            if(TextUtils.isEmpty(inputUsername.text.toString())) {
                inputUsername.setError("Please enter Username ")
                return@setOnClickListener
            } else if(TextUtils.isEmpty(inputNoHp.text.toString())) {
                inputNoHp.setError("Please enter Your Phone Number ")
                return@setOnClickListener
            }else if(TextUtils.isEmpty(inputEmail.text.toString())) {
                inputEmail.setError("Please enter Your Email ")
                return@setOnClickListener
            }else if(TextUtils.isEmpty(inputPassword.text.toString())) {
                inputPassword.setError("Please enter password ")
                return@setOnClickListener
            }


            auth.createUserWithEmailAndPassword(inputEmail.text.toString(), inputPassword.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful) {
                        val currentUser = auth.currentUser
                        val currentUSerDb = databaseReference?.child((currentUser?.uid!!))
                        currentUSerDb?.child("username")?.setValue(inputUsername.text.toString())
                        currentUSerDb?.child("noHP")?.setValue(inputNoHp.text.toString())

                        Toast.makeText(this@activity_register, "Registration Success. ", Toast.LENGTH_LONG).show()
                        finish()

                    } else {
                        Toast.makeText(this@activity_register, "Registration failed, please try again! ", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }

    fun login(view: View?) {
        val i = Intent(applicationContext, activity_login::class.java)
        startActivity(i)

    }



}