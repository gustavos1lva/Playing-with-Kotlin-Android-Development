package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.math.RoundingMode

class ActivityCPID : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c_p_i_d)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        val enviar = findViewById<Button>(R.id.button2)
        enviar.setOnClickListener{
            enviar.onEditorAction(EditorInfo.IME_ACTION_DONE)
            calculaPeso()
        }
    }

    fun calculaPeso(){
        val editText = findViewById<EditText>(R.id.peso)
        val textView = findViewById<TextView>(R.id.output)
        var pes = editText.text.toString()
        var peso = pes.toDouble()


        val editTextAltura = findViewById<EditText>(R.id.altura)
        var altur = editTextAltura.text.toString()
        var altura = altur.toDouble()

        val IMC = (peso / (altura * altura))
        val pesoIdealUm = ((altura*altura)*18.5).toBigDecimal().setScale(1, RoundingMode.DOWN).toDouble()
        val pesoIdealDois = ((altura*altura)*24.9).toBigDecimal().setScale(1, RoundingMode.DOWN).toDouble()
        if(IMC > 24.9){
            var resultado = "Você está acima do peso, seu peso ideal é entre $pesoIdealUm e $pesoIdealDois."
            textView.text = resultado
            textView.visibility = View.VISIBLE
        } else {
            var resultado2 = "Você está dentro do peso ideal."
            textView.text = resultado2
            textView.visibility = View.VISIBLE
        }
    }
}