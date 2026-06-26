public class Prato 
{
    // Criacao dos atributos privados a classe Prato
    private String nome;
    private double valor;
    private int index;
    private Ingrediente[] vetIngrediente;

    // Criacao do metodo Construtor com paramêtro da classe Prato
    public Prato(String nome, double valor, int tamanho) 
    {
        this.nome = nome;
        this.valor = valor;
        this.index = 0;
        this.vetIngrediente = new Ingrediente[tamanho];
    }
    // Metodos de Acesso da classe Prato - Setters
    // Metodo que ira alterar o atributo nome da classe Prato
    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    // Metodo que ira alterar o atributo valor da classe Prato
    public void setValor(double valor) 
    {
        this.valor = valor;
    }
    // Metodos de Acesso da classe Prato - Getters
    // Metodo que ira retornar o atributo nome da classe Prato
    public String getNome() 
    {
        return this.nome;
    }
    // Metodo que ira retornar o atributo valor da classe Prato
    public double getValor() 
    {
        return this.valor;
    }
    // Metodo que ira retornar o atributo index da classe Prato
    public int getIndex()
    {
        return this.index;
    }
    // Metodo que ira retornar o vetor de Ingredientes da classe Prato
    public Ingrediente[] getVetIngrediente() 
    {
        return this.vetIngrediente;

    }
    // Metodo que ira retornar o vetor de Ingredientes da classe Prato especifico de uma posicao encaminhada
    public Ingrediente getVetIngrediente(int posicao) 
    {
        return this.vetIngrediente[posicao];
    }
    // Metodos exclusivos da classe Prato, utilizados para manipular o vetor de objetos do tipo Ingrediente
    // Metodo de inserção de Ingredientes no vetor de Ingredientes da classe Prato
    public boolean adicionarIngrediente(Ingrediente ingrediente) 
    {
        // Verificacao do atributo index, atributo que é utilizado para controlar quantas insercoes foram efetuadas no vetor de forma a verificar se a insercao pode ser efetuada dentro do limite de espaco do vetor
        if (this.index < this.vetIngrediente.length) 
        {
            this.vetIngrediente[this.index] = ingrediente;
            this.index++;
            return true;
        }
        return false;
    }
    // Metodo que ira consultar e retornar se o Ingrediente inserido encontra-se no vetor de Ingredientes da classe Prato
    public Ingrediente consultarIngrediente(String nomeIngrediente)
    {
        // Loop utilizado para percorrer o vetor de Ingredientes para encontrarmos um ingrediente equivalente ao ingrediente solicitado na consulta
        for (int i = 0; i < this.index; i++)
        {
            // Caso o ingrediente seja encontrado, mostramos o ingrediente
            if(this.vetIngrediente[i].getNome().equalsIgnoreCase(nomeIngrediente))
            {
                return vetIngrediente[i];
            }
        }
        return null;
    }
    // Metodo que ira remover um Ingrediente ja inserido no vetor de Ingredientes da classe Prato
    public boolean removerIngrediente(String nomeIngrediente)
    {
        // Loop utilizado para percorrer o vetor de Ingredientes para encontrarmos um ingrediente equivalente ao ingrediente solicitado na consulta para remocao
        for (int i = 0; i < this.index; i++)
        {
            // Caso o ingrediente seja encontrado, atualizamos o vetor para remocao do ingrediente
            if(this.vetIngrediente[i].getNome().equalsIgnoreCase(nomeIngrediente))
            {
                // Segundo Loop utilizado caso ocorra a remocao para ordenar o restante dos ingredientes
                for (int j = i; j < this.index - 1; j++) 
                {
                    this.vetIngrediente[j] = this.vetIngrediente[j + 1];
                }
                // Apos remocao do ingrediente, precisamos atualizar a situacao do vetor, ajustando o index e a ultima posicao
                this.vetIngrediente[this.index - 1] = null;
                this.index--;
                return true;
            }
        }
        return false;
    }
    // Metodo que ira receber o nome de um ingrediente e verificar se ele esta inserido no vetor de Ingredientes da classe Prato, se esta inserido retorna a posicao, se nao retorna -1
    public int buscaPosicao(String nomeIngrediente) 
    {
        int posicao = -1;
        // Loop utilizado para percorrer o vetor de Ingredientes para encontrarmos um ingrediente equivalente ao ingrediente solicitado na consulta
        for (int i = 0; i < this.index; i++) 
        {
            // Caso o ingrediente seja encontrado, atualizado o valor da posicao e retornamos a mesma
            if (this.vetIngrediente[i].getNome().equalsIgnoreCase(nomeIngrediente)) 
            {
                posicao = i;
                return posicao;
            }
        }
        return posicao;
    }
    // Metodo que ira retornar em formato de String todos os atributos da classe Prato
    public String toString()
    {
        String resultado = "Nome: " + this.nome + "\nValor: R$ " + this.valor + "\nIngredientes:";
        // Loop utilizado para demonstrar os Ingredientes que a classe Prato possui
        for(int i = 0; i < this.index; i++)
        {
            resultado += "\n- " + this.vetIngrediente[i];
        }
        return resultado;
    }
}
