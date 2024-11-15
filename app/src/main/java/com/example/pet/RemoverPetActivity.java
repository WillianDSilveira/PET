package com.example.pet;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RemoverPetActivity extends AppCompatActivity {
    ArrayList<Pet> listapet;
    RepositorioPet repositorioPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_remover_pet);
        setTitle("Remover Pet");
        listapet = (ArrayList<Pet>) getIntent()
                .getSerializableExtra("lista_pet");
        Log.i("pet", "Carregado Remover Pet com Sucesso");

    }

    public void remover(View view) {
        EditText editText = findViewById(R.id.editTextIdPet);
        String idString = editText.getText().toString();

        // ***** estudar metodo EQUALS
        try {
            Integer id = Integer.parseInt(idString);
            Pet pet = repositorioPet.buscarPet(id);
            if(pet == null){
                Toast.makeText(this,"nâo encontrado id", // Verifica se o objeto id pet é igual ao id digitado pelo usuario
                        Toast.LENGTH_LONG).show();
                return;
            }
            repositorioPet.removerPet(id);
            Toast.makeText(this, "Pet removido com sucesso", Toast.LENGTH_SHORT).show();
            //boolean resultado = DadosCompartilhados.lista
            //        .removeIf(obj -> obj.id.equals(id));

        }catch (Exception e){
            Toast.makeText(this, "Digite somente numeros", Toast.LENGTH_SHORT).show();
        }


    }
}