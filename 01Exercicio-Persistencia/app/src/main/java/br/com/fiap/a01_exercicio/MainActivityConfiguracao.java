package br.com.fiap.a01_exercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivityConfiguracao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_configuracao);
    }

    public void exibirConfiguracoes(View view) {
        Intent it = new Intent(MainActivityConfiguracao.this, MainActivityEditarConfiguracao.class);
        startActivity(it);


    }
}
