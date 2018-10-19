package br.com.fiap.nac01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtUsuario;
    private EditText edtSenha;
    private CheckBox chkConectado;
    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuario = findViewById(R.id.edtUsuario);
        edtSenha = findViewById(R.id.edtSenha);
        chkConectado = findViewById(R.id.chkConectado);
        sp = getSharedPreferences("preferencias", MODE_PRIVATE);

        boolean conectado = sp.getBoolean("conectado", false);

        if (conectado) {
            chkConectado.setChecked(true);
            String usuario = sp.getString("usuario", "");
            String senha = sp.getString("senha", "");
            edtUsuario.setText(usuario);
            edtSenha.setText(senha);
        }

    }

    public void logar(View view) {

        String senha = edtSenha.getText().toString();
        String usuario = edtUsuario.getText().toString();

        if (usuario.equalsIgnoreCase("FIAP") && senha.equals("123456")) {
            SharedPreferences.Editor editor = sp.edit();
            if (chkConectado.isChecked()) {
                editor.putBoolean("conectado", true);
                editor.putString("usuario", usuario);
                editor.putString("senha", senha);
                editor.commit();
            } else {
                editor.remove("conectado");
                editor.remove("usuario");
                editor.remove("senha");
                editor.commit();
            }
            abrirTelaPreferencias();
        } else {
            Toast.makeText(this, R.string.login_invalido, Toast.LENGTH_SHORT).show();
        }

    }

    private void abrirTelaPreferencias() {
        Intent it = new Intent(this, PreferenciasActivity.class);
        startActivity(it);
    }

}