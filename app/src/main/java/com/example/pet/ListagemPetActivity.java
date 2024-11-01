package com.example.pet;

import static com.example.pet.R.id.listviewpet;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListagemPetActivity extends AppCompatActivity {

    ArrayList<Pet> listapet;
    RepositorioPet repositorioPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_pet);
        setTitle("Listagem Pet");

        listapet = (ArrayList<Pet>) getIntent()
                .getSerializableExtra("lista_pet");
        Log.i("pet", "Carregado Listagem Pet com Sucesso");

        repositorioPet = new RepositorioPet(this);


        // listando os dados no LogCat
        for(Pet pet : DadosCompartilhados.lista){
            Log.i("pet", "Nome Pet: " + pet.nome);
            Log.i("pet", "Idade Pet: " + pet.idade);
            Log.i("pet", "------------------------" );
        }

        ListView listView = findViewById(R.id.listviewpet);

        // pegando a lista do banco
        List<Pet> listaDB = repositorioPet.listarPet();
        String[] dados = new  String[listaDB.size()];

        // passando lista para o vetor.
        for(int i=0; i < listaDB.size(); i++){
            Pet pet = listaDB.get(i);
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