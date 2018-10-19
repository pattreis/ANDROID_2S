package br.com.fiap.exercicio1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class ConfiguracoesActivity extends AppCompatActivity {

    SharedPreferences sp;
    Spinner spnCor;
    String[] cores = {
            "Vermelho",
            "Amarelo",
            "Verde"
    };
    CheckBox chkSplah;
    SeekBar sekTempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);

        chkSplah = findViewById(R.id.chkSplash);
        spnCor = findViewById(R.id.spnCor);
        sekTempo = findViewById(R.id.sekTempo);

        sp = getSharedPreferences("configuracoes", MODE_PRIVATE);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                cores
        );
        spnCor.setAdapter(adapter);

        boolean checado = sp.getBoolean("conectado", true);
        chkSplah.setChecked(checado);

        int tempo = sp.getInt("tempoSplashScreen", 10);
        sekTempo.setProgress(tempo);


    }

    public void salvarConfiguracoes(View view) {

        SharedPreferences.Editor editor = sp.edit();

        // verificando se o usuario escolheu para nao exibir a splash screeb

        editor.putBoolean("conectado", chkSplah.isChecked());


        // pegando a cor escolhida pelo usuario
        String corEscolhida = spnCor.getSelectedItem().toString();
        editor.putString("corFundo", corEscolhida);

        // pegando o tempo escolhido pelo usuario
        int tempo = sekTempo.getProgress();
        editor.putInt("tempoSplashScreen", tempo);

        // comitando as mudancas
        editor.commit();

        // exibindo mensagem de sucesso
        Toast.makeText(this, "Preferências salvas com sucesso!", Toast.LENGTH_LONG).show();
        finish();
    }

}
