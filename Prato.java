package Trabalho_Final;
/**
 * Classe intermediária de ingrediente (classe Prato), onde podemos manipular o vetor de ingredientes.
 * Adicionar métodos como:
 * Adicionar ingrediente
 * Remover ingrediente
 * Procurar ingrediente
 * 
 * @author (Vasco)
 * @version (08.06.2026)
 */

public class Prato {
    private String nome;
    private double valor;
    private int index;
    private Ingrediente vetIngrediente[];

    public Prato(String nome, double valor, int tam) {
        this.nome = nome;
        this.valor = valor;
        this.index = 0;
        this.vetIngrediente = new Ingrediente[tam];
    }

    //metodos de acessso
    //setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    //getters
    public String getNome() {
        return this.nome;
    }

    public double getValor() {
        return this.valor;
    }

    public boolean insereIngrediente(Ingrediente ing) {
        if (this.index < this.vetIngrediente.length) {
            this.vetIngrediente[this.index] = ing;
            this.index++;
            return true;
        }
        return false;
    }

    public int encontraPos(String nome) {
        int pos = -1;
        for (int i = 0; i < this.index; i++) {
            if (this.vetIngrediente[i].getNome().equals(nome)) {
                pos = i;
                return pos;
            }
        }
        return pos;
    }

    public boolean excluirIngrediente(String nome) {
        int pos = encontraPos(nome);
        if (pos == -1) {
            return false;
        }
        for (int i = pos; i < this.index - 1; i++) {
            this.vetIngrediente[i] = this.vetIngrediente[i + 1];
        }
        this.vetIngrediente[this.index - 1] = null;
        this.index--;
        return true;
    }

    public void mostraIngrediente() {
        for (int i = 0; i < this.index; i++) {
            System.out.println(this.vetIngrediente[i]);
        }
    }
    public String toString() {
        return "Nome: " + this.nome + "\nValor: " + this.valor;
    }
}
