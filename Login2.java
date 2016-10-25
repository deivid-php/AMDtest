package com.equipe2.amd;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.*;
public class Login2 extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
    }
    public void irParaAluno (View view){
        Intent intencao = new Intent(this,Aluno.class);
        startActivity(intencao);
    }
    public void irParaProfessor (View view){
        Intent intencao = new Intent(this,Professor.class);
        startActivity(intencao);
    }
    public void irParaAdmin (View view){
        Intent intencao = new Intent(this,Admin.class);
        startActivity(intencao);
    }
    public void irParaNovo (View view){
        Intent intencao = new Intent(this,NovoActivity.class);
        startActivity(intencao);
    }
}
