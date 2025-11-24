package com.guillermomartin.gofoodapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.guillermomartin.gofoodapp.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RestauranteAdapter adapter;
    private List<Restaurante> listaRestaurantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // 1. Inicializar la lista de datos
        listaRestaurantes = new ArrayList<>();
        listaRestaurantes.add(new Restaurante("Burger King", "Comida Rápida", "Whopper, Patatas fritas, Aros de cebolla"));
        listaRestaurantes.add(new Restaurante("Telepizza", "Italiana", "Pizza Barbacoa, Pan de Ajo, Alitas"));
        listaRestaurantes.add(new Restaurante("Sushi Bar", "Japonesa", "Makis de salmón, Nigiris, Sopa Miso"));

        // 2. Configurar RecyclerView
        recyclerView = findViewById(R.id.recyclerViewRestaurantes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RestauranteAdapter(listaRestaurantes);
        recyclerView.setAdapter(adapter);

        // 3. Configurar Floating Action Button (FAB)
        FloatingActionButton fab = findViewById(R.id.fabAdd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                añadirRestaurante(view);
            }
        });

        // ... código anterior (FAB, RecyclerView, etc) ...

        // Configuración del botón VOLVER
        Button btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // finish() cierra esta actividad y vuelve automáticamente a la anterior (MainActivity)
                finish();
            }
        });
    }

    private void añadirRestaurante(View view) {
        // Crear un restaurante nuevo simulado
        Restaurante nuevo = new Restaurante("Nuevo Wok " + (listaRestaurantes.size() + 1), "Asiática", "Tallarines tres delicias, Pollo al limón");

        // Añadir a la lista y notificar al adaptador
        listaRestaurantes.add(nuevo);
        int position = listaRestaurantes.size() - 1;
        adapter.notifyItemInserted(position);

        // Scrollear hasta el nuevo elemento
        recyclerView.scrollToPosition(position);

        // 4. Mostrar Snackbar con acción DESHACER
        Snackbar.make(view, "Restaurante añadido", Snackbar.LENGTH_LONG)
                .setAction("DESHACER", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Eliminar el último elemento añadido
                        listaRestaurantes.remove(position);
                        adapter.notifyItemRemoved(position);
                    }
                })
                .show();
    }
}