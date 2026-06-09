package Trabalho_Final;
/**
 * Classe intermediária de pratos (cardapio), onde podemos manipular o vetor de pratos.
 * Adicionar métodos como:
 * Adicionar ingrediente
 * Remover ingrediente
 * Procurar ingrediente
 */
public class ControlePrato {
    private int index;
    private TestPrato vetPrato[];

    public ControlePrato(int tam) {
        this.index = 0;
        this.vetPrato = new TestPrato[tam];
    }

    public boolean inserePrato(TestPrato prato) {
        if (this.index < this.vetPrato.length) {
            this.vetPrato[this.index] = prato;
            this.index++;
            return true;
        }
        return false;
    }

    public int encontraPos(String nome) {
        int pos = -1;
        for (int i = 0; i < this.index; i++) {
            if (this.vetPrato[i].getNome().equals(nome)) {
                pos = i;
                return pos;
            }
        }
        return pos;
    }

    public boolean excluirPrato(String nome) {
        int pos = encontraPos(nome);
        if (pos == -1) {
            return false;
        }
        for (int i = pos; i < this.index - 1; i++) {
            this.vetPrato[i] = this.vetPrato[i + 1];
        }
        this.vetPrato[this.index - 1] = null;
        this.index--;
        return true;
    }

    public void mostraPrato() {
        for (int i = 0; i < this.index; i++) {
            System.out.println(this.vetPrato[i]);
        }
    }
}
