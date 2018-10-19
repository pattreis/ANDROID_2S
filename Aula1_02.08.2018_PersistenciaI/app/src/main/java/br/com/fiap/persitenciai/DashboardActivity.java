package br.com.fiap.persitenciai;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class DashboardActivity extends AppCompatActivity {

    SharedPreferences sp;
    EditText edtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        edtInfo = findViewById(R.id.edtInfo);
        sp = getSharedPreferences("login", MODE_PRIVATE);

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
            FileOutputStream fos = openFileOutput("bd.txt", MODE_PRIVATE);
            String txt = edtInfo.getText().toString();
            fos.write(txt.getBytes());
            fos.close();
            Toast.makeText(this, "Arquivo salvo com sucesso!", Toast.LENGTH_LONG).show();
        } catch (java.io.IOException e) {
            Toast.makeText(this, R.string.nao_possivel_salvar_arquivo, Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }

    public void lerArquivo(View view) {
        try {
            FileInputStream fis = openFileInput("bd.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String txt = br.readLine();

            Toast.makeText(this, txt, Toast.LENGTH_LONG).show();
        } catch (java.io.IOException e) {
            Toast.makeText(this, R.string.nao_possivel_ler_arquivo, Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

}
