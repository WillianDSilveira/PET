package com.example.pet;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CadastroPetActivity extends AppCompatActivity {
    ArrayList<Pet> listapet;// criei a variavel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pet);
        setTitle("Cadastro Pet");

        listapet =
                (ArrayList<Pet>) getIntent()
                .getSerializableExtra("lista_pet");
        Log.i("pet", "Carregado Cadastro Pet com Sucesso");
    }

    public void cadastrar(View view) {
        EditText nome = findViewById(R.id.editTextNomePet);
        EditText idade = findViewById(R.id.editTextIdadePet);

        String conteudoNome = nome.getText().toString();
        String conteudoIdade = idade.getText().toString();

        if(conteudoNome.isEmpty() || conteudoIdade.isEmpty()){
            Toast.makeText(this, "Preencha os Campos", Toast.LENGTH_SHORT).show();
            return;
        }

        Pet pet = new Pet();
        pet.id = DadosCompartilhados.getNextId();
        pet.nome = conteudoNome;
        pet.idade = Integer.parseInt(conteudoIdade);
        DadosCompartilhados.lista.add(pet);
        Toast.makeText(this, "Pet Cadastrado com Sucesso", Toast.LENGTH_SHORT).show();

        // limpa a tela.
        nome.setText("");
        idade.setText("");

    }
}