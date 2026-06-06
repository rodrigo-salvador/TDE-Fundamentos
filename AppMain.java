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
public class AppMain
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int x;

    /**
     * Construtor para objetos da classe AppMain
     */
    public AppMain()
    {
        // inicializa variáveis de instância
        x = 0;
    }

    /**
     * Um exemplo de um método - substitua este comentário pelo seu próprio
     * 
     * @param  y   um exemplo de um parâmetro de método
     * @return     a soma de x e y 
     */
    public int sampleMethod(int y)
    {
        // escreva seu código aqui
        return x + y;
    }
}