
/**
 * Escreva uma descrição da classe ControleIngrediente aqui.
 * 
 * @author (Vasco)
 * @version (0.1.0)
 */
public class ControleIngrediente {
    private int index;
    private Ingrediente vetIngrediente[];

    public ControleIngrediente(int tam) {
        this.index = 0;
        this.vetIngrediente = new Ingrediente[tam];
    }

    public boolean insereIngrediente(Ingrediente ing) {
        if (this.index < this.vetIngrediente.length) {
            this.vetIngrediente[this.index] = ing;
            this.index++;
            return true;
        }
        return false;
    }

    public int encontraPos(String nome) {
        int pos = -1;
        for (int i = 0; i < this.index; i++) {
            if (this.vetIngrediente[i].getNome().equals(nome)) {
                pos = i;
                return pos;
            }
        }
        return pos;
    }

    public boolean excluirIngrediente(String nome) {
        int pos = encontraPos(nome);
        if (pos == -1) {
            return false;
        }
        for (int i = pos; i < this.index - 1; i++) {
            this.vetIngrediente[i] = this.vetIngrediente[i + 1];
        }
        this.vetIngrediente[this.index - 1] = null;
        this.index--;
        return true;
    }

    public void mostraIngrediente() {
        for (int i = 0; i < this.index; i++) {
            System.out.println(this.vetIngrediente[i]);
        }
    }
}