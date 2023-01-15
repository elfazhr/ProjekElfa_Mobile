package com.example.projekelfa_mobile

import android.widget.Filter


class FilterOrders : Filter{
private var filterList: ArrayList<modelOrders>

private var adapterOrders : AdapterOrders

    constructor(filterList: ArrayList<modelOrders>, adapterOrders: AdapterOrders) : super() {
        this.filterList = filterList
        this.adapterOrders = adapterOrders
    }

    override fun performFiltering(constraint: CharSequence?): FilterResults {
        var constraint = constraint
        val result = FilterResults()

        if(constraint != null && constraint.isNotEmpty()){
            constraint = constraint.toString().uppercase()
            val filteredModel : ArrayList<modelOrders> = ArrayList()
            for(i in 0 until filterList.size){
                if(filterList[i].bread.uppercase().contains(constraint)) {
                    filteredModel.add(filterList[i])
                }
            }
            result.count = filteredModel.size
            result.values = filteredModel
        }
        else {
            result.count = filterList.size
            result.values = filterList
        }
        return result
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults) {
        adapterOrders.orderArrayList = results.values as ArrayList<modelOrders>

        adapterOrders.notifyDataSetChanged()
    }


}