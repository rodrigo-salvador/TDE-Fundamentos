package Trabalho_Final;

/**
 * Criar uma classe chamada Ingrediente que terá os seguintes atributos: 
 * nome (String), 
 * medida (String) 
 * quantidade (double). 
 * Crie os métodos básicos para a classe.
 */
public class Ingrediente 
{
    // Criacao dos atributos privados a classe Ingrediente
    private String nome;
    private String medida;
    private double quantidade;
    
    // Criacao do metodo Construtor com paramêtro
    public Ingrediente(String nome, String medida, double quantidade) 
    {
        this.nome = nome;
        this.medida = medida;
        this.quantidade = quantidade;
    }
    // Metodos de Acesso da classe Ingrediente - Setters
    // Metodo que ira alterar o atributo nome da classe ingrediente
    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    // Metodo que ira alterar o atributo medida da classe ingrediente
    public void setMedida(String medida) 
    {
        this.medida = medida;
    }
    // Metodo que ira alterar o atributo quantidade da classe ingrediente
    public void setQuantidade(double quantidade) 
    {
        this.quantidade = quantidade;
    }
    // Metodos de Acesso da classe Ingrediente - Getters
    // Metodo que ira retornar o atributo nome da classe Ingrediente
    public String getNome() 
    {
        return this.nome;
    }
    // Metodo que ira retornar o atributo medida da classe Ingrediente
    public String getMedida() 
    {
        return this.medida;
    }
    // Metodo que ira retornar o atributo quantidade da classe Ingrediente
    public double getQuantidade() 
    {
        return this.quantidade;
    }
    // Metodo que ira retornar em formato de String todos os atributos da classe Ingrediente
    public String toString() 
    {
        return "Nome: " + this.nome + " Medida: " + this.medida + " Quantidade: " + this.quantidade;
    }
}
