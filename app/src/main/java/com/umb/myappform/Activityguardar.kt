package com.umb.myappform

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activityguardar : AppCompatActivity() {

    private lateinit var Names: EditText
    private lateinit var Typejg: EditText
    private lateinit var Prejg: EditText
    private lateinit var Leveljg: EditText
    private lateinit var Añadir: Button
    private lateinit var Salir: Button

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_activityguardar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Asocia cada variable con su respectivo componente en el XML
        Names = findViewById(R.id.names)
        Typejg= findViewById(R.id.type)
        Prejg = findViewById(R.id.prefe)
        Leveljg = findViewById(R.id.level)
        Salir = findViewById(R.id.salir)

// Recibir los datos enviados desde la otra actividad
        val fullname = intent.getStringExtra("nombres")
        val tipoJuego = intent.getStringExtra("tipo_juego")
        val preferenciaJuego = intent.getStringExtra("preferencia_juego")
        val nivelDificultad = intent.getStringExtra("nivel_dificultad")

// Mostrar los datos en los campos de texto (uno por línea)
        Names.setText(fullname ?: "Sin nombre")
        Typejg.setText(tipoJuego ?: "Sin información")
        Prejg.setText(preferenciaJuego ?: "Sin información")
        Leveljg.setText(nivelDificultad ?: "Sin información")

// Botón para agregar otro registro
        Añadir = findViewById(R.id.añadid)
        Añadir.setOnClickListener {
            Añadir_otro()
        }

    }
    fun Añadir_otro() {
        finish()
    }

    fun exitApp(view: View) {
        finishAffinity() // Cierra toda la app
    }


}