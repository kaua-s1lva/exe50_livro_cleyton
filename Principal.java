public class Principal {
    public static void main(String[] args) {
        Contato contato = new Contato("Carlos", "28999779469");
        new SalvarContatoCommand().executar(contato);
        Contato contato2 = new Contato("Tetzer", "999885674");
        new SalvarContatoCommand().executar(contato2);

        new ExcluirContatoCommand().executar(contato);
        /*
        Zelador.getInstancia().add(contato.criar());
        contato.setNome("Geraldo");
        System.out.println(contato.getNome());
        //contato.restaurar(Zelador.getInstancia().getUltimo());
        System.out.println(contato.getNome());
         */
        
    }
}
