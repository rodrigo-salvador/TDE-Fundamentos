<<<<<<< HEAD
package Trabalho_Final;


=======
>>>>>>> origin/develop
/**
 * Criar uma classe chamada Ingrediente que terá os seguintes atributos: 
 * nome (String), 
 * medida (String) 
 * quantidade (double). 
 * Crie os métodos básicos para a classe.
 */

public class Ingrediente {
    // Variaveis de instância
    private String nome;
    private String medida;
    private double quantidade;
    // construtor com paramêtro
    public Ingrediente(String nome, String medida, double quantidade) {
        this.nome = nome;
        this.medida = medida;
        this.quantidade = quantidade;
    }

    // construtor padrão
    public Ingrediente() {
        this.nome = null;
        this.medida = null;
        this.quantidade = 0;
    }

    // metodos de acesso
    // setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    // getters
    public String getNome() {
        return this.nome;
    }

    public String getMedida() {
        return this.medida;
    }

    public double getQuantidade() {
        return this.quantidade;
    }

    // toString
    public String toString() {
        return "Nome: " + this.nome + " Medida: " + this.medida + " Quantidade: " + this.quantidade;
    }
}
