package br.com.fiap.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MeusEndpoints {

    @GET("contatos.php")
    Call<List<Contato>> getContatos();


}
