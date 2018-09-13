package br.com.fiap.persistenciaii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtNome;
    MeuDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        db = new MeuDB(this);
    }

    public void Salvar(View view) {

        String nome = edtNome.getText().toString();

        Cliente cliente = new Cliente();
        cliente.setNome(nome);

        db.insertCliente(cliente);

        Toast.makeText(this, R.string.msg_salvo,Toast.LENGTH_SHORT).show();

        edtNome.setText("");
    }


    public void listar(View view) {
        List<Cliente> clientes = db.selectClientes();
        for (Cliente cliente : clientes){
            Log.d("MeuDebug", cliente.getNome());
        }
    }
}
