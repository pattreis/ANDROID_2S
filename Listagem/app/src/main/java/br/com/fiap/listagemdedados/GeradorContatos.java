package br.com.fiap.listagemdedados;

    import java.util.ArrayList;
    import java.util.List;

public class GeradorContatos {

    public static List<Contato> gerarContatos() {
        List<Contato> contatos = new ArrayList<>();

        Contato contato1 = new Contato(
                "Joao",
                "(11) 1111-1111",
                "Casado com Camila",
                R.drawable.p2
        );
        contatos.add(contato1);

        Contato contato2 = new Contato(
                "Camilinha",
                "(11) 9955-1111",
                "In Love",
                R.drawable.p1
        );


        contatos.add(contato2);

        Contato contato3 = new Contato(
                "Leonardo",
                "(11) 7878-6666",
                "Solteiro",
                R.drawable.p3
        );

        contatos.add(contato3);

        return contatos;
    }

}
