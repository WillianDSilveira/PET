package com.example.pet;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Date;

public class CadastroPetActivity extends AppCompatActivity {
    ArrayList<Pet> listapet;// criei a variavel
    RepositorioPet repositorioPet; // cria a variavel do Repositorio
    RepositorioLOG repositorioLOG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pet);
        setTitle("Cadastro Pet");

        listapet =
                (ArrayList<Pet>) getIntent()
                .getSerializableExtra("lista_pet");

        Log.i("pet", "Carregado Cadastro Pet com Sucesso");

        repositorioPet = new RepositorioPet(this); // Intancia o Repositorio e referencia ao this
        repositorioLOG = new RepositorioLOG(this);
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
        pet.nome = conteudoNome;
        pet.idade = Integer.parseInt(conteudoIdade);
        repositorioPet.adicionarPet(pet);
        Toast.makeText(this, "Pet Cadastrado com Sucesso", Toast.LENGTH_SHORT).show();

        // LOG

        LOG log = new LOG();
        log.data = new Date().toString();
        log.operacao = "Teste";
        log.nome = DadosCompartilhados.usuarioLogado;
        repositorioLOG.adicionarLOG(log);


        // limpa a tela.
        nome.setText("");
        idade.setText("");

    }
}