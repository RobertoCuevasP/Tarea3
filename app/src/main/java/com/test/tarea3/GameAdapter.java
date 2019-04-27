package com.test.tarea3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GameAdapter extends BaseAdapter {
    private Context context;
    private List<Juego> items;

    public GameAdapter(Context context, List<Juego> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Juego getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View vista, ViewGroup parent) {
        ViewHolder viewHolder;
        if (vista == null) { //No se puede reciclar
            viewHolder = new ViewHolder();

            //Inflater nos permite usar un layout dentro de un componente
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.activity_main, null); //Cual layout y principal o no.

            viewHolder.cover = vista.findViewById(R.id.cover);
            viewHolder.precio = vista.findViewById(R.id.precio);
            viewHolder.nombre = vista.findViewById(R.id.nombre);
            vista.setTag(viewHolder); //Guardar para reciclar
        } else {
            viewHolder = (ViewHolder) vista.getTag(); //Obtener el dato reciclado
        }

        Juego cancionActual = items.get(position);
        viewHolder.nombre.setText(cancionActual.getGameName());
        viewHolder.precio.setText(cancionActual.getPrize());
        viewHolder.cover.setImageResource(cancionActual.getCoverImage());
        return vista;
    }

    static class ViewHolder {
        ImageView cover;
        TextView nombre;
        TextView precio;
    }
}
