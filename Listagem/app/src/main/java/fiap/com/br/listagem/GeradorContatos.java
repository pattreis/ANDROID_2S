package fiap.com.br.listagem;

import java.util.ArrayList;
import java.util.List;

public class GeradorContatos {
    public static List<Contato> gerarContatos(){
        List<Contato> contatos = new ArrayList<>();
        Contato contato = new Contato(
                "João",
                "(11) 1111-1111",
                "Desempregado",
                R.drawable.p1
        );

        contatos.add(contato);

        Contato contato1 = new Contato(
                "Romano",
                "(11) 2222-1111",
                "Férias",
                R.drawable.p2
        );

        contatos.add(contato1);

        return contatos;
    }
}
