package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import java.math.RoundingMode
import kotlin.math.round
import kotlin.math.roundToInt

class ActivityIMC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_i_m_c)

        //TODO: ARRUMAR OS BUTTON QUE FORAM SUBSTITUIDOS POR CIMC DEVIDO A TROCA DE TELAS.
        val button = findViewById(R.id.button) as Button
        val text = findViewById(R.id.peso) as EditText
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        button.setOnClickListener {
            button.onEditorAction(EditorInfo.IME_ACTION_DONE)
            addPesoAltura(button)
        }
    }

    fun addPesoAltura(view: View) {
        val editText = findViewById<EditText>(R.id.peso)
        val textView = findViewById<TextView>(R.id.output)
        var pes = editText.text.toString()
        var peso = pes.toDouble()


        val editTextAltura = findViewById<EditText>(R.id.altura)
        var altur = editTextAltura.text.toString()
        var altura = altur.toDouble()

        val IMC = (peso / (altura * altura)).toBigDecimal().setScale(1,RoundingMode.UP).toDouble()


        if (IMC <= 18.5) {
            val resultado = "Abaixo do peso, seu IMC é $IMC"
            textView.text = resultado
            textView.visibility = View.VISIBLE
        } else if (IMC in 18.5..24.9) {
            val resultado = "Normal, você está no peso ideal, seu IMC é $IMC"
            textView.text = resultado
            textView.visibility = View.VISIBLE
        } else if (IMC in 25.0..29.9) {
            val resultado = "Sobrepeso, você está com obesidade grau I, seu IMC é $IMC"
            textView.text = resultado
            textView.visibility = View.VISIBLE
        } else if (IMC in 30.0..39.9) {
            val resultado = "Obesidade, você está no grau II, seu IMC é $IMC"
            textView.text = resultado
            textView.visibility = View.VISIBLE
        } else if (IMC > 40) {
            val resultado = "Obesidade grave, procure ajuda médica, seu IMC é $IMC"
            textView.text = resultado
            textView.visibility = View.VISIBLE
        }
    }
}