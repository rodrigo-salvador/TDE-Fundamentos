/** 
 * Criar, também, uma classe Prato que terá os seguintes atributos: 
 * nome (String), 
 * valor (double), 
 * vetIngredientes (vetor de Ingredientes)
 * index (int) que servirá para gerenciar as inserções e remoções dos ingredientes no vetIngredientes. 
 * O construtor desta classe deverá receber como parâmetro o nome, o valor do prato e a quantidade de ingredientes que o prato possui. 
 * Ainda no construtor devem ser atribuídos os valores aos atributos, inicializar o atributo index e instanciar o vetor de ingredientes (vetIngredientes) com a quantidade de ingredientes que o prato possui. 
 * Crie os demais métodos básicos necessários para a classe (estejam atentos ao atributo index que apenas a classe deve ter acesso a ele e ao atributo veIngredientes que terá seus próprios métodos de acesso, relacionados abaixo). 
 * Além do construtor e dos métodos básicos, a classe Prato deve possuir os seguintes métodos:
 * a) adicionarIngrediente que recebe um Ingrediente e, se houver espaço, adiciona-o ao vetor de ingredientes, retorna true se a inserção pode ser realizada ou false se a inserção não foi possível;
 * b) consultarIngrediente que recebe o nome do ingrediente, procura-o no vetor de ingredientes e o retorna;
 * c) removerIngrediente que recebe o nome do ingrediente, consulta-o no vetor de ingredientes e, ao encontrá-lo, o remove do vetor de ingredientes, fazendo a reorganização do vetor de ingredientes. Retorna true se a remoção foi realizada com sucesso ou false se a remoção não foi possível;
 * d) buscarPosicao que recebe o nome do ingrediente e retorna a posição em que ele está armazenado no vetor de ingredientes. Caso não esteja armazenado, retorna -1;
 */
public class Prato {
    private String nome;
    private double valor;
    private int index;
    private Ingrediente[] vetIngrediente;

    // construtor
    public Prato(String nome, double valor, int index, int tam) {
        this.nome = nome;
        this.valor = valor;
        this.index = 0;
        this.vetIngrediente = new Ingrediente[tam];
    }

    // metodos de acesso
    // setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    // getters
    public String getNome() {
        return this.nome;
    }

    public double getValor() {
        return this.valor;
    }
    
    public int getIndex(){
        return this.index;
    }
    
    public Ingrediente[] getVetIngrediente() {
        return this.vetIngrediente;
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

    // toString
    public String toString() {
        // não consegui fazer retornar os ingredientes, só o endereço na memória
        return "Nome: " + this.nome + "\nValor: " + this.valor + "\nIngrediente: " + this.vetIngrediente;
    }
}