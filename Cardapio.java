/**
 * O gerenciamento dos pratos deve ser feito na classe Cardapio que também deve
 * ser criada.
 * Nesta classe, serão armazenados os pratos do restaurante. Crie um construtor
 * que recebe a quantidade de pratos que o restaurante possui e cria o cardápio
 * (vetor de pratos – você define quantos pratos haverá no cardápio).
 * Além do construtor, esta classe deve ter os seguintes métodos:
 * a) adicionarPrato: insere um objeto prato no vetor e para isto, recebe o
 * objeto prato e retorna true se a inserção pode ser realizada ou false se a
 * inserção não foi possível;
 * b) removerPrato: recebe o nome do prato e, caso ele exista, remove o prato do
 * cardápio, reorganiza os objetos e retorna true se a remoção foi realizada com
 * sucesso ou false se a remoção não foi possível;
 * c) buscarPratoPorNome: recebe o nome do prato e retorna o prato que possui
 * este nome;
 * d) buscarPosicao: recebe o prato e retorna a posição do vetor em que este
 * prato está armazenado. Caso não esteja armazenado, retorna o valor -1;
 * e) buscarPratoIngrediente: recebe o nome do prato e retorna um vetor com os
 * pratos em que este ingrediente faça parte;
 * f) buscarValorCardapio: retorna o somatório do valor de todos os pratos do
 * restaurante;
 * g) buscarPratoEconomico: retorna o prato que possui o menor valor;
 * h) mostrarPratos: mostra os dados dos pratos do cardápio.
 */
public class Cardapio {
    private int index;
    private Prato vetPrato[];

    public Cardapio(int tam) {
        this.vetPrato = new Prato[tam];
        this.index = 0;
    }

    // Recebe o vetor dos pratos e um prato novo, verifica qual posição está vazia e
    // o adiciona lá. retorna true se for possível
    // e retorna false, se não for possível.

    public boolean adicionarPrato(Prato vetPrato[], Prato prato1) {
        if (this.index<this.vetPrato.length)
        {
            this.vetPrato[index] = prato1;
            index++;
            return true;
        }
        return false;
    }

    
    //Recebe o nome do prato, localiza o nome dele dentro do vetor de pratos, se o localizou, o remove, retorna true e reorganiza os pratos, se não foi possível o localizar, retorna false
     
    public boolean removerPrato(String nomePrato) {
        for (int i = 0; i<this.index; i++)
        {
            if(this.vetPrato[i].getNome().equals(nomePrato))
            {
                for (int j = i; j < this.index - 1; i++) 
                {
                    this.vetPrato[i] = this.vetPrato[i + 1];
                }
                return true;
            }
        }
        return false;
    }

    // Recebe o nome do prato e retorna o objeto prato com esse nome.

    public Prato buscarPratoPorNome(String nomePrato) {
        for (int i = 0; i < this.index; i++) {
            if (this.vetPrato[i].getNome().equals(nomePrato)) {
                return this.vetPrato[i];
            }
        }
        return null;
    }

    // Recebe um objeto prato, verifica se está no cardápio e retorna sua posição, se não estiver no cardápio retorna -1.

    public int buscarPosicao(Prato prato1) {
        for (int i = 0; i < this.index; i++) {
            if (this.vetPrato[i] == prato1) {
                return i;
            }
        }
        return -1;
    }

    //Recebe o nome do ingrediente, ve quantos pratos tem esse ingrediente usando um contador, cria um vetor novo com o numero do contador e adiciona os pratos com esse ingrediente no novo vetor, logo após o retorna
    
    public Prato[] buscarPratoIngrediente(String nomeIngrediente) 
    {
        int cont = 0, k = 0;
        for (int i = 0; i<this.index; i++)
        {
            for (int j = 0; j<this.vetPrato[i].getIndex(); j++)
            {
                if (this.vetPrato[i].getVetIngrediente(j).getNome().equals(nomeIngrediente))
                {
                    cont++;
                }
            }
        }
        
        Prato vetPratoNovo[] = new Prato[cont];
        
        for (int i = 0; i<this.index; i++)
        {
            for (int j = 0; j<this.vetPrato[i].getIndex(); j++)
            {
                if (this.vetPrato[i].getVetIngrediente(j).getNome().equals(nomeIngrediente))
                {
                    vetPratoNovo[k] = vetPrato[i];
                    k++;
                }
            }
        }
        
        return vetPratoNovo;
    }

    // Recebe um vetor de pratos, e soma o preço de cada um deles.

    public double buscarValorCardapio(Prato vetPrato[]) {
        double soma = 0;
        for (int i = 0; i < this.index; i++) {
            soma += vetPrato[i].getValor();
        }
        return soma;
    }

    // Recebe o vetor de pratos, procura qual tem o menor valor e retorna ele.

    public Prato buscarPratoEconomico() {
        double menor = 99999;
        int pos = 0;
        for (int i = 0; i < this.index; i++) {
            if (this.vetPrato[i].getValor() < menor) {
                menor = vetPrato[i].getValor();
                pos = i;
            }
        }
        return this.vetPrato[pos];
    }

    // Recebe um vetor de pratos, e mostra o ToString de cada um.
    public void mostrarPratos(Prato vetPrato[]) {
        for (int i = 0; i < this.index; i++) {
            System.out.print(vetPrato[i]);
        }
    }
}