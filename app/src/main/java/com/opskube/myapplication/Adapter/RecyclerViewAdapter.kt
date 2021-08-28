package com.opskube.myapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.opskube.myapplication.R
import com.opskube.myapplication.RecyclerData

class RecyclerViewAdapter (val context: Context): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var data = ArrayList<RecyclerData>()

    fun setUpdatedData(data : ArrayList<RecyclerData>){
        this.data = data
        notifyDataSetChanged()
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){

        var tvTitle: TextView
        var tvAuthor: TextView
        var tvName: TextView
        var cardView: CardView

        init {
            tvTitle = view.findViewById(R.id.tvTitle)
            tvAuthor = view.findViewById(R.id.tvAuthor)
            tvName = view.findViewById(R.id.tvName)
            cardView = view.findViewById(R.id.cardView)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val apiData = data[position]
        holder.tvTitle.text = apiData.title
        holder.tvAuthor.text = apiData.id.toString()
        holder.tvName.text = apiData.body
        holder.tvName.text = apiData.user_id.toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }
}