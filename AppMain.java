
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

public class AppMain {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int opcao;

        Cardapio cardapio =  new Cardapio(10)

        do {
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

            switch (opcao) {
                case 1:
                    
                    if(cardapio.getIndex() == cardapio.getVetPrato().length)
                    {
                        System.out.println("O cardápio está cheio, se quiser adicionar outro prato, tente remover algum outro antes.");
                    }
                    {
                        System.out.println("Qual será o nome do prato?");
                        String nomePratoNovo = input.nextLine();

                        System.out.println("Qual será o valor do prato?");
                        double valorPratoNovo = input.nextDouble();

                        System.out.println("Quantos ingredientes terá o prato novo?");
                        int tamPratoNovo = input.nextInt();

                        Prato pratoNovo = new Prato(nomePratoNovo, valorPratoNovo, tamPratoNovo);

                        System.out.println("Insira os dados dos ingredientes escolhidos.");

                        for(int i = 0; i<tamPratoNovo; i++)
                        {
                            System.out.println("Qual será o nome do ingrediente " + i+1 + "?");
                            String nomeIng1 = input.nextLine();

                            System.out.println("Qual será a medida do ingrediente " + i+1 + "?");
                            String medidaIng1 = input.nextLine();

                            System.out.println("Qual será o nome do ingrediente " + i+1 + "?");
                            double quantidadeIng1 = input.nextDouble();

                            Ingrediente ingredienteNovo = new Ingrediente(nomeIng1, medidaIng1, quantidadeIng1);

                            if(pratoNovo.adicionarIngrediente(ingredienteNovo))
                            {
                                System.out.println("Ingrediente adicionado com sucesso.");
                            }
                            else
                            {
                                System.out.println("Não foi possível adicionar este ingrediente.");
                            }
                        }
                    }
                    break;

                case 2:
                    System.out.println("Escolha o nome de um prato para removê-lo.");
                    String nomePratoRemover = input.nextLine();

                    if(cardapio.removerPrato(nomePratoRemover))
                    {
                        System.out.println("Prato removido com sucesso.");
                    }
                    else
                    {
                        System.out.println("Prato não localizado no cardápio.");
                    }

                    break;

                case 3:
                    System.out.println("Os pratos disponíveis no cardápio são:");
                    cardapio.mostrarPratos();
                    break;

                case 4: //Nao sei se ela vai aceitar essa validacao com IF, REVISAR DEPOIS*************************
                    System.out.println("A qual prato você gostaria de adicionar um ingrediente?");
                    String nomePratoAddIng = input.nextLine();

                    if(cardapio.buscarPratoPorNome(nomePratoAddIng) == null)
                    {
                        System.out.println("Este prato não existe.");
                    }
                    else
                    {
                        if(cardapio.buscarPratoPorNome(nomePratoAddIng).getIndex() == cardapio.buscarPratoPorNome(nomePratoAddIng).getVetIngrediente().length)
                        {
                            System.out.print("O prato já está cheio, não é possível adicionar mais ingredientes");
                        }
                        else
                        {
                            System.out.println("Qual o nome do ingrediente?");
                            String nomeIngAdd = input.nextLine();

                            System.out.println("Qual a medida desse ingrediente?");
                            String medidaIng = input.nextLine();

                            System.out.println("Qual a quantidade desse ingrediente?");
                            double quantidadeIng = input.nextDouble();

                            Ingrediente ing1 = new Ingrediente(nomeIngAdd, medidaIng, quantidadeIng);
                        }
                    }

                    break;

                case 5:
                    System.out.println("Qual prato será escolhido para a remoção do ingrediente?");
                    String nomePratoRemoverIng = input.nextLine();

                    if(cardapio.buscarPratoPorNome(nomePratoRemoverIng) == null)
                    {
                        System.out.println("Este prato não existe.");
                    }
                    else
                    {
                        System.out.println("Qual ingrediente será removido?");
                        String nomeIngRemover = input.nextLine();

                        if(cardapio.buscarPratoPorNome(nomePratoRemoverIng).removerIngrediente(nomeIngRemover))
                        {
                            System.out.println("Ingrediente Removido com sucesso");
                        }
                        else
                        {
                            System.out.println("Este ingrediente não está no prato selecionado.");
                        }
                    }
                    break;

                case 6:
                    System.out.print("O prato mais econômico é: ");
                    cardapio.buscarPratoEconomico();
                    break;

                case 7:
                    System.out.println("Qual ingrediente você procura?");
                    String nomeIngredienteProcura = input.nextLine();

                    cardapio.buscarPratoIngrediente(nomeIngredienteProcura); //DUVIDA, não sei se precisa mostrar o vetor com S.O.T ou só retornar o vetor

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
        } while (opcao != 10);
        input.close();
    }
}