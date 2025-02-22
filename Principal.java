public class Principal {
    public static void main(String[] args) {
        Contato contato = new Contato("Carlos", "28999779469");
        new SalvarContatoCommand().executar(contato);
        Contato contato2 = new Contato("Tetzer", "999885674");
        new SalvarContatoCommand().executar(contato2);

        new ExcluirContatoCommand().executar(contato);
        Contato contato3 = new Contato("Gabriel", "28999886262");
        new SalvarContatoCommand().executar(contato3);
        new ExcluirContatoCommand().executar(contato3);

        new RestaurarContatoCommand().executar(contato3);
        new RestaurarContatoCommand().executar(contato);

        System.out.println(Zelador.getInstancia().toString());
        
    }
}
