package app.com.example.wagner.meupredi;

/**
 * Created by wagne on 31/03/2017.
 */

public class Paciente {

    int _id;
    String _nome;
    int _idade;
    double _circunferencia;
    double _peso;

    // CONSTRUTOR VAZIO
    public Paciente(){

    }

    public Paciente(int id, String nome, int idade, double circunferencia, double peso){
        this._id = id;
        this._nome = nome;
        this._idade = idade;
        this._circunferencia = circunferencia;
        this._peso = peso;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_nome() {
        return _nome;
    }

    public void set_nome(String _nome) {
        this._nome = _nome;
    }

    public int get_idade() {
        return _idade;
    }

    public void set_idade(int _idade) {
        this._idade = _idade;
    }

    public double get_circunferencia() {
        return _circunferencia;
    }

    public void set_circunferencia(double _circunferencia) {
        this._circunferencia = _circunferencia;
    }

    public double get_peso() {
        return _peso;
    }

    public void set_peso(double _peso) {
        this._peso = _peso;
    }
}
