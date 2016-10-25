package com.equipe2.amd;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NovoActivity extends AppCompatActivity {
        private EditText editTextId;
        private EditText editTextSenha;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_novo);
            this.editTextId = (EditText) findViewById(R.id.editTextId);
            this.editTextSenha = (EditText) findViewById(R.id.editTextSenha);
            Intent intent = getIntent();
            if (intent != null){
                Bundle bundle = intent.getExtras();
                if (bundle != null){
                    this.editTextId.setText(bundle.getString("id"));
                    this.editTextSenha.setText(bundle.getString("senha"));
                }
            }
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_novo, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void salvar (View view){

        Toast.makeText(getApplicationContext(), "Novo Usuário Incluido no Banco de Dados.",
                Toast.LENGTH_LONG).show();
        finish();
    }
    public void cancelar (View view){
        Toast.makeText(getApplicationContext(), "Operação Cancelada",
                Toast.LENGTH_SHORT).show();
        finish();
    }
}