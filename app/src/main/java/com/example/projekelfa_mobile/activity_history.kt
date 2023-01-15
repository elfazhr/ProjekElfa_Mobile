package com.example.projekelfa_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.projekelfa_mobile.databinding.ActivityHistoryBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.activity_profil.*
import java.lang.Exception

class activity_history : AppCompatActivity() {
    private lateinit var binding : ActivityHistoryBinding
    private lateinit var orderArrayList: ArrayList<modelOrders>
    private lateinit var adapterOrders: AdapterOrders

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadHistory()

        //search
        binding.search.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //called as and when user type anything
                try {
                    adapterOrders.filter.filter(s)
                }
                catch (e: Exception) {

                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        profil()
        backs()
    }
    private fun profil() {
        btn_profile.setOnClickListener{
            startActivity(Intent(this@activity_history, activity_profil::class.java))
        }
    }

    private fun backs() {
        back.setOnClickListener {
            onBackPressed()
        }
    }
    private fun loadHistory() {
        orderArrayList= ArrayList()
        val ref = FirebaseDatabase.getInstance().getReference("Orders")
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                orderArrayList.clear()
                for (ds in snapshot.children) {
                    val model = ds.getValue(modelOrders::class.java)
                orderArrayList.add(model!!)
                }
                //setup adapter
                adapterOrders = AdapterOrders(this@activity_history, orderArrayList)
                //set adapter to recycleview
                binding.ordersRv.adapter = adapterOrders
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}