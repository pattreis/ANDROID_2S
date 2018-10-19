package br.com.fiap.revisao2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtSenha;
    private CheckBox chkConectado;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("preferenciasUsuario", MODE_PRIVATE);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        chkConectado = findViewById(R.id.chkConectado);

        boolean conectado = sp.getBoolean("conectado", false);

        if (conectado) {
            abrirDashboard();
        }

    }

    private void abrirDashboard() {
        Intent it = new Intent(this, DashboardActivity.class);
        startActivity(it);
    }

    public void logar(View view) {

        String email = edtEmail.getText().toString();
        String senha = edtSenha.getText().toString();

        if (email.equalsIgnoreCase("joao@hotmal.com") && senha.equals("1234")) {

            if (chkConectado.isChecked()) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("conectado", true);
                editor.putString("emailUsuario", email);
                editor.putString("senha", senha);
                editor.commit();
            }
            abrirDashboard();
        } else {
            Toast.makeText(this, "E-mail e/ou senha incorretos.", Toast.LENGTH_SHORT).show();
        }

    }

}