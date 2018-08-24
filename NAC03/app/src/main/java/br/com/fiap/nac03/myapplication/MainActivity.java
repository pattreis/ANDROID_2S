package br.com.fiap.nac03.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUsuario;
    EditText edtSenha;
    CheckBox chkManterConectado;

    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuario = findViewById(R.id.edtUsuario);
        edtSenha = findViewById(R.id.edtSenha);
        chkManterConectado = findViewById(R.id.chkManterConectado);

        sp = getSharedPreferences("login", MODE_PRIVATE);

        boolean logado = sp.getBoolean("logado", false);


        if (logado){
            String user = sp.getString("usuario", "");
            String pass = sp.getString("senha", "");
            chkManterConectado.setChecked(true);
            edtUsuario.setText(user);
            edtSenha.setText(pass);

            abrirPreferencias();
        }

    }

    public void login(View view) {

        String usuario = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();

        if (usuario.equalsIgnoreCase("fiap") && senha.equals("123456")){
            if (chkManterConectado.isChecked()){
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("usuario" ,usuario);
                editor.putString("senha", senha);
                editor.putBoolean("logado", true);
                editor.commit();
            }
            abrirPreferencias();
        }else {
            Toast.makeText(this, R.string.n_possivel_logar, Toast.LENGTH_SHORT ).show();
        }
    }

    private void abrirPreferencias() {
        Intent it = new Intent(this, PreferenciasActivity.class);
        startActivity(it);
    }
}
