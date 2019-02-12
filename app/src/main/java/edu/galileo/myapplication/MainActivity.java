package edu.galileo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.galileo.myapplication.adapters.PersonajeAdapter;
import edu.galileo.myapplication.data.Personaje;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    private List<Personaje> listado;
    private Spinner spnPersonaje;
    private ListView lstPersonaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Personaje temp;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spnPersonaje = findViewById(R.id.spn_personajes);
        lstPersonaje = findViewById(R.id.lst_personajes);
        listado = new ArrayList<Personaje>();
        temp = new Personaje();
        temp.setImagen(R.drawable.donald);
        temp.setNombre("Donald Duck");
        listado.add(temp);
        temp = new Personaje();
        temp.setImagen(R.drawable.mickey);
        temp.setNombre("Mickey Mouse");
        listado.add(temp);
        temp = new Personaje();
        temp.setImagen(R.drawable.pumba);
        temp.setNombre("Pumba");
        listado.add(temp);
        spnPersonaje.setAdapter(new PersonajeAdapter(this, listado));
        spnPersonaje.setOnItemSelectedListener(this);

        lstPersonaje.setAdapter(new PersonajeAdapter(this, listado));
        lstPersonaje.setOnItemClickListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, listado.get(position).getNombre(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Personaje personaje = ((Personaje)spnPersonaje.getSelectedItem());
        Toast.makeText(this,personaje.getNombre() + " no se cambio seleccion", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, listado.get(position).getNombre() + " de la lista", Toast.LENGTH_SHORT).show();
    }
}
