package br.com.fiap.revisao01;

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

    private String[] cores = {
            "Vermelho", "Amarelo", "Verde"
    };
    private Spinner spnCores;
    private SeekBar sekTempo;
    private CheckBox chkSplash;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);

        spnCores = findViewById(R.id.spnCores);
        sekTempo = findViewById(R.id.sekTempo);
        chkSplash = findViewById(R.id.chkSplash);
        sp = getSharedPreferences("configuracoes_buddies", MODE_PRIVATE);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cores);
        spnCores.setAdapter(adapter);

        boolean exibirSplash = sp.getBoolean("exibir_splash", true);
        int tempo = sp.getInt("tempoExibicao", 1);
        String cor = sp.getString("corFundo", "Vermelho");

        chkSplash.setChecked(exibirSplash);
        sekTempo.setProgress(tempo);

        int numeroCor = 0;
        switch (cor) {
            case "Vermelho" :
                numeroCor = 0;
                break;
            case "Amarelo" :
                numeroCor = 1;
                break;
            case "Verde" :
                numeroCor = 2;
                break;
            default:
                numeroCor = 0;
                break;
        }

        spnCores.setSelection(numeroCor);

    }

    public void salvarConfiguracoes(View view) {

        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("exibir_splash", chkSplash.isChecked());

        int tempo = sekTempo.getProgress();
        editor.putInt("tempoExibicao", tempo);

        String cor = spnCores.getSelectedItem().toString();
        editor.putString("corFundo", cor);

        editor.commit();

        Toast.makeText(this, "Preferências salvas com sucesso!", Toast.LENGTH_SHORT).show();
        finish();
    }


}
