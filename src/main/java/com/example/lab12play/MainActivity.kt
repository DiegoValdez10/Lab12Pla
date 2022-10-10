package com.example.lab12play

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab12play.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cargarVista()
    }


    private fun cargarVista() {
        setContentView(R.layout.activity_main)
    }
}