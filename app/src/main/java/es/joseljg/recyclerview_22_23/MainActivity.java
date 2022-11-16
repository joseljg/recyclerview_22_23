package es.joseljg.recyclerview_22_23;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;

import es.joseljg.recyclerview_22_23.clases.Producto;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_productos = null;
    private ListaProductosAdapter adaptadorProductos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_productos = (RecyclerView) findViewById(R.id.rv_productos);
        //-------------------------------------------------------------
        // voy a simular que he obtenido de la base de datos una lista de productos
        ArrayList<Producto> productos = new ArrayList<Producto>();
        productos.add(new Producto("manzanas",2.4,2));
        productos.add(new Producto("peras",1.3,1));
        productos.add(new Producto("kiwis",3.4,2));
        productos.add(new Producto("fresas",4.4,3));
        productos.add(new Producto("limones",5.4,2));
        productos.add(new Producto("melon",4.4,3));
        productos.add(new Producto("tomates",3.4,3));
        productos.add(new Producto("platanos",2.4,2));
        productos.add(new Producto("zanahorias",1.4,1));
        productos.add(new Producto("cherrys",3.2,1));
        productos.add(new Producto("aguacate",4.4,1));
        //-----------------------------------------------------------------
        adaptadorProductos = new ListaProductosAdapter(this,productos);
        rv_productos.setAdapter(adaptadorProductos);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // In landscape
            rv_productos.setLayoutManager(new GridLayoutManager(this,2));
        } else {
            // In portrait
            rv_productos.setLayoutManager(new LinearLayoutManager(this));
        }
//----------------------------------------------------------------------------------------------
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(productos, from, to);
                adaptadorProductos.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                if(direction == ItemTouchHelper.LEFT)
                {
                    // Ciudad c = ciudades.get(viewHolder.getAdapterPosition());
                    // CiudadController.borrarCiudad(c);
                    productos.remove(viewHolder.getAdapterPosition());
                    adaptadorProductos.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
                if(direction == ItemTouchHelper.RIGHT)
                {
                    productos.remove(viewHolder.getAdapterPosition());
                    adaptadorProductos.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
                if(direction == ItemTouchHelper.UP)
                {
                    //estudiantes.remove(viewHolder.getAdapterPosition());
                    //adaptadorEstudiantes.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
                if(direction == ItemTouchHelper.DOWN)
                {
                    //estudiantes.remove(viewHolder.getAdapterPosition());
                    //adaptadorEstudiantes.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
            }
        });
        helper.attachToRecyclerView(rv_productos);
    }
}