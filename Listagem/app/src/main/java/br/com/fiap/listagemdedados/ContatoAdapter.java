package br.com.fiap.listagemdedados;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContatoAdapter extends BaseAdapter {

    Context context;
    List<Contato> contatos;

    public ContatoAdapter(List<Contato> contatos, Context context) {
        this.contatos = contatos;
        this.context = context;
    }

    // aqui eu digo quantos itens vou querer reenderizar
    @Override
    public int getCount() {
        return contatos.size();
    }

    // retorna o contato especifico para ser renderizado
    @Override
    public Object getItem(int i) {
        return this.contatos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // vamos inflar (pegar um xml e jogar dentro de um objeto java). Camila idiota.
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        Contato contato = this.contatos.get(i);

        View v = layoutInflater.inflate(R.layout.listview_contato, null);

        ImageView imgContato = v.findViewById(R.id.imgContato);
        TextView txtNome = v.findViewById(R.id.txtNome);
        TextView txtTelefone = v.findViewById(R.id.txtTelefone);

        imgContato.setImageResource(contato.getImagem());
        txtNome.setText(contato.getNome());
        txtTelefone.setText(contato.getTelefone());

        return v;
    }

}
