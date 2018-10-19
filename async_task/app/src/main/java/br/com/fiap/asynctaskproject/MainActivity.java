package br.com.fiap.asynctaskproject;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView imgBaixada;
    ProgressDialog progressDialog;
    EditText edtUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBaixada = findViewById(R.id.imgBaixada);
        edtUrl = findViewById(R.id.edtUrl);

    }

    public void download(View view) {
        DownloadAsyncTask downloadAsyncTask = new DownloadAsyncTask();
        downloadAsyncTask.execute(edtUrl.getText().toString());
    }

    private class DownloadAsyncTask extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(
                    MainActivity.this,
                    "Aguarde...",
                    "O download está sendo efetuado!");
        }

        @Override
        protected Bitmap doInBackground(String... strings) {

            try {
                InputStream inputStream;
                Bitmap imagem;
                URL endereco = new URL(strings[0]);

                inputStream = endereco.openStream();
                imagem = BitmapFactory.decodeStream(inputStream);

                inputStream.close();
                return imagem;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (bitmap != null) {
                imgBaixada.setImageBitmap(bitmap);
            }
            progressDialog.dismiss();
        }

    }


}
