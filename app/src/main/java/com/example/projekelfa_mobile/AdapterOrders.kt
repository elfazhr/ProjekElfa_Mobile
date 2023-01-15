package com.example.projekelfa_mobile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.projekelfa_mobile.databinding.ActivityBgRvBinding
import org.w3c.dom.Text

class AdapterOrders : RecyclerView.Adapter<AdapterOrders.HolderOrders>, Filterable{
    private val context:Context
    public var orderArrayList: ArrayList<modelOrders>
    private lateinit var binding: ActivityBgRvBinding
    private var filterList: ArrayList<modelOrders>

    private var filter:FilterOrders? = null
    constructor(context: Context, orderArrayList: ArrayList<modelOrders>) {
        this.context = context
        this.orderArrayList = orderArrayList
        this.filterList = orderArrayList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderOrders {
       binding = ActivityBgRvBinding.inflate(LayoutInflater.from(context), parent, false)
    return HolderOrders(binding.root)
    }

    override fun onBindViewHolder(holder: HolderOrders, position: Int) {
        //get data, set data, handle clicks etc

        //get data
        val model = orderArrayList[position]
        val id = model.id
        val bread = model.bread
        val amount = model.amount
        val prices = model.prices
        val notes = model.notes
        val uid = model.uid
        val timestamp = model.timestamp

        //set data
        holder.breadTv.text = bread
        holder.amountTv.text = amount + " PCS"
        holder.priceTv.text = "Rp. " + prices
        holder.notesTv.text = notes


    }

    override fun getItemCount(): Int {
        return orderArrayList.size
    }


    inner class HolderOrders(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var breadTv:TextView=binding.breadTv
        var amountTv:TextView=binding.amountTv
        var priceTv:TextView=binding.priceTv
        var notesTv:TextView=binding.notesTv


    }

    override fun getFilter(): Filter {
       if(filter == null) {
           filter = FilterOrders(filterList, this )
       }
        return filter as FilterOrders
    }


}