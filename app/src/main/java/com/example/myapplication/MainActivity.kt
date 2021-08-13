package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), MyCustomDialog.CustomDialogListener {
    private lateinit var tv1: TextView
    private lateinit var bt1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv1 = findViewById(R.id.showText_TV)
        bt1 = findViewById(R.id.showDialog)

        val mycustom = MyCustomDialog() //Init dialog

        bt1.setOnClickListener {
            mycustom.show(supportFragmentManager, "MyCustomFragment") //Show Dialog
        }


    }

    override fun applytext(value: String) {
        tv1.text = value

    }

}