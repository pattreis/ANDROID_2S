package br.com.fiap.nac01;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PreferenciasActivity extends AppCompatActivity {

    private RadioGroup rdgCores;
    private LinearLayout layout;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);

        sp = getSharedPreferences("preferencias", MODE_PRIVATE);
        rdgCores = findViewById(R.id.rdgCores);
        layout = findViewById(R.id.lytPreferencias);

        String corPreferencia = sp.getString("corPreferencia", "");

        if (!corPreferencia.equals("")) {
            alterarCorDeFundo(corPreferencia, layout);
        }

    }

    private void alterarCorDeFundo(String corPreferencia, LinearLayout layout) {
        switch (corPreferencia) {
            case "vermelho" :
                layout.setBackgroundColor(Color.RED);
                break;
            case "azul" :
                layout.setBackgroundColor(Color.BLUE);
                break;
            case "verde" :
                layout.setBackgroundColor(Color.GREEN);
                break;
             default:
                break;
        }

    }


    public void salvarPreferencias(View view) {

        int numeroCor = rdgCores.getCheckedRadioButtonId();
        String cor = null;

        switch (numeroCor) {
            case 1 :
                cor = "vermelho";
                layout.setBackgroundColor(Color.RED);
                break;
            case 2 :
                cor = "azul";
                layout.setBackgroundColor(Color.BLUE);
                break;
            case 3 :
                cor = "verde";
                layout.setBackgroundColor(Color.GREEN);
                break;
            default:
                Toast.makeText(this, R.string.escolha_cor, Toast.LENGTH_SHORT).show();
                return;
        }

        SharedPreferences.Editor editor = sp.edit();
        editor.putString("corPreferencia", cor);
        editor.commit();
        Toast.makeText(this, R.string.preferencias_salvas, Toast.LENGTH_SHORT).show();
    }

    public void mudarCor(View view) {
        int numeroCor = rdgCores.getCheckedRadioButtonId();

        switch (numeroCor) {
            case 1 :
                layout.setBackgroundColor(Color.RED);
                break;
            case 2 :
                layout.setBackgroundColor(Color.BLUE);
                break;
            case 3 :
                layout.setBackgroundColor(Color.GREEN);
                break;
        }
    }

}
