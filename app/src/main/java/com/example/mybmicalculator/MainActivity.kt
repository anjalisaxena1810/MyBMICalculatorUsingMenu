
package com.example.mybmicalculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.view.View

class MainActivity : AppCompatActivity() {
    private lateinit var etWeight: EditText
    private lateinit var etHeight: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvDisplay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etWeight = findViewById(R.id.etWeight)
        etHeight = findViewById(R.id.etHeight)
        btnCalculate = findViewById(R.id.btnCalculate)
        tvDisplay = findViewById(R.id.tvDisplay)




      



        btnCalculate.setOnClickListener {
//           if (etHeight.text.isNotEmpty() && etWeight.text.isNotEmpty())


            val etHeight = etHeight.text.toString().toDouble()
            val etWeight = etWeight.text.toString().toDouble()

            val bmi= String.format("%.2f",(etWeight/(etHeight*etHeight))* 10000).toDouble()
            if (bmi<18.5){
                tvDisplay.text= " Result\n Your BMI Value:$bmi\n You Are underweight"
            }
            else if(bmi>18.5 && bmi<=24.9){
                tvDisplay.text="Result\n" +
                        " Your BMI Value:$bmi \n You Are normal weight"
            }
            else if(bmi>25.0&& bmi< 29.9){

                tvDisplay.text=  "Result\n Your BMI Value:$bmi \nYou Are  pre-obesity"
            }
            else if (bmi>30.0 && bmi<34.9){
                tvDisplay.text=" Result\n Your BMI Value:$bmi\n You Are obecity class"
            }
            else {
                tvDisplay.text=" Result\n Your BMI Value:$bmi\n you are storng"
            }

        }
    }


        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R. menu.example_menu,menu)
            return super.onCreateOptionsMenu(menu)
        }

           override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.app -> {
                    var intent:Intent = Intent( this@MainActivity,MainActivityAbout::class.java)
                    startActivity(intent)


                }

                R.id.bmi -> {
                    var intent:Intent = Intent( this@MainActivity,MainActivityCart::class.java)
                    startActivity(intent)


                }
                R.id.exit -> {
                    val builder = AlertDialog.Builder(this)
                    //set title for alert dialog
                    builder.setTitle(R.string.dialogTitle)
                    //set message for alert dialog
                    builder.setMessage(R.string.dialogMessage)
                    builder.setIcon(android.R.drawable.ic_dialog_alert)

                    //performing positive action
                    builder.setPositiveButton("Yes"){dialogInterface, which ->
                        Toast.makeText(applicationContext,"clicked yes",Toast.LENGTH_LONG).show()
                    }
                    //performing cancel action
                    builder.setNeutralButton("Cancel"){dialogInterface , which ->
                        Toast.makeText(applicationContext,"clicked cancel\n operation cancel",Toast.LENGTH_LONG).show()
                    }
                    //performing negative action
                    builder.setNegativeButton("No"){dialogInterface, which ->
                        Toast.makeText(applicationContext,"clicked No",Toast.LENGTH_LONG).show()
                    }
                    // Create the AlertDialog
                    val alertDialog: AlertDialog = builder.create()
                    // Set other dialog properties
                    alertDialog.setCancelable(false)
                    alertDialog.show()



                }

                R.id.contactus ->{
                    var intent:Intent = Intent( this@MainActivity,MainActivityContactus::class.java)
                    startActivity(intent)

                }
            }
                return super .onOptionsItemSelected(item)
        }

        }







