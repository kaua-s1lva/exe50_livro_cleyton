import java.util.ArrayList;
import java.util.List;

public class Zelador {
    private static Zelador instancia;
    private List<ContatoMemento> pilhaSalvar;
    private List<ContatoMemento> pilhaExcluir;

    private Zelador() {
        pilhaSalvar = new ArrayList<>();
        pilhaExcluir = new ArrayList<>();
    }

    public static Zelador getInstancia() {
        if (instancia == null) {
            instancia = new Zelador();
        }
        return instancia;
    }

    public void salvar(ContatoMemento memento) {
        pilhaSalvar.add(memento);
    }

    public void excluir(ContatoMemento memento) {
        try {
            pilhaSalvar.remove(memento);
            pilhaExcluir.add(memento);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao encontrar contato: " + e.getMessage());
        }
    }

    public void restaurar(ContatoMemento memento) {
        try {
            pilhaExcluir.remove(memento);
            pilhaSalvar.add(memento);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao encontrar contato: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        String textoPilhaSalvar="Pilha de Salvar Contato: \n", textoPilhaExcluir="Pilha de Excluir Contato: \n";
        for (ContatoMemento mementoSalvar : pilhaSalvar) {
            textoPilhaSalvar += "[" + mementoSalvar.getNome() + ", " + mementoSalvar.getNumero() + "]\n";
        }

        for (ContatoMemento mementoExcluir : pilhaExcluir) {
            textoPilhaExcluir += "[" + mementoExcluir.getNome() + ", " + mementoExcluir.getNumero() + "]\n";
        }

        return "\n" + textoPilhaSalvar + "\n" + textoPilhaExcluir;
    }
}
