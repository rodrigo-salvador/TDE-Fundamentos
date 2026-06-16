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
<<<<<<< HEAD
    private Ingrediente vetIngrediente[];

    public Prato(String nome, double valor, int tam) {
=======
    private Ingrediente[] vetIngrediente;

    // construtor
    public Prato(String nome, double valor, int index, int tam) {
>>>>>>> origin/developRenato
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

<<<<<<< HEAD
    //getters
=======
    // getters
>>>>>>> origin/developRenato
    public String getNome() {
        return this.nome;
    }

    public double getValor() {
        return this.valor;
    }
<<<<<<< HEAD

    public boolean insereIngrediente(Ingrediente ing) {
        if (this.index < this.vetIngrediente.length) {
            this.vetIngrediente[this.index] = ing;
            this.index++;
            return true;
        }
        return false;
=======
    
    public int getIndex(){
        return this.index;
    }
    
    public Ingrediente[] getVetIngrediente() {
        return this.vetIngrediente;
>>>>>>> origin/developRenato
    }
    
    public Ingrediente getVetIngrediente(int pos) {
        return this.vetIngrediente[pos];
    }

    //Metodos de comportamento
    //a) adicionar prato.
    public boolean adicionarPrato(Ingrediente ing1)
    {
        if (this.index<this.vetIngrediente.length)
        {
            this.vetIngrediente[index] = ing1;
            index++;
            return true;
        }
        return false;
    }

    //b)consultar ingrediente.

    public Ingrediente consultarIngrediente(String nomeIng1)
    {
        for (int i = 0; i<this.index; i++)
        {
            if(this.vetIngrediente[i].getNome().equals(nomeIng1))
            {
                return vetIngrediente[i];
            }
        }
        return null;
    }

    //c)remover ingrediente.

    public boolean removerIngrediente(String ing1)
    {
        for (int i = 0; i<this.index; i++)
        {
            if(this.vetIngrediente[i].getNome().equals(ing1))
            {
                for (int j = i; j < this.index - 1; i++) 
                {
                    this.vetIngrediente[i] = this.vetIngrediente[i + 1];
                }
                return true;
            }
        }
        return false;
    }

    //d)mostra prato.

    public void mostraPrato() 
    {
        for (int i = 0; i < this.index; i++) 
        {
            System.out.println(this.vetIngrediente[i]);
        }
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
