package br.com.fiap.revisao2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DashboardActivity extends AppCompatActivity {

    private EditText edtTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        edtTexto = findViewById(R.id.edtTexto);

    }

    public void logout(View view) {

        SharedPreferences sp = getSharedPreferences("preferenciasUsuario", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove("conectado");
        editor.remove("emailUsuario");
        editor.remove("senha");
        editor.commit();
        finish();
    }

    public void gravarArquivo(View view) {
        String texto = edtTexto.getText().toString();
        try {
            FileOutputStream fos = openFileOutput("meuBD.txt", MODE_PRIVATE);
            fos.write(texto.getBytes());
            fos.close();
            Toast.makeText(this, "Arquivo salvo com sucesso!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Erro ao gravar o arquivo.", Toast.LENGTH_SHORT).show();
        }

    }

    public void lerArquivo(View view) {
        FileInputStream fis = null;
        BufferedReader br = null;
        try {
            fis = openFileInput("meuBD.txt");
            br = new BufferedReader(new InputStreamReader(fis));

            String txt = br.readLine();
            Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Erro ao ler o arquivo.", Toast.LENGTH_SHORT).show();
        } finally {
            try {
                br.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
