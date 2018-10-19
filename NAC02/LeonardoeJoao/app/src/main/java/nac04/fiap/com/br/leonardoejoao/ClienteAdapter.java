package nac04.fiap.com.br.leonardoejoao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ClienteAdapter extends BaseAdapter {

    Context context;
    List<Cliente> clientes;

    public ClienteAdapter(Context context, List<Cliente> contatos){
        this.context = context;
        this.clientes = contatos;
    }


    @Override
    public int getCount() {
        return this.clientes.size();
    }

    @Override
    public Object getItem(int i) {
        return this.clientes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        Cliente cliente = this.clientes.get(i);

        View v = layoutInflater.inflate(R.layout.listview_cliente, null);

        ImageView imgCliente = v.findViewById(R.id.imgCliente);
        TextView txtNome = v.findViewById(R.id.txtNome);
        TextView txtTelefone = v.findViewById(R.id.txtTelefone);
        TextView txtEmail = v.findViewById(R.id.txtEmail);

        imgCliente.setImageResource(R.drawable.ic_action_name);
        txtNome.setText(cliente.getNome());
        txtTelefone.setText(cliente.getTelefone());
        txtEmail.setText(cliente.getEmail());

        return v;
    }
}
