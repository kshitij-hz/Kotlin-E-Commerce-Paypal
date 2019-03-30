package com.example.user.myudemyapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
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

        btn_volley.setOnClickListener {
            var url:String = "http://192.168.43.19:3001/test"
            var rq:RequestQueue = Volley.newRequestQueue(this)
            var sr = StringRequest(Request.Method.GET, url, Response.Listener { response ->
                var msg:String = "Success: " + response
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
            }, Response.ErrorListener {error ->
                Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
            })

            rq.add(sr)
        }
    }

}
