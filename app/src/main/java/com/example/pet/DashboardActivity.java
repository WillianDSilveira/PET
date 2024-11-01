package com.example.pet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    ArrayList<Pet> listaPet = new ArrayList<Pet>();
    RepositorioLOG repositorioLOG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Pegando os dados do pai
        String login = (String) getIntent().getSerializableExtra("login");
        Toast.makeText(this, "Bem Vindo: " + login, Toast.LENGTH_SHORT).show();
        setTitle("Dashboard");

        repositorioLOG = new RepositorioLOG(this);
    }


    public void cadastroPet(View view) {
        // abre a Activity de cadastro
        Bundle bundle = new Bundle();// Cria mochila
        bundle.putSerializable("lista_pet", listaPet); // joga a lista dentro da mochila
        Intent intent = new Intent(this,
                CadastroPetActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void listagemPet(View view) {
        // abre a Activity de listagem
        Bundle bundle = new Bundle();// Bundle=Mochila
        bundle.putSerializable("lista_pet", listaPet);
        Intent intent = new Intent(this,
                ListagemPetActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void removerPet(View view) {

        // abre a Activity de remocao
        Bundle bundle = new Bundle();// Bundle=Mochila
        bundle.putSerializable("lista_pet", listaPet);
        Intent intent = new Intent(this,
                RemoverPetActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void atualizarPet(View view) {
        // abre a Activity de Atualizacao
        Bundle bundle = new Bundle();// Bundle=Mochila
        bundle.putSerializable("lista_pet", listaPet);
        Intent intent = new Intent(this,
                AtualizarPetActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void listarLog(View view) {

        // pegando a lista do banco
        List<LOG> listaDB = repositorioLOG.listarLOG();
        String[] dados = new  String[listaDB.size()];

        // passando lista para o vetor.
        for(int i=0; i < listaDB.size(); i++){
            LOG log = listaDB.get(i);
            dados[i] = log.data + " - " + log.operacao + " - " + log.nome;

        }

    }
}