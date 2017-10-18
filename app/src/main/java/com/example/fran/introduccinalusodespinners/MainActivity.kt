package com.example.fran.introduccinalusodespinners

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private var seleccion: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        seleccion = findViewById<View>(R.id.seleccion) as TextView?

        val spin = findViewById<View>(R.id.spinner) as Spinner
        spin.onItemSelectedListener = this

        // Establecemos el Adapter y el Layout de la lista plegada
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)

        // Indicamos cómo se debe mostrar la lista cuando se despliega
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin.adapter = adapter
    }

    override fun onItemSelected(parent: AdapterView<*>, v: View, position: Int, id: Long) {
        seleccion!!.text = items[position]
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        seleccion!!.text = ""
    }

    companion object {
        private val items = arrayOf("En", "un", "lugar", "de", "la", "Mancha", "de", "cuyo", "nombre",
                "no", "quiero", "acordarme", "no", "ha", "mucho", "tiempo", "que", "vivía", "un",
                "hidalgo", "de", "los", "de", "lanza", "en", "astillero", "adarga", "antigua", "rocín",
                "flaco", "y", "galgo", "corredor")
    }

}
