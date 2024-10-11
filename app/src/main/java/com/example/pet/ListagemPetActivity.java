package com.example.pet;

import static com.example.pet.R.id.listviewpet;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

        ListView listView = findViewById(R.id.listviewpet);

        String[] dados =
                new  String[DadosCompartilhados.lista.size()];

        for(int i=0; i < DadosCompartilhados.lista.size(); i++){
            Pet pet = DadosCompartilhados.lista.get(i);
            dados[i] = pet.nome + " - " + pet.idade;
            // dados[i] = DadosCompartilhados.lista.get(i).nome;
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        dados);

        listView.setAdapter(adapter);

    }
}