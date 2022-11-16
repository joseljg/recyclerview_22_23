package es.joseljg.recyclerview_22_23;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.joseljg.recyclerview_22_23.clases.Producto;

public class ListaProductosAdapter extends RecyclerView.Adapter<ProductoViewHolder> {
    // atributos
    private Context contexto = null;
    private ArrayList<Producto> productos = null;
    private LayoutInflater inflate = null;

    public ListaProductosAdapter(Context contexto, ArrayList<Producto> productos) {
        this.contexto = contexto;
        this.productos = productos;
        inflate =  LayoutInflater.from(this.contexto);
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = inflate.inflate(R.layout.item_producto,parent,false);
        ProductoViewHolder evh = new ProductoViewHolder(mItemView,this);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
     Producto p = this.productos.get(position);
     holder.getTxt_item_nombre().setText("nombre: " + p.getNombre());
     holder.getTxt_item_cantidad().setText("cantidad " + String.valueOf(p.getCantidad()));
     holder.getTxt_item_precio().setText(String.valueOf("precio: " + p.getPrecio()));
     holder.getImg_item_producto().setImageResource(R.drawable.fruta);
    }

    @Override
    public int getItemCount() {
        return this.productos.size();
    }
}
