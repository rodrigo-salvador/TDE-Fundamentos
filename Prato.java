package Trabalho_Final;


/**
 * Escreva uma descrição da classe Prato aqui. 
 * 
 * @author (VASCO)
 * @version (06.02.2026)
 */
public class Prato {
    private String nome;
    private double valor;
    private int index;
    private ControleIngrediente vetIngrediente;

    // construtor
    public Prato(String nome, double valor, ControleIngrediente vetIngrediente) {
        this.nome = nome;
        this.valor = valor;
        this.index = 0;
        this.vetIngrediente = vetIngrediente;
    }

    // metodos de acesso
    // setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setVetIngrediente(ControleIngrediente ingrediente) {
        this.vetIngrediente = ingrediente;
    }

    // getters
    public String getNome() {
        return this.nome;
    }

    public double getValor() {
        return this.valor;
    }

    public ControleIngrediente getVetIngrediente() {
        return this.vetIngrediente;
    }

    // toString
    public String toString() {
        // não consegui fazer retornar os ingredientes, só o endereço na memória
        return "Nome: " + this.nome + "\nValor: " + this.valor + "\nIngrediente: " + this.vetIngrediente;
    }
}
