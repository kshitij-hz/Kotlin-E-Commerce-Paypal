package com.example.user.myudemyapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class ProductAdapter(var c:Context, var list:ArrayList<Product>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        var my_view = LayoutInflater.from(c).inflate(R.layout.my_row, parent, false)
        return MyProduct(my_view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, p1: Int) {
        (holder as MyProduct).bind(list[p1].name, list[p1].price, list[p1].photo)
    }

    class MyProduct(view: View) : RecyclerView.ViewHolder(view){
        var tv_name = view.findViewById<TextView>(R.id.pro_name)
        var tv_price= view.findViewById<TextView>(R.id.pro_price)
        var iv_photo = view.findViewById<ImageView>(R.id.pro_photo)

        fun bind(n:String, p:Int, ph:Int){
            tv_name.text = n
            tv_price.text = p.toString()
            iv_photo.setImageResource(ph)
        }
    }

}