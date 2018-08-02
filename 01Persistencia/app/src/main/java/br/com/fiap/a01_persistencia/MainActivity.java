package br.com.fiap.a01_persistencia;

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

        // Serve para poder conectar de modo privado no banco, mas não permite interação com outras actvitys.
        //sp = getPreferences(MODE_PRIVATE);

        // Serve para poder conectar de modo privado no banco, porém permite interação com demais actvitys.
        sp = getSharedPreferences("login", MODE_PRIVATE);

        boolean conectado = sp.getBoolean("conectado", false);

        if ( conectado ){
            abrirDashboard();
        }
    }

    public void login(View view) {

        String usuario = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();


        if (usuario.equals("fiap") && senha.equals("fiap")){


            if (chkManterConectado.isChecked()){
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("usuario",usuario);
                editor.putString("senha", senha);
                editor.putBoolean("conectado",true);
                editor.commit();
            }

            abrirDashboard();

        }else {

            Toast.makeText(this, R.string.login_invalido, Toast.LENGTH_SHORT).show();
        }
    }


    private void abrirDashboard(){
        Intent it = new Intent(this, DashboardActivity.class);
        startActivity(it);
    }
}
