package com.umb.myappform

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activityform : AppCompatActivity() {

    private lateinit var edNombres: EditText
    private lateinit var spinnerFav: Spinner
    private lateinit var preferenciaJg: RadioGroup
    private lateinit var muljugador: RadioButton
    private lateinit var individual: RadioButton
    private lateinit var spinnerNivel: Spinner
    private lateinit var registrar: Button


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_activityform)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        edNombres = findViewById(R.id.ednombres)
        spinnerFav = findViewById(R.id.spinnerfav)
        preferenciaJg = findViewById(R.id.preferenciajg)
        muljugador = findViewById(R.id.muljugador)
        individual = findViewById(R.id.individual)
        spinnerNivel = findViewById(R.id.spinnernivel)
        registrar = findViewById(R.id.registrar)


        registrar.setOnClickListener {
            if (edNombres.text.toString().isEmpty()) {
                Toast.makeText(this, "Ingrese su nombre", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show()

                // Crear el Intent para cambiar de actividad
                val intent = Intent(this, Activityguardar::class.java)

                // Guardar el nombre
                intent.putExtra("nombres", edNombres.text.toString())

                // Guardar el tipo de juego favorito desde el Spinner
                intent.putExtra("tipo_juego", spinnerFav.selectedItem.toString())

                // Guardar la preferencia de juego desde el RadioGroup (Ejemplo: Acción, Estrategia, etc.)
                val selectedPreferenceId = preferenciaJg.checkedRadioButtonId
                val selectedPreference = findViewById<RadioButton>(selectedPreferenceId)?.text.toString()
                intent.putExtra("preferencia_juego", selectedPreference)

                // Guardar el nivel de dificultad desde el Spinner
                intent.putExtra("nivel_dificultad", spinnerNivel.selectedItem.toString())

                // Obtener si el usuario prefiere jugar individual o multijugador
                val selectedModeId = preferenciaJg.checkedRadioButtonId  // Preferencijg es el ID del RadioGroup
                val selectedMode = findViewById<RadioButton>(selectedModeId)?.text.toString()
                intent.putExtra("modo_juego", selectedMode)

                // Iniciar la actividad
                startActivity(intent)

                // Llamar a la función para limpiar los campos (si existe)
                limpiar()
            }
        }

    }

    //limpia los campos y ubica el puntero en el nombre
    fun limpiar() {
        edNombres.setText("")
        spinnerFav.setSelection(0)
        preferenciaJg.clearCheck()
        spinnerNivel.setSelection(0)
        edNombres.requestFocus()
    }


}