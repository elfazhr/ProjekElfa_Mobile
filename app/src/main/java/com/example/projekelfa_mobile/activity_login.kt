package com.example.projekelfa_mobile

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class activity_login: AppCompatActivity() {
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val currentuser = auth.currentUser
        if(currentuser != null) {
            startActivity(Intent(this@activity_login, activity_profil::class.java))
            finish()
        }
        login()

    }

    private fun login() {
        btnLogin.setOnClickListener {

            if (TextUtils.isEmpty(inputMail.text.toString())) {
                inputMail.setError("Please enter Your Email")
                return@setOnClickListener
            } else if (TextUtils.isEmpty(inputPasswor.text.toString())) {
                inputPasswor.setError("Please enter password")
                return@setOnClickListener
            }
            auth.signInWithEmailAndPassword(
                inputMail.text.toString(),
                inputPasswor.text.toString()
            )
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        startActivity(Intent(this@activity_login, activity_splash::class.java))
                        finish()
                    } else {
                        Toast.makeText(
                            this@activity_login,
                            "Login failed, please try again! ",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }
    }

    fun register(view: View?) {
        val i = Intent(applicationContext, activity_register::class.java)
        startActivity(i)

    }


    }

