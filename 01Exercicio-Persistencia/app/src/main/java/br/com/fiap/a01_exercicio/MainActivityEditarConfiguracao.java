package br.com.fiap.a01_exercicio;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivityEditarConfiguracao extends AppCompatActivity {

    CheckBox chkSplash;
    SeekBar skbTempo;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_editar_configuracao);

        chkSplash = findViewById(R.id.chkSplash);
        skbTempo = findViewById(R.id.skbTempo);

        sp = getSharedPreferences("config", MODE_PRIVATE);

        boolean chekacdo = sp.getBoolean("checkado", true);
        chkSplash.setChecked(chekacdo);

        int tempo = sp.getInt("tempo", 1000);
        skbTempo.setProgress(tempo);
    }

    public void salvarAlteracoes(View view) {

        SharedPreferences.Editor editor = sp.edit();

        boolean checkado = chkSplash.isChecked();
        int tempo = skbTempo.getProgress();

        editor.putBoolean("checkado", checkado);
        editor.putInt("tempo", tempo);
        editor.commit();

        Toast.makeText(this, R.string.salvo, Toast.LENGTH_SHORT).show();
        finish();
    }
}
