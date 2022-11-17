package com.example.mybmicalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class MainActivityAbout : AppCompatActivity()  {
    private lateinit var myWeb: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_about)
        myWeb = findViewById(R.id.WV_view)
        myWeb.loadUrl("https://www.calculator.net/bmi-calculator.html")
    }
}