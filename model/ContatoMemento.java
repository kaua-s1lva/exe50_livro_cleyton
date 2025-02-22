import java.util.Objects;

public class ContatoMemento {
    private String nome;
    private String numero;

    public ContatoMemento(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ContatoMemento that = (ContatoMemento) obj;
        return Objects.equals(nome, that.nome) &&
            Objects.equals(numero, that.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, numero);
    }


}
