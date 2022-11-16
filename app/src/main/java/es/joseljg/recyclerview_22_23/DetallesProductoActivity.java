package es.joseljg.recyclerview_22_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import es.joseljg.recyclerview_22_23.clases.Producto;

public class DetallesProductoActivity extends AppCompatActivity {

    private TextView txt_detalles_nombre;
    private TextView txt_detalles_precio;
    private TextView txt_detalles_cantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_producto);
        //--------------------------------------------------
        txt_detalles_nombre = (TextView) findViewById(R.id.txt_detalles_nombre);
        txt_detalles_precio = (TextView) findViewById(R.id.txt_detalles_precio);
        txt_detalles_cantidad = (TextView) findViewById(R.id.txt_detalles_cantidad);
        //--------------------------------------------------------------------------
        Intent intent = getIntent();
        if(intent != null)
        {
            Producto p = (Producto)intent.getSerializableExtra(ProductoViewHolder.EXTRA_PRODUCTO_ITEM);
            txt_detalles_nombre.setText(p.getNombre());
            txt_detalles_precio.setText(String.valueOf(p.getPrecio()));
            txt_detalles_cantidad.setText(String.valueOf(p.getCantidad()));
        }

    }

    public void volver(View view) {
        finish();
    }
}