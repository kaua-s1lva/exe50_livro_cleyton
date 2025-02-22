public class RestaurarContatoCommand implements ContatoCommand {
    @Override
    public void executar(Contato contato) {
        ContatoMemento memento = new ContatoMemento(contato.getNome(), contato.getNumero());
        Zelador.getInstancia().restaurar(memento);
    }
}
