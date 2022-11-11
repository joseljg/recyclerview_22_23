package es.joseljg.recyclerview_22_23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

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

    }
}