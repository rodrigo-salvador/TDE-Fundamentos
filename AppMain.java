/**
 * Crie uma classe Application que deverá ter o método main com as seguintes funcionalidades que deverão acionar o(s) métodos adequados para a realização da operação escolhida.
 * 1 – Adicionar prato no cardápio
 * 2 – Remover prato do cardápio
 * 3 – Consultar cardápio
 * 4 – Adicionar ingrediente no prato
 * 5 – Remover ingrediente do prato
 * 6 – Prato mais econômico
 * 7 – Pratos que contém um determinado ingrediente
 * 8 – VOCÊ DEFINE E IMPLEMENTA ESTA FUNCIONALIDADE
 * 10 – Sair do programa
 * Considerações gerais:
 * 1) Seu programa deve executar enquanto a opção de saída (opção 10) não for informada.
 * 2) As opções 1 e 2 (Adicionar/Remover prato do cardápio) deve mostrar mensagem informando se a inserção/remoção foi feita com sucesso ou se a inserção/remoção não pode ser efetuada.
 * 3) As opções 4 e 5 (Adicionar/Remover ingrediente do prato) deve mostrar mensagem informando se a inserção/remoção foi feita com sucesso ou se a inserção/remoção não pode ser efetuada.
 * 4) A opção 1 (Adicionar prato no cardápio) deve permitir que o usuário informe quantos ingredientes ele quiser para o prato, respeitando o limite máximo de ingredientes que o prato possui. 
 * Por exemplo: o prato possui 10 ingredientes, mas na inclusão do prato podem ser informados apenas 3, ficando as demais posições do vetor sem serem preenchidas.
 * 5) As opções 6 e 7 mostram as consultas, conforme a funcionalidade, caso o critério de busca não exista (para a opção 7), mostrar mensagem adequada.
 * 6) A opção 8 deve chamar e executar corretamente a funcionalidade que o grupo implementou. 
 * Tenham em mente que a professora não irá abrir o código para entender, portanto, a usabilidade deve ser levada em consideração. 
 * Para esta implementação, não utilizem as funcionalidades já implementadas nos itens de 1 a 7 do menu. 
 * Aproveitem para criar soluções criativas para este cenário!
 */
import java.util.Scanner;
public class AppMain
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int opcao;

        do
        {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Adicionar prato no cardápio");
            System.out.println("2 - Remover prato do cardápio");
            System.out.println("3 - Consultar cardápio");
            System.out.println("4 - Adicionar ingrediente no prato");
            System.out.println("5 - Remover ingrediente do prato");
            System.out.println("6 - Prato mais econômico");
            System.out.println("7 - Pratos que contém um determinado ingrediente");
            System.out.println("8 - Funcionalidade extra");
            System.out.println("10 - Sair do programa");
            System.out.print("Escolha uma opção: ");

            opcao = input.nextInt();

            switch(opcao)
            {
                case 1:
                    // Verificar se nessa opcao o usuario determina ou criamos anteriormente
                    System.out.println("Quantos pratos serão adicionados ao cardápio?");
                    int tamanhoCardapio = input.nextInt();
                    System.out.println("Por favor, informe o nome do Prato:");
                    String nome = input.nextLine();
                    System.out.println("Por favor, informe o valor do Prato:");
                    double valor = input.nextDouble();
                    System.out.println("Por favor, informe a quantidade de ingredientes do Prato:");
                    int tamanho = input.nextInt();
                    Cardapio cardapio = new Cardapio(tamanhoCardapio);
                    Prato prato = new Prato(nome, valor, tamanho);
                    Prato[] vetPrato = new Prato[tamanho]; 
                    cardapio.adicionarPrato(vetPrato, prato);
                    break;

                case 2:
                    System.out.println("Remover prato");
                    // chamar método correspondente
                    break;

                case 3:
                    System.out.println("Consultar cardápio");
                    // chamar método correspondente
                    break;

                case 4:
                    System.out.println("Adicionar ingrediente");
                    // chamar método correspondente
                    break;

                case 5:
                    System.out.println("Remover ingrediente");
                    // chamar método correspondente
                    break;

                case 6:
                    System.out.println("Prato mais econômico");
                    // chamar método correspondente
                    break;

                case 7:
                    System.out.println("Pratos com determinado ingrediente");
                    // chamar método correspondente
                    break;

                case 8:
                    System.out.println("Funcionalidade extra");
                    // chamar método correspondente
                    break;

                case 10:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 10);
        input.close();
    }
}