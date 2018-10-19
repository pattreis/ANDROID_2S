package br.com.fiap.revisao01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private FrameLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("configuracoes_buddies", MODE_PRIVATE);
        layout = findViewById(R.id.lytSplashScreen);
        boolean exibirSplash = sp.getBoolean("exibir_splash", true);

        if (!exibirSplash) {
            abrirDashboard();
        }

        int tempo = sp.getInt("tempoExibicao", 1);
        String cor = sp.getString("corFundo", "vermelho");

        if (cor.equalsIgnoreCase("amarelo")) {
            layout.setBackgroundResource(R.color.amarelo);
        } else if (cor.equalsIgnoreCase("verde")) {
            layout.setBackgroundResource(R.color.verde);
        } else {
            layout.setBackgroundResource(R.color.vermelho);
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                abrirDashboard();
            }
        }, 1000 * tempo);

    }

    private void abrirDashboard() {
        Intent it = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(it);
    }

}
