package br.com.fiap.nac03.myapplication;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PreferenciasActivity extends AppCompatActivity {

    RadioGroup rdgCor;
    RadioButton rdbVermelho;
    RadioButton rdbAzul;
    RadioButton rdbVerde;

    SharedPreferences sp;

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);

        view = findViewById(R.id.view);
        rdgCor = findViewById(R.id.rdgCor);
        rdbVermelho = findViewById(R.id.rdbVermelho);
        rdbAzul = findViewById(R.id.rdbAzul);
        rdbVerde = findViewById(R.id.rdbVerde);

        rdbAzul.setChecked(true);
        view.setBackgroundColor(Color.BLUE);

    }



    public void salvar(View view) {



    }
}
