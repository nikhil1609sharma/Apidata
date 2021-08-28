package com.opskube.myapplication

data class RecyclerList(val data:ArrayList<RecyclerData>)
data class RecyclerData(val id: Int,val user_id: Int, val title:String,val body: String)
