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

    public ContatoMemento desfazer() {
        int ultimo = pilhaSalvar.size() - 1;
        ContatoMemento memento = pilhaSalvar.remove(ultimo);
        pilhaExcluir.add(memento);

        ultimo--;

        if (ultimo <= -1) {
            throw new RuntimeException("Não possui mais elementos para desfazer");
        }
        return pilhaSalvar.get(ultimo);
    }

    public ContatoMemento refazer() {
        int ultimo = pilhaSalvar.size() - 1;
        ContatoMemento memento = pilhaExcluir.remove(ultimo);
        pilhaSalvar.add(memento);
        return memento;
    }

    public List<ContatoMemento> getPilhaSalvar() {
        return pilhaSalvar;
    }

    public List<ContatoMemento> getPilhaExcluir() {
        return pilhaExcluir;
    }
}
