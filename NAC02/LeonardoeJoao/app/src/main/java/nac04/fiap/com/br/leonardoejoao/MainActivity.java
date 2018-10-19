package nac04.fiap.com.br.leonardoejoao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lstClientes;
    List<Cliente> clientes;
    Banco db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new Banco(this);

        lstClientes = findViewById(R.id.lstClientes);

        clientes =  db.getAll();

        ClienteAdapter adapter = new ClienteAdapter(this, clientes);

        lstClientes.setAdapter(adapter);



    }




}


