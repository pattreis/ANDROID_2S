package br.com.fiap.a01_persistencia;


import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class DashboardActivity extends AppCompatActivity {

    SharedPreferences sp;
    EditText edtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        sp = getSharedPreferences("login", MODE_PRIVATE);
        edtInfo = findViewById(R.id.edtInfo);
    }

    public void logout(View view) {

        SharedPreferences.Editor editor = sp.edit();
        editor.remove("usuario");
        editor.remove("senha");
        editor.remove("conectado");
        editor.commit();

        finish();

    }

    public void salvarArquivo(View view) {
        try {

            FileOutputStream fos = openFileOutput("bd.text", MODE_PRIVATE);
            String txt = edtInfo.getText().toString();
            fos.write(txt.getBytes());
            fos.close();

            Toast.makeText(this, R.string.arquivo_salvo_com_sucesso, Toast.LENGTH_SHORT).show();

        } catch (java.io.IOException e){
            e.printStackTrace();

            Toast.makeText(this, R.string.nao_foi_possivel_salvar, Toast.LENGTH_SHORT).show();
        }
    }

    public void lerArquivo(View view) {
        try {

            FileInputStream fis = openFileInput("bd.text");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String txt = br.readLine();

            Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
        }catch (java.io.IOException e){
            e.printStackTrace();

            Toast.makeText(this, R.string.nao_foi_possivel_ler, Toast.LENGTH_SHORT).show();
        }
    }
}
