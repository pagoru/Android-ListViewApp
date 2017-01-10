package es.pagoru.listviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Titular[] datos =
                new Titular[]{
                        new Titular("Título 1", "Subtítulo largo 1", R.mipmap.ic_true),
                        new Titular("Título 2", "Subtítulo largo 2", R.mipmap.ic_false),
                        new Titular("Título 3", "Subtítulo largo 3", R.mipmap.ic_true),
                        new Titular("Título 4", "Subtítulo largo 4", R.mipmap.ic_true),
                        new Titular("Título 15", "Subtítulo largo 15", R.mipmap.ic_true)};

        AdaptadorTitulares adaptador =
                new AdaptadorTitulares(this, datos);

        ListView lstOpciones = (ListView)findViewById(R.id.LstOpciones);

        final MainActivity mainActivity = this;

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                String title = ((Titular)a.getItemAtPosition(position)).getTitulo();
                String subtitle = ((Titular)a.getItemAtPosition(position)).getSubtitulo();

                Toast.makeText(mainActivity, title + "\n" + subtitle,
                        Toast.LENGTH_LONG).show();
            }
        });
        
        lstOpciones.setAdapter(adaptador);
    }
}
