package fiap.com.br.splashscreen;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Toast;

public class ConfigActivity extends AppCompatActivity {

    CheckBox chkExibir;
    SeekBar skbTempo;

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        chkExibir = findViewById(R.id.chkExibir);
        skbTempo = findViewById(R.id.skbTempo);

        sp = getSharedPreferences("config", MODE_PRIVATE);

        boolean checkado = sp.getBoolean("checkado", true);
        int tempo = sp.getInt("tempo", 10000);
        chkExibir.setChecked(checkado);
        skbTempo.setProgress(tempo);

    }

    public void salvar(View view) {
        SharedPreferences.Editor editor = sp.edit();

        boolean exibir = chkExibir.isChecked();
        int tempo = skbTempo.getProgress();

        editor.putBoolean("exibir", exibir);
        editor.putInt("tempo", tempo);
        editor.commit();

        Toast.makeText(this, "Configurações salvas com sucesso", Toast.LENGTH_SHORT).show();

        finish();
    }
}
