public class ExcluirContatoCommand implements ContatoCommand {
    @Override
    public void executar(Contato contato) {
        ContatoMemento memento = new ContatoMemento(contato.getNome(), contato.getNumero());
        Zelador.getInstancia().excluir(memento);
    }
}
