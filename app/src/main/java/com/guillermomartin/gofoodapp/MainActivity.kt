package com.guillermomartin.gofoodapp

import android.content.Intent // IMPORTANTE: Necesario para cambiar de pantalla
import android.os.Bundle
import android.widget.Button // IMPORTANTE: Necesario para el botón
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Configuración de la pantalla (código que ya tenías)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ---------------------------------------------------------
        // CÓDIGO NUEVO AÑADIDO PARA EL BOTÓN
        // ---------------------------------------------------------

        // 1. Buscamos el botón por su ID (asegúrate que en tu XML se llame btn_entrar o cámbialo aquí)
        // Buscamos el botón usando el ID que tienes en tu XML ("button")
        val btnEnter = findViewById<Button>(R.id.button)

        btnEnter.setOnClickListener {
            // Esto te lleva a la pantalla nueva (que está en Java)
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
        // ---------------------------------------------------------
    }
}