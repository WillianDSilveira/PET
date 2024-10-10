package com.example.pet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Vincula com o xml
        setTitle("Login");
    }

    public void logar(View view) {
        // Pegando os compenentes da interface grafica
        EditText login = findViewById(R.id.editTextLogin); // R = Resourse
        EditText senha = findViewById(R.id.editTextSenha);

        // Pegando o conteudo da caixa de login
        String conteudoLogin = login.getText().toString();
        String conteudoSenha = senha.getText().toString();

        if(conteudoLogin.isEmpty()){
            Toast.makeText(this, "prencher o campo login", Toast.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      LENGTH_SHORT).show();
            return;
        }
        if(conteudoSenha.isEmpty()){
            Toast.makeText(this, "prencher o campo senha", Toast.LENGTH_SHORT).show();
            return;
        }

        List<String> listaLogin = Arrays.asList("admin", "marcelo", "willian", "joao");

        if(listaLogin.contains(conteudoLogin) && conteudoSenha.equals("123")){
            // Acessar dashboard
            Bundle bundle = new Bundle();
            bundle.putString("login", conteudoLogin);
            Intent intent = new Intent(this,DashboardActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Usuario ou Senha INVALIDO", Toast.LENGTH_SHORT).show();
            return;
        }


    }
}