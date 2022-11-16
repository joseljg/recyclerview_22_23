package es.joseljg.recyclerview_22_23;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import es.joseljg.recyclerview_22_23.clases.Producto;

public class ProductoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public static final String EXTRA_PRODUCTO_ITEM = "es.joseljg.productosviewholder.producto";
    // atributos
    private TextView txt_item_nombre;
    private TextView txt_item_precio;
    private TextView txt_item_cantidad;
    private ImageView img_item_producto;
    //-------------------------------------
    private ListaProductosAdapter lpa;

    public ImageView getImg_item_producto() {
        return img_item_producto;
    }

    public void setImg_item_producto(ImageView img_item_producto) {
        this.img_item_producto = img_item_producto;
    }

    public ProductoViewHolder(@NonNull View itemView, ListaProductosAdapter listaProductosAdapter) {
        super(itemView);
        txt_item_nombre = (TextView) itemView.findViewById(R.id.txt_item_nombre);
        txt_item_precio = (TextView) itemView.findViewById(R.id.txt_item_precio);
        txt_item_cantidad = (TextView) itemView.findViewById(R.id.txt_item_cantidad);
        img_item_producto = (ImageView) itemView.findViewById(R.id.img_item_producto);
        //-----------------------------------------------------------------------------
        lpa = listaProductosAdapter;
        itemView.setOnClickListener(this);
    }

    public TextView getTxt_item_nombre() {
        return txt_item_nombre;
    }

    public void setTxt_item_nombre(TextView txt_item_nombre) {
        this.txt_item_nombre = txt_item_nombre;
    }

    public TextView getTxt_item_precio() {
        return txt_item_precio;
    }

    public void setTxt_item_precio(TextView txt_item_precio) {
        this.txt_item_precio = txt_item_precio;
    }

    public TextView getTxt_item_cantidad() {
        return txt_item_cantidad;
    }

    public void setTxt_item_cantidad(TextView txt_item_cantidad) {
        this.txt_item_cantidad = txt_item_cantidad;
    }

    @Override
    public void onClick(View view) {
       int posicion = getLayoutPosition();
       Producto p = lpa.getProductos().get(posicion);
       Intent intent = new Intent(lpa.getContexto(),DetallesProductoActivity.class);
       intent.putExtra(EXTRA_PRODUCTO_ITEM,p);
       lpa.getContexto().startActivity(intent);
    }
}
