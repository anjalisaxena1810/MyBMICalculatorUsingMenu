package com.example.mybmicalculator

import android.Manifest
import android.content.Intent
import android.content.Intent.*
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Button

class MainActivityContactus : AppCompatActivity() {
    private lateinit var btncall: Button
    private lateinit var btndial: Button
    private lateinit var btnEmail: Button

private val requestPermissionList = arrayOf(Manifest.permission.CALL_PHONE)
    private val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_contactus)

        btncall = findViewById(R.id.btncall)
        btndial = findViewById(R.id.btndial)
        btnEmail = findViewById(R.id.btnemail)

        if (ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)==PackageManager.PERMISSION_GRANTED){
            // TODO: if Permission is granted

        }else{
            // TODO: Resquest for permission
            ActivityCompat.requestPermissions(this@MainActivityContactus, requestPermissionList,1)

        }



        btndial.setOnClickListener {

                val intent = Intent(ACTION_DIAL, Uri.parse("tel:9625426873"))

                startActivity(intent)

        }
        btncall.setOnClickListener {
            val intent = Intent(ACTION_CALL, Uri.parse("tel:9625426873"))
            startActivity(intent)
        }

        btnEmail.setOnClickListener {

            val emailIntent = Intent(ACTION_VIEW).apply {
                data = Uri.parse("https://mail.google.com/mail/u/0/#inbox?compose=new")
            }
            startActivity(createChooser(emailIntent, "Send feedback"))
        }




    }
}


