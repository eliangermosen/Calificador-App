package com.example.calificadorapp

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val btnPerfil = findViewById(R.id.btnInfo) as FloatingActionButton
        val btnPerfil = findViewById<FloatingActionButton>(R.id.btnInfo)
        btnPerfil.setOnClickListener{
            openInfo()
        }
        //val btnCalculate = findViewById(R.id.btnCalificar) as Button
        val btnCalculate = findViewById<Button>(R.id.btnCalificar)
        btnCalculate.setOnClickListener{
            calculate()
        }
    }
    private fun openInfo(){
        val intent: Intent = Intent(this, Perfil::class.java)
        startActivity(intent)
        //finish()
    }
    private fun calculate(){
        val view: View
        val qualification = findViewById<EditText>(R.id.editTextNumber)
        val textResult = findViewById<TextView>(R.id.textViewResult)
        //val qualification = findViewById(R.id.editTextNumber) as EditText
        //val textResult = findViewById(R.id.textViewResult) as TextView

        val num: String = qualification.text.toString()
        val conv = (num.toInt())

        textResult.visibility = View.VISIBLE

        if(conv < 70){
            textResult.setTextColor(Color.parseColor("#FA3838"))
            textResult.setText("F")
            //textResult.setText(conv.toString())
        }
        else if(conv < 80){
            textResult.setTextColor(Color.parseColor("#ffc300"))
            textResult.setText("C")
            //textResult.setText(conv.toString())
        }
        else if(conv < 90){
            textResult.setTextColor(Color.parseColor("#0077b6"))
            textResult.setText("B")
            //textResult.setText(conv.toString())
        }
        else if(conv <= 100){
            textResult.setTextColor(Color.parseColor("#70e000"))
            textResult.setText("A")
            //textResult.setText(conv.toString())
        }
        else{
            numeroInvalid()
        }
    }
    private fun numeroInvalid(){
        AlertDialog.Builder(this)
            .setTitle("INGRESE UN VALOR DEL 0 AL 100")
            .setPositiveButton("Entendido!"){ _,_ ->

            }
            .show()
    }
}