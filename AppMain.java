
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
            System.out.println("8 - Funcionalidade extra");
            System.out.println("10 - Sair do programa");
            System.out.print("Escolha uma opção: ");

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
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
                            System.out.println("Por favor, informe o nome do ingrediente nº" + (i + 1) + ":");
                            String nomeIngrediente = input.nextLine();

                            System.out.println("Por favor, informe a medida do ingrediente nº" + (i + 1) + ":");
                            String medidaIngrediente = input.nextLine();

                            System.out.println("Por favor, informe a quantidade do ingrediente nº" + (i + 1) + ":");
                            double quantidadeIngrediente = input.nextDouble();

                            input.nextLine();

                            Ingrediente ingrediente = new Ingrediente(nomeIngrediente, medidaIngrediente,
                                    quantidadeIngrediente);
                            prato.adicionarIngrediente(ingrediente);

                            if (prato.adicionarIngrediente(ingrediente)) {
                                System.out.println("Ingrediente adicionado com sucesso.");
                            } else {
                                System.out.println("Não foi possível adicionar este ingrediente.");
                            }
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
                    String escolha2;
                    System.out.println("Você acessou a opção de remover um prato do cardápio");
                    do {
                        System.out.println("Informe o nome do prato que deseja remover:");
                        String nomePratoRemover = input.nextLine();

                        if (cardapio.removerPrato(nomePratoRemover)) {
                            System.out.println("Prato removido com sucesso.");
                        } else {
                            System.out.println("Prato não encontrado no cardápio.");
                        }

                        System.out.println("Você gostaria de remover um novo prato ou voltar para o menu?");
                        System.out.println("S - Remover um novo prato ao cardápio");
                        System.out.println("N - Retornar ao menu");

                        escolha2 = input.nextLine();
                    } while (escolha2.equalsIgnoreCase("S"));
                    break;

                case 3:
                    System.out.println("Você acessou a opção de consulta do cardápio");
                    cardapio.mostrarPratos();
                    break;

                case 4:
                    System.out.println("Você acessou a opção de adicionar ingredientes a um prato");
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
                    break;

                case 5:
                    System.out.println("Você acessou a opção de remover ingredientes a um prato");
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
                    break;

                case 6:
                    System.out.println("Você acessou a opção de verificar qual é o prato mais econômico do cardápio.");
                    System.out.print("O prato mais econômico é:");
                    cardapio.buscarPratoEconomico();
                    break;

                case 7:
                    System.out.println(
                        "Você acessou a opção de verificar quais pratos possuem determinados ingredientes.");
                    System.out.println("Qual ingrediente você procura?");
                    String nomeIngredienteProcura = input.nextLine();
                    System.out.println("Os pratos que possuem o ingrediente que você informou são:");
                    cardapio.buscarPratoIngrediente(nomeIngredienteProcura);
                    break;

                case 8:
                    System.out.println("Você acessou a opção de avaliação do cardápio.");
                    cardapio.avaliarCardapio(input);
                    break;

                case 10:
                    System.out.println("Finalizando o programa.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 10);
        input.close();
    }
}