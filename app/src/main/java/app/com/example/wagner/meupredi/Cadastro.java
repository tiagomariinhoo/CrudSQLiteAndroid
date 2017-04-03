package app.com.example.wagner.meupredi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {

    EditText nome;
    EditText idade;
    EditText peso;
    EditText circunferencia;
    Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        overridePendingTransition(R.anim.activity_cadastro_entrando, R.anim.activity_main_saindo);



        nome = (EditText) findViewById(R.id.edit_text_nome);
        idade = (EditText) findViewById(R.id.edit_text_idade);
        peso = (EditText) findViewById(R.id.edit_text_peso);
        circunferencia = (EditText) findViewById(R.id.edit_text_circunferencia);


        btnConfirmar = (Button) findViewById(R.id.btConfirmar);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeString = nome.getText().toString();
                String idadeString = idade.getText().toString();
                String pesoString = peso.getText().toString();
                String circString = circunferencia.getText().toString();

                DatabaseHandler crud;
                crud = new DatabaseHandler(Cadastro.this);

                Paciente paciente = new Paciente(0, nomeString, Integer.parseInt(idadeString), Double.parseDouble(pesoString),Double.parseDouble(circString));
                String retorno = crud.addPaciente(paciente);

                Toast.makeText(getApplicationContext(), retorno, Toast.LENGTH_LONG).show();

                Intent it = new Intent(Cadastro.this, MainActivity.class);
                startActivity(it);

            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
