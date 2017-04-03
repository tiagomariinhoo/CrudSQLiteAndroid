package app.com.example.wagner.meupredi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wagne on 31/03/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABA_NAME = "Banco";

    // LINHAS DO BANCO
    private static final String TABLE_PACIENTES = "pacientes";

    // COLUNAS DO BANCO
    private static final String KEY_ID = "id";
    private static final String KEY_NOME = "nome";
    private static final String KEY_IDADE = "idade";
    private static final String KEY_CIRCUNFERENCIA = "circunferencia";;
    private static final String KEY_PESO = "peso";

    public DatabaseHandler(Context context) {
        super(context, DATABA_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String  CREATE_PACIENTES_TABLE = "CREATE TABLE IF NOT EXIST "
                + TABLE_PACIENTES
                + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NOME + " TEXT,"
                + KEY_IDADE + " INTEGER,"
                + KEY_CIRCUNFERENCIA + " REAL,"
                + KEY_PESO + " REAL"
                + ")";
        db.execSQL(CREATE_PACIENTES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PACIENTES);

        onCreate(db);
    }

    String addPaciente(Paciente paciente){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NOME, paciente.get_nome());
        values.put(KEY_IDADE, paciente.get_idade());
        values.put(KEY_CIRCUNFERENCIA, paciente.get_circunferencia());
        values.put(KEY_PESO, paciente.get_peso());

        long retorno;
        retorno = db.insert(TABLE_PACIENTES, null, values);
        db.close();

        if(retorno==-1){
            return "Erro ao inserir o registro!";
        } else {
            return "Registro inserido com sucesso!";
        }
    }

    public Paciente getPacient(int id){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABLE_PACIENTES, new String[]{
                        KEY_ID,
                        KEY_NOME,
                        KEY_IDADE,
                        KEY_CIRCUNFERENCIA,
                        KEY_PESO}, KEY_ID + "=?",
                        new String[]{ String.valueOf(id)},
                        null, null, null, null);

                    if(cursor!= null) {
                        cursor.moveToFirst();
                    }

                    Paciente paciente = new Paciente(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                            Integer.parseInt(cursor.getString(2)), Double.parseDouble(cursor.getString(3)), Double.parseDouble(cursor.getString(4)));

                return paciente;
        }

    public List<Paciente> getAllPacientes(){

        List<Paciente> pacientesList = new ArrayList<Paciente> ();

        String selectQuery = "SELECT * FROM " + TABLE_PACIENTES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do{
                Paciente paciente = new Paciente();
                paciente.set_id(Integer.parseInt(cursor.getString(0)));
                paciente.set_nome(cursor.getString(1));
                paciente.set_idade(Integer.parseInt(cursor.getString(2)));
                paciente.set_circunferencia(Integer.parseInt(cursor.getString(3)));
                paciente.set_peso(Integer.parseInt(cursor.getString(4)));

                pacientesList.add(paciente);

            }while(cursor.moveToNext());
        }
        return pacientesList;
    }

    public void deletePaciente(Paciente paciente){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PACIENTES, KEY_ID + " = ?",
                new String[]{ String.valueOf(paciente.get_id())});
        db.close();
    }

    public void deleteAllPacientes() {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "DELETE FROM " + TABLE_PACIENTES;

        db.execSQL(selectQuery);
        db.close();
    }
}
