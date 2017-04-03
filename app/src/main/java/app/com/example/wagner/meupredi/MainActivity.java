package app.com.example.wagner.meupredi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastro;
    private Button btnEdicao;
    private Button btnStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        //db.deleteAllPacientes();

        // INSERIR PACIENTES
        Log.d("Insert: ", "Inserting...");
        //db.addPaciente(new Paciente(0, "Amand", 13, 11, 9));
        //db.addPaciente(new Paciente(0, "Laura", 13, 11, 9));
        //db.addPaciente(new Paciente(0, "Shelly", 15, 12, 3));

        Log.d("Reading: ", "Reading all contacts..");

        btnCadastro = (Button) findViewById(R.id.btn_cadastro);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // SAIR DA MAIN PRA TELA DE CADASTRO
                Intent intent = new Intent(MainActivity.this, Cadastro.class);
                // CHAMAR A TELA DE CADASTRO
                startActivity(intent);
            }
        });

        btnEdicao = (Button) findViewById(R.id.btn_edicao);

        btnEdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // SAIR DA MAIN PRA TELA DE CADASTRO
                Intent intent = new Intent(MainActivity.this, Edicao.class);
                // CHAMAR A TELA DE CADASTRO
                startActivity(intent);
            }
        });

        btnStatus = (Button) findViewById(R.id.btn_status);

        btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // SAIR DA MAIN PRA TELA DE CADASTRO
                Intent intent = new Intent(MainActivity.this, Status.class);
                // CHAMAR A TELA DE CADASTRO
                startActivity(intent);
            }
        });

    }
}
