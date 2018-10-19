package br.com.fiap.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://douglascabral.com.br/aula-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MeusEndpoints api = retrofit.create(MeusEndpoints.class);

        api.getContatos().enqueue(new Callback<List<Contato>>() {
            @Override
            public void onResponse(Call<List<Contato>> call, Response<List<Contato>> response) {
                List<Contato> contatos = response.body();

                for (Contato contato: contatos) {
                    Log.d("MeuDebug", contato.getNome());
                }

            }

            @Override
            public void onFailure(Call<List<Contato>> call, Throwable t) {
                Toast.makeText(MainActivity.this, R.string.erro_conectar_api, Toast.LENGTH_SHORT).show();
            }
        });

    }

}
