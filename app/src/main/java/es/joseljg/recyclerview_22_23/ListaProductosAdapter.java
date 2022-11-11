package es.joseljg.recyclerview_22_23;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.joseljg.recyclerview_22_23.clases.Producto;

public class ListaProductosAdapter extends RecyclerView.Adapter<ProductoViewHolder> {
    public ListaProductosAdapter(MainActivity mainActivity, ArrayList<Producto> productos) {
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
