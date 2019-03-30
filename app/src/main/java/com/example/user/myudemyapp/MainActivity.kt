package com.example.user.myudemyapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button2.setOnClickListener {
            var i=Intent(this, SecondAct::class.java)
            i.putExtra("name", editText2.text.toString())
            startActivity(i)
        }

        btn_write.setOnClickListener {
            var sp = getSharedPreferences("my_data", Context.MODE_PRIVATE)
            var editor = sp.edit()
            editor.putString("name", editText2.text.toString())
            editor.commit()
        }

        btn_read.setOnClickListener {
            var sp = getSharedPreferences("my_data", Context.MODE_PRIVATE)
            Toast.makeText(this, "SP name is " + sp.getString("name", ""), Toast.LENGTH_LONG).show()
        }
    }

}
