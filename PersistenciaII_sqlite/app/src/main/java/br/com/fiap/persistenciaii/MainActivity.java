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

    public void salvar(View view) {
        String nome = edtNome.getText().toString();
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        db.insertCliente(cliente);
        Toast.makeText(this, "Cliente salvo com sucesso!", Toast.LENGTH_SHORT).show();
        edtNome.setText("");
    }

    public void listar(View view) {
        List<Cliente> clientes = db.getAllClientes();
        for (Cliente cliente: clientes) {
            Log.d("DebugJoao", cliente.getNome());
        }
    }

}