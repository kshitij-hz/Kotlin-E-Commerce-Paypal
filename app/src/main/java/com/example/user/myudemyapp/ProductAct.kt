package com.example.user.myudemyapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_product.*

class ProductAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        var list = ArrayList<Product>()
        list.add(Product("Pepsi", 2, R.drawable.pepsi))
        list.add(Product("Coke", 3, R.drawable.coke))
        list.add(Product("Dew", 4, R.drawable.dew))

        var adp = ProductAdapter(this, list)
        rv_pro.layoutManager = LinearLayoutManager(this)
        rv_pro.adapter = adp

    }
}
