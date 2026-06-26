package Trabalho_Final;
import java.util.Scanner;

public class AppMain {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Cardapio cardapio = new Cardapio(10);
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Adicionar prato no cardápio");
            System.out.println("2 - Remover prato do cardápio");
            System.out.println("3 - Consultar cardápio");
            System.out.println("4 - Adicionar ingrediente no prato");
            System.out.println("5 - Remover ingrediente do prato");
            System.out.println("6 - Prato mais econômico");
            System.out.println("7 - Pratos que contém um determinado ingrediente");
            System.out.println("8 - Avaliar cardapio");
            System.out.println("9 - Consultar avaliações");
            System.out.println("10 - Sair do programa");
            System.out.print("Escolha uma opção: ");

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    input.nextLine();
                    System.out.println();
                    System.out.println("-------------------------");
                    System.out.println("Você acessou a opção de adicionar um prato do cardápio");
                    String escolha;
                    do {
                        if (cardapio.getIndex() == cardapio.getVetPrato().length) {
                            System.out.println(
                                "Infelizmente o cardápio está cheio, se quiser adicionar um prato novo ao cardápio será necessário remover algum prato existente antes.");
                            break;
                        }
                        System.out.println("Por favor, informe o nome do Prato:");
                        String nome = input.nextLine();

                        System.out.println("Por favor, informe o valor do Prato:");
                        double valor = input.nextDouble();

                        System.out.println("Por favor, informe a quantidade de ingredientes que terá o Prato:");
                        int tamanho = input.nextInt();

                        input.nextLine(); // Garantia de armazenamento do proximo string a ser inserido

                        Prato prato = new Prato(nome, valor, tamanho);

                        System.out.println("Por favor, informe a respeito dos ingredientes:");

                        for (int i = 0; i < tamanho; i++) {
                            System.out.println("Informe o nome do ingrediente nº" + (i + 1) + ":");
                            String nomeIngrediente = input.nextLine();

                            System.out.println("Informe a medida do ingrediente nº" + (i + 1) + ":");
                            String medidaIngrediente = input.nextLine();

                            System.out.println("Informe a quantidade do ingrediente nº" + (i + 1) + ":");
                            double quantidadeIngrediente = input.nextDouble();

                            input.nextLine();

                            Ingrediente ingrediente = new Ingrediente(nomeIngrediente, medidaIngrediente,
                                    quantidadeIngrediente);
                            prato.adicionarIngrediente(ingrediente);
                        }

                        if (cardapio.adicionarPrato(prato)) {
                            System.out.println("Prato adicionado com sucesso.");
                        } else {
                            System.out.println("Não foi possível adicionar o prato.");
                        }

                        System.out.println("Você gostaria de adicionar um novo prato ou voltar para o menu?");
                        System.out.println("S - Adicionar um novo prato ao cardápio");
                        System.out.println("N - Retornar ao menu");

                        escolha = input.nextLine();
                    } while (escolha.equalsIgnoreCase("S"));
                    break;

                case 2:
                    input.nextLine();
                    String escolha2;
                    System.out.println();
                    System.out.println("-------------------------");
                    System.out.println("Você acessou a opção de remover um prato do cardápio");
                    if(cardapio.getIndex() == 0)
                    {
                        System.out.println("Não há pratos no cardápio.");
                    }
                    else
                    {
                        do {
                            System.out.println();
                            System.out.println("Informe o nome do prato que deseja remover:");
                            String nomePratoRemover = input.nextLine();

                            if (cardapio.removerPrato(nomePratoRemover)) {
                                System.out.println("Prato removido com sucesso.");
                            } else {
                                System.out.println("-------------------------");
                                System.out.println("Prato não encontrado no cardápio.");
                                System.out.println("-------------------------");
                            }
                            System.out.println("Você gostaria de remover um novo prato ou voltar para o menu?");
                            System.out.println("S - Remover um novo prato ao cardápio");
                            System.out.println("N - Retornar ao menu");

                            escolha2 = input.nextLine();
                        } while (escolha2.equalsIgnoreCase("S"));
                    }
                    break;
                case 3:
                    System.out.println();
                    System.out.println("-------------------------");
                    System.out.println("Você acessou a opção de consulta do cardápio");
                    if(cardapio.getIndex() == 0)
                    {
                        System.out.println("Não há pratos no cardápio.");
                    }
                    else
                    {
                        cardapio.mostrarPratos();
                    }
                    break;

                case 4:
                    input.nextLine();
                    System.out.println();
                    System.out.println("-------------------------");
                    System.out.println("Você acessou a opção de adicionar ingredientes a um prato");
                    if (cardapio.getIndex() == 0)
                    {
                        System.out.println("Não há pratos no cardápio.");
                    }
                    else
                    {
                        System.out.println("Qual prato você gostaria de adicionar ingredientes?");
                        String nomePratoBusca = input.nextLine();
                        // Garantindo que existe o prato no cardapio
                        if (cardapio.buscarPratoPorNome(nomePratoBusca) == null) {
                            System.out
                            .println("O prato que você gostaria de adicionar ingredientes não existe no cardápio.");
                        } else {
                            // Garantindo que existe espaco para adicao de ingredientes no prato
                            if (cardapio.buscarPratoPorNome(nomePratoBusca)
                            .getIndex() == cardapio.buscarPratoPorNome(nomePratoBusca).getVetIngrediente().length) {
                                System.out.println(
                                    "Infelizmente o prato não possui mais espaço para adição de novos ingredientes.");
                            } else {
                                System.out.println(
                                    "Por favor, informe o nome do ingrediente que você gostaria de adicionar ao prato:");
                                String nomeIngrediente = input.nextLine();

                                System.out.println(
                                    "Por favor, informe a medida do ingrediente que você gostaria de adicionar ao prato:");
                                String medidaIngrediente = input.nextLine();

                                System.out.println(
                                    "Por favor, informe a quantidade do ingrediente que você gostaria de adicionar ao prato:");
                                double quantidadeIngrediente = input.nextDouble();

                                input.nextLine();

                                Ingrediente ingrediente = new Ingrediente(nomeIngrediente, medidaIngrediente,
                                        quantidadeIngrediente);
                                cardapio.buscarPratoPorNome(nomePratoBusca).adicionarIngrediente(ingrediente);

                                System.out.println("Ingrediente adicionado ao prato informado.");
                            }
                        }
                    }

                    break;

                case 5:
                    input.nextLine();
                    System.out.println();
                    System.out.println("-------------------------");
                    System.out.println("Você acessou a opção de remover ingredientes a um prato");
                    if (cardapio.getIndex() == 0)
                    {
                        System.out.println("Não há pratos no cardápio.");
                    }
                    else
                    {
                        System.out.println("Qual prato você gostaria de remover ingredientes?");
                        String nomePratoRemoverIngrediente = input.nextLine();

                        // Garantindo que existe o prato no cardapio
                        if (cardapio.buscarPratoPorNome(nomePratoRemoverIngrediente) == null) {
                            System.out.println("Este prato não existe.");
                        } else {
                            // Mediante confirmacao da existentencia do prato, perguntamos qual ingrediente
                            // sera removido
                            System.out.println("Qual ingrediente será removido?");
                            String nomeIngredienteRemover = input.nextLine();
                            // Se o ingrediente existe na relacao de ingredientes do prato, removemos
                            if (cardapio.buscarPratoPorNome(nomePratoRemoverIngrediente)
                            .removerIngrediente(nomeIngredienteRemover)) {
                                System.out.println("Ingrediente removido do Prato com sucesso");
                            } else {
                                System.out.println(
                                    "Este ingrediente não pertence a relação de ingredientes do prato selecionado.");
                            }
                        }
                    }
                    break;

                case 6:
                    input.nextLine();
                    System.out.println();
                    System.out.println("-------------------------");
                    System.out.println("Você acessou a opção de verificar qual é o prato mais econômico do cardápio.");
                    if(cardapio.getIndex() == 0)
                    {
                        System.out.println("Não há pratos no cardápio.");
                    }
                    else
                    {
                        System.out.print("O prato mais econômico é:\n" + cardapio.buscarPratoEconomico());
                    }
                    break;

                case 7:
                    input.nextLine();
                    System.out.println();
                    System.out.println("-------------------------");
                    System.out.println(
                        "Você acessou a opção de verificar quais pratos possuem determinados ingredientes.");
                    if(cardapio.getIndex() == 0)
                    {
                        System.out.println("Não há pratos no cardápio.");
                    }
                    else
                    {
                        System.out.println("Qual ingrediente você procura?");
                        String nomeIngredienteProcura = input.nextLine();
                        System.out.println("Os pratos que possuem o ingrediente que você informou são:");
                        cardapio.buscarPratoIngrediente(nomeIngredienteProcura);
                    }

                    break;

                case 8:
                    System.out.println();
                    System.out.println("-------------------------");
                    System.out.println("Você acessou a opção de avaliação do cardápio.");
                    cardapio.avaliarCardapio(input);
                    break;

                case 9:
                    input.nextLine();
                    System.out.println();
                    System.out.println("-------------------------");
                    System.out.println("Você acessou a opção de consultar as avaliações do cardápio.");
                    if (cardapio.getIndiceAvaliacao() == 0)
                    {
                        System.out.println("Nenhum avaliação foi realizada");
                    }
                    else
                    {
                        cardapio.consultarAvaliacoes();
                    }
                    break;

                case 10:
                    System.out.println("Finalizando o programa.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 10);
    }
}
