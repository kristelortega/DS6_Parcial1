package com.example.parcial1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etAmount = findViewById<EditText>(R.id.etAmount)
        val spFrom = findViewById<Spinner>(R.id.spFrom)
        val spTo = findViewById<Spinner>(R.id.spTo)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val btnConvert = findViewById<Button>(R.id.btnConvert)

        btnConvert.setOnClickListener {
            val cantidad = etAmount.text.toString().toDouble()
            val monedaOrigen = spFrom.selectedItem.toString()
                .substringAfterLast("(").substringBefore(")")

            val monedaDestino = spTo.selectedItem.toString()
                .substringAfterLast("(").substringBefore(")")

            val conversor = Conversor()
            try {
                val resultado = conversor.convertir(monedaOrigen, monedaDestino, cantidad)
                tvResult.text = resultado.toString()
            } catch (e: IllegalArgumentException) {
                tvResult.text = e.message

            }
        }


    }
}