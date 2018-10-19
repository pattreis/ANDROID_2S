package br.com.fiap.listagemdedados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lstContatos;
    List<Contato> contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstContatos = findViewById(R.id.lstContatos);
        contatos = GeradorContatos.gerarContatos();
        ContatoAdapter adapter = new ContatoAdapter(contatos, this);

        lstContatos.setAdapter(adapter);
        lstContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contato contato = contatos.get(i);
                Toast.makeText(
                        MainActivity.this,
                        contato.getSobre(),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

    }


}
