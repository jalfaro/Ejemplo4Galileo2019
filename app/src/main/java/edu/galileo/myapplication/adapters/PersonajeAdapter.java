package edu.galileo.myapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import edu.galileo.myapplication.R;
import edu.galileo.myapplication.data.Personaje;

public class PersonajeAdapter extends ArrayAdapter<Personaje> {
    private Context context;
    private List<Personaje> list;

    public PersonajeAdapter(@NonNull Context context,   @NonNull List<Personaje> objects) {
        super(context, R.layout.item_personaje_layout, objects);
        this.context = context;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.item_personaje_layout, null);
        }
        if (list.get(position) != null) {
            TextView nombre;
            ImageView imagen;
            nombre = v.findViewById(R.id.txt_nombre_personaje);
            imagen = v.findViewById(R.id.img_imagen_personaje);
            nombre.setText(list.get(position).getNombre());
            imagen.setImageResource(list.get(position).getImagen());
        }
        return  v;
    }

    @Override
    public View getDropDownView(int position,  @Nullable View convertView,  @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.item_personaje_layout, null);
        }
        if (list.get(position) != null) {
            TextView nombre;
            ImageView imagen;
            /**** DUDA TAREA
            if (lista.get(position).getTipo()== 1) {
                imagen.setImageResource(R.drawable.perro);
            } else if (lista.get(position).getTipo()== 2) {
                imagen.setImageResource(R.drawable.gato);
            } else {
                imagen.setImageResource(R.drawable.ave);
            }
             ***/
            nombre = v.findViewById(R.id.txt_nombre_personaje);
            imagen = v.findViewById(R.id.img_imagen_personaje);
            nombre.setText(list.get(position).getNombre());
            imagen.setImageResource(list.get(position).getImagen());
        }
        return  v;
    }
}
