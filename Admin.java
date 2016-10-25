package com.equipe2.amd;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
public class Admin extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public void irParaNovo (View view){
        Intent intencao = new Intent(this,NovoActivity.class);
        startActivity(intencao);
    }
    Intent p;
    private static final int PICK_FILE_REQUEST = 0;
    public void selecionarArquivoAluno(View view){
        Intent abrir_intent = new Intent();
        abrir_intent.setType("*/*");
        abrir_intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(
                abrir_intent, "Selecione um arquivo"), PICK_FILE_REQUEST);
        p = abrir_intent;
        Intent sendIntent = new Intent();
        sendIntent.setType("*/*");
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "VERSÃO 1.0");
        sendIntent.putExtra(Intent.ACTION_OPEN_DOCUMENT, p);
        startActivity(sendIntent);
    }
    public void AbrirArquivoAtualAdmin(View view) {
        String url = "https://drive.google.com/folderview?id" +
                "=0B9AED1AJbX9qMmxWY2RTZExsS1k&usp=sharing/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    public void SalvarNoBanco(View view) {
        Toast.makeText(getApplicationContext(), "Informações salvas no Banco de Dados.",
                Toast.LENGTH_LONG).show();
        finish();
    }

}
