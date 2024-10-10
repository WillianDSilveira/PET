package com.example.pet;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListagemPetActivity extends AppCompatActivity {

    ArrayList<Pet> listapet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_pet);
        setTitle("Listagem Pet");
        listapet = (ArrayList<Pet>) getIntent()
                .getSerializableExtra("lista_pet");
        Log.i("pet", "Carregado Listagem Pet com Sucesso");

        // listando os dados no LogCat
        for(Pet pet : DadosCompartilhados.lista){
            Log.i("pet", "Nome Pet: " + pet.nome);
            Log.i("pet", "Idade Pet: " + pet.idade);
            Log.i("pet", "------------------------" );
        }
    }
}