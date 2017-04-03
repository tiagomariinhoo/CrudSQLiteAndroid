package app.com.example.wagner.meupredi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Status extends AppCompatActivity {

    private ArrayList<String> listaDePacientes = new ArrayList<String>();
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //ABRE BANCO
        DatabaseHandler db = new DatabaseHandler(this);

        //PEGA TODA A INFO
        List<Paciente> pacientes = db.getAllPacientes();

        //LISTA OS PACIENTES
        for (Paciente p : pacientes) {
            Log.d(p.get_nome(), "Nome: ");
        }

        //DEFINE ADAPTER E SETA NA LISTVIEW
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaDePacientes);
        //lista = (ListView) findViewById(R.id.lista_pacientes);
       // lista.setAdapter(adapter);
    }

}
