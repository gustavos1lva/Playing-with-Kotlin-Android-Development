package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cimc = findViewById<Button>(R.id.CIMC)
        cimc.setOnClickListener{
            trocaTela(1)
        }

        val ccal = findViewById<Button>(R.id.CCAL)
        ccal.setOnClickListener{
            trocaTela(2)
        }

        val cpid = findViewById<Button>(R.id.CPID)
        cpid.setOnClickListener{
            trocaTela(3)
        }
    }

    fun trocaTela(i: Int){

        if(i == 1) {
            val intent = Intent(this, ActivityIMC::class.java)
            startActivity(intent)
        } else if (i == 2){
            val intentando = Intent(this, ActivityCCAL::class.java)
            startActivity(intentando)
        } else if (i == 3){
            val intentoso = Intent(this, ActivityCPID::class.java)
            startActivity(intentoso)
        }
    }
}