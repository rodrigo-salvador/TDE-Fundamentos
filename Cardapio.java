import java.util.Scanner;

public class Cardapio {
    // Criacao dos atributos privados a classe Cardapio
    private int index;
    private Prato[] vetPrato;
    private int[] notas;
    private String[] comentarios;
    private int indiceAvaliacao;

    // Criacao do metodo Construtor com paramêtro da classe Cardapio
    public Cardapio(int tamanho) {
        this.vetPrato = new Prato[tamanho];
        this.index = 0;
        notas = new int[100];
        comentarios = new String[100];
        this.indiceAvaliacao = 0;
    }

    // Metodo que ira retornar o atributo index da classe Cardapio
    public int getIndex() {
        return this.index;
    }

    public int getIndiceAvaliacao() {
        return this.indiceAvaliacao;
    }

    // Metodo que ira retornar o vetor de Pratos da classe Cardapio
    public Prato[] getVetPrato() {
        return this.vetPrato;
    }

    // Metodos exclusivos da classe Cardapio, utilizados para manipular o vetor de
    // objetos do tipo Prato
    // Metodo de inserção de Pratos no vetor de Pratos da classe Cardapio
    public boolean adicionarPrato(Prato prato) {
        // Verificacao do atributo index, atributo que é utilizado para controlar
        // quantas insercoes foram efetuadas no vetor de forma a verificar se a insercao
        // pode ser efetuada dentro do limite de espaco do vetor
        if (this.index < this.vetPrato.length) {
            this.vetPrato[index] = prato;
            index++;
            return true;
        }
        return false;
    }

    // Metodo que ira remover um Prato ja inserido no vetor de Pratos da classe
    // Cardapio
    public boolean removerPrato(String nomePrato) {
        // Loop utilizado para percorrer o vetor de Pratos para encontrarmos um prato
        // equivalente ao prato solicitado na consulta
        for (int i = 0; i < this.index; i++) {
            // Caso o prato seja encontrado, atualizamos o vetor para remocao do prato
            if (this.vetPrato[i].getNome().equalsIgnoreCase(nomePrato)) {
                // Segundo Loop utilizado caso ocorra a remocao para ordenar o restante dos
                // pratos
                for (int j = i; j < this.index - 1; j++) {
                    this.vetPrato[j] = this.vetPrato[j + 1];
                }
                // Apos remocao do ingrediente, precisamos atualizar a situacao do vetor,
                // ajustando o index e a ultima posicao
                this.vetPrato[this.index - 1] = null;
                this.index--;
                return true;
            }
        }
        return false;
    }

    // Metodo que ira consultar e retornar o Prato com o nome encaminhado na
    // consulta caso ele seja encontrado no vetor de Pratos da classe Cardapio
    public Prato buscarPratoPorNome(String nomePrato) {
        // Loop utilizado para percorrer o vetor de Pratos para encontrarmos um prato
        // equivalente ao prato solicitado na consulta
        for (int i = 0; i < this.index; i++) {
            // Caso o prato seja encontrado, mostramos o prato com o nome solicitado
            if (this.vetPrato[i].getNome().equalsIgnoreCase(nomePrato)) {
                return this.vetPrato[i];
            }
        }
        return null;
    }

    // Metodo que ira receber um prato e verificar se ele esta inserido no vetor de
    // Pratos da classe Cardapio, se esta inserido retorna a posicao, se nao retorna
    // -1
    public int buscarPosicao(Prato prato) {
        int posicao = -1;
        // Loop utilizado para percorrer o vetor de Pratos para encontrarmos um prato
        // equivalente ao prato solicitado na consulta
        for (int i = 0; i < this.index; i++) {
            // Caso o prato seja encontrado, atualizado o valor da posicao e retornamos a
            // mesma
            if (this.vetPrato[i] == prato) {
                posicao = i;
                return posicao;
            }
        }
        return posicao;
    }

    // Metodo que ira receber o nome de um Ingrediente e retorna um vetor de Pratos
    // em que este Ingrediente pertence;
    public Prato[] buscarPratoIngrediente(String nomeIngrediente) {
        int contador = 0, indice = 0;
        // Loop utilizado para percorrer o vetor de Pratos para encontrarmos o
        // ingrediente com o nome solicitado
        for (int i = 0; i < this.index; i++) {
            // Segundo loop utilizado para percorrer o vetor de Ingredientes para encontrar
            // o ingrediente com o nome solicitado
            for (int j = 0; j < this.vetPrato[i].getIndex(); j++) {
                // Caso o ingrediente seja encontrado, atualizado o valor de um contador para
                // criacao de um novo vetor do tamanho equivalente a quantidade de pratos que
                // esse ingrediente pertence
                if (this.vetPrato[i].getVetIngrediente(j).getNome().equalsIgnoreCase(nomeIngrediente)) {
                    contador++;
                }
            }
        }
        // Criacao de um novo vetor do tamanho da quantidade de pratos em que o
        // ingrediente solicitado pertence
        Prato[] vetPratoNovo = new Prato[contador];
        // Loop utilizado para percorrer o vetor de Pratos para encontrarmos o
        // ingrediente com o nome solicitado
        for (int i = 0; i < this.index; i++) {
            // Segundo loop utilizado para percorrer o vetor de Ingredientes para encontrar
            // o ingrediente com o nome solicitado
            for (int j = 0; j < this.vetPrato[i].getIndex(); j++) {
                // Caso o ingrediente seja encontrado, inserimos o Prato no novo vetor de Prato
                // e atualizamos a quantidade inserida nesse vetor
                if (this.vetPrato[i].getVetIngrediente(j).getNome().equals(nomeIngrediente)) {
                    vetPratoNovo[indice] = vetPrato[i];
                    indice++;
                }
            }
        }
        return vetPratoNovo;
    }

    // Metodo que ira retornar a soma do valor de todos os Pratos encaminhados
    public double buscarValorCardapio(Prato[] vetPrato) {
        double soma = 0;
        // Loop utilizado para percorrer o vetor de Pratos para encontrarmos o valor de
        // cada prato encontrado nesse vetor e somar
        for (int i = 0; i < this.index; i++) {
            soma += vetPrato[i].getValor();
        }
        return soma;
    }

    // Recebe o vetor de pratos, procura qual tem o menor valor e retorna ele.
    public Prato buscarPratoEconomico() {
        double menor = Double.MAX_VALUE;
        int posicao = 0;
        // Loop utilizado para percorrer o vetor de Pratos para encontrarmos o valor de
        // cada prato encontrado nesse vetor
        for (int i = 0; i < this.index; i++) {
            // Caso o prato com valor mais economico seja encontrado, atualizamos o menor
            // valor e armazenamos a posicao para retorno do prato
            if (this.vetPrato[i].getValor() < menor) {
                menor = vetPrato[i].getValor();
                posicao = i;
            }
        }
        return this.vetPrato[posicao];
    }

    // Metodo para armazenar um valor e comentario de avaliacao do cardapio
    public void avaliarCardapio(Scanner input) {
        if (indiceAvaliacao >= notas.length) {
            System.out.println("Limite de avaliações atingido.");
            return;
        }

        int nota;

        do {
            System.out.println("Informe uma nota de 1 a 10:");
            nota = input.nextInt();
        } while (nota < 0 || nota > 10);

        input.nextLine();

        System.out.println("Agradecemos o registro, por favor, deixe um comentário:");
        String comentario = input.nextLine();

        // Armazenando nota e comentario no vetor correspondente
        notas[indiceAvaliacao] = nota;
        comentarios[indiceAvaliacao] = comentario;
        indiceAvaliacao++;

        System.out.println("\nAvaliação registrada, agradecemos!");
    }

    // Metodo utilizado para consultar as avaliacoes e comentarios efetuados do
    // cardapio
    public void consultarAvaliacoes() {
        if (indiceAvaliacao == 0) {
            System.out.println("Nenhuma avaliação cadastrada.");
            return;
        }

        for (int i = 0; i < indiceAvaliacao; i++) {
            System.out.println("Avaliação " + (i + 1));
            System.out.println("Nota: " + notas[i]);
            System.out.println("Comentário: " + comentarios[i]);
            System.out.println();
        }
    }

    // Recebe mostra o ToString do vetor de pratos.
    public void mostrarPratos() {
        // Loop utilizado para demonstrar os Pratos que a classe Cardapio possui
        for (int i = 0; i < this.index; i++) {
            System.out.println("***************");
            System.out.println(this.vetPrato[i]);
        }
    }
    
    public void mostrarPratosParametro(Prato[] prato) {
        for (int i = 0; i < this.index; i++) {
            System.out.println("***************");
            System.out.println(prato[i]);
        }
    }
}