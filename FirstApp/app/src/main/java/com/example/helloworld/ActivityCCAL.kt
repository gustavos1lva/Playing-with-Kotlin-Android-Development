package com.example.helloworld

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.math.RoundingMode

class ActivityCCAL : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c_c_a_l)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        val ccal = findViewById(R.id.botao) as Button
        ccal.setOnClickListener{
            ccal.onEditorAction(EditorInfo.IME_ACTION_DONE)
            calculaCaloria()
        }

    }

    @SuppressLint("SetTextI18n")
    fun calculaCaloria(){
        val editText = findViewById<EditText>(R.id.peso)
        val textView = findViewById<TextView>(R.id.output)
        var pes = editText.text.toString()
        var peso = pes.toDouble()


        val editTextPesoD = findViewById<EditText>(R.id.altura)
        var pesD = editTextPesoD.text.toString()
        var pesoDesejado = pesD.toDouble()

        val dif = peso - pesoDesejado
        var caloriasN = 0.0
        if (dif > 0){
            caloriasN = dif*7000
            val calMes = (caloriasN/30).toBigDecimal().setScale(1,RoundingMode.UP).toDouble()
            textView.text =
                "A cada 7 mil calorias perde-se 1 KG, portanto você precisa consumir $calMes calorias a menos durantes 30 dias para perder a quantidade desejada. O total de calorias necessária é $caloriasN, divida no período desejado."
            textView.visibility = View.VISIBLE
        } else {
            var caloriasG = (dif*7000)*-1
            var caloriasGG = ((caloriasG)/30).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
            textView.text =
                "Para ganhar a quantidade de peso desejado é necessário consumir $caloriasG calorias no total, sugerimos $caloriasGG por dia durante 30 dias."
            textView.visibility = View.VISIBLE
        }
    }
}