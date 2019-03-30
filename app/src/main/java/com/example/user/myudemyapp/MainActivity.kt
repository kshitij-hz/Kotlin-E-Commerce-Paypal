package com.example.user.myudemyapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            var x:Int = num1.text.toString().toInt()
            var y:Int = num2.text.toString().toInt()
            var z:Int = x + y
            Toast.makeText(this, "The result is " + z, Toast.LENGTH_LONG).show()
        }
    }
}
