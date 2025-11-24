package com.guillermomartin.gofoodapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RestauranteAdapter extends RecyclerView.Adapter<RestauranteAdapter.RestauranteViewHolder> {

    private List<Restaurante> listaRestaurantes;

    public RestauranteAdapter(List<Restaurante> listaRestaurantes) {
        this.listaRestaurantes = listaRestaurantes;
    }

    @NonNull
    @Override
    public RestauranteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurante, parent, false);
        return new RestauranteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestauranteViewHolder holder, int position) {
        Restaurante restaurante = listaRestaurantes.get(position);

        // Asignar datos
        holder.tvNombre.setText(restaurante.getNombre());
        holder.tvTipo.setText(restaurante.getTipoComida());
        holder.tvMenu.setText(restaurante.getMenuDestacado());

        // Lógica del Desplegable (Expandable)
        boolean isExpanded = restaurante.isExpanded();
        holder.layoutDesplegable.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

        // Al hacer clic en el elemento, invertimos el estado de expansión
        holder.itemView.setOnClickListener(v -> {
            restaurante.setExpanded(!restaurante.isExpanded());
            notifyItemChanged(position); // Notificamos cambio para animar/refrescar
        });

        // Funcionalidad Extra: Botón pedir muestra un Toast
        holder.btnPedir.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "Pedido realizado a " + restaurante.getNombre(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return listaRestaurantes.size();
    }

    public static class RestauranteViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvTipo, tvMenu;
        LinearLayout layoutDesplegable;
        Button btnPedir;

        public RestauranteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombreRestaurante);
            tvTipo = itemView.findViewById(R.id.tvTipoComida);
            tvMenu = itemView.findViewById(R.id.tvMenuDestacado);
            layoutDesplegable = itemView.findViewById(R.id.layoutDesplegable);
            btnPedir = itemView.findViewById(R.id.btnPedir);
        }
    }
}