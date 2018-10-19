package br.com.fiap.exercicio1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences sp;
    FrameLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_main);
        layout = findViewById(R.id.layoutSplashScreen);

        sp = getSharedPreferences("configuracoes", MODE_PRIVATE);
        boolean conectado = sp.getBoolean("conectado", false);
        
        if (conectado) {
            this.abrirDashboard();
        }

        String corFundo = sp.getString("corFundo", "Vermelho");
        int tempo = sp.getInt("tempoSplashScreen", 10);

        if (corFundo.equals("Amarelo")) {
            layout.setBackgroundResource(R.color.amarelo);
        } else if (corFundo.equals("Vermelho")) {
            layout.setBackgroundResource(R.color.vermelho);
        } else {
            layout.setBackgroundResource(R.color.verde);
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(it);
            }
        }, tempo * 1000);

    }

    private void abrirDashboard() {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }

}
