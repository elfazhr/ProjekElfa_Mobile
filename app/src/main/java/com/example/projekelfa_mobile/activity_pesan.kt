package com.example.projekelfa_mobile

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.example.projekelfa_mobile.databinding.ActivityPesanBinding
import com.example.projekelfa_mobile.databinding.ActivityUtamaBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_pesan.*
import kotlinx.android.synthetic.main.activity_profil.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_utama.*

class activity_pesan : AppCompatActivity() {
    private lateinit var binding : ActivityPesanBinding

    private lateinit var firebaseAuth: FirebaseAuth
    var databaseReference :  DatabaseReference? = null
    var database: FirebaseDatabase? = null

    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPesanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("profile")

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait...")
        progressDialog.setCanceledOnTouchOutside(false)

        binding.back.setOnClickListener{
            onBackPressed()
        }
        binding.profil.setOnClickListener{
            startActivity(Intent(this@activity_pesan, activity_profil::class.java))
        }
        binding.btnOrder.setOnClickListener {
            validateData()
        }
    }



    private var bread = ""
    private var amount = ""
    private var prices = ""
    private var notes = ""

    private fun validateData() {


        bread = binding.inputBread.text.toString().trim()
        amount = binding.inputAmount.text.toString().trim()
        prices = binding.inputTtlPrice.text.toString().trim()
        notes = binding.inputNotes.text.toString().trim()

        if(TextUtils.isEmpty(inputBread.text.toString())) {
            Toast.makeText(this, "Enter Bread...", Toast.LENGTH_SHORT).show()
        } else if(TextUtils.isEmpty(inputAmount.text.toString())) {
            Toast.makeText(this, "Enter Amount...", Toast.LENGTH_SHORT).show()
        }else if(TextUtils.isEmpty(inputTtlPrice.text.toString())) {
            Toast.makeText(this, "Enter Total Price...", Toast.LENGTH_SHORT).show()
        }else if(TextUtils.isEmpty(inputNotes.text.toString())) {
            Toast.makeText(this, "Enter Notes...", Toast.LENGTH_SHORT).show()
        } else {
            addOrderFirebase()
        }
    }

    private fun addOrderFirebase() {
        progressDialog.show()
        val timestamp = System.currentTimeMillis()

        val hashMap = HashMap<String,Any>()
        hashMap["id"] = "$timestamp"
        hashMap["bread"] = bread
        hashMap["amount"] = amount
        hashMap["prices"] = prices
        hashMap["notes"] = notes
        hashMap["timestamp"] = timestamp
        hashMap["uid"] = "${firebaseAuth.uid}"

         val ref = FirebaseDatabase.getInstance().getReference("Orders")
        ref.child("$timestamp")
            .setValue(hashMap)
            .addOnSuccessListener {
                progressDialog.dismiss()
                Toast.makeText(this, "Added Successfully...", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@activity_pesan, activity_sukses_order::class.java))
            }
            .addOnFailureListener{ e->
                progressDialog.dismiss()
                Toast.makeText(this, "Failed to add due to ${e.message}", Toast.LENGTH_SHORT).show()

            }

    }

}