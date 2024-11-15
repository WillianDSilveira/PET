package com.example.pet;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ListagemLogActivity extends AppCompatActivity {

    RepositorioLOG repositorioLog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log);
        repositorioLog = new RepositorioLOG(this);
    }


    public void buscarLogs(View view) {
        EditText editTextUsuario = findViewById(R.id.editTextUsuario);

        String usuario = null;
        if(!editTextUsuario.getText()
                .toString().isEmpty()){
            usuario =editTextUsuario.getText().toString();
        }
        List<LOG> lista = repositorioLog.listarLOG(usuario);
        String[] dados = new String[lista.size()];
        // passando da lista para o vetor.
        for(int i=0; i < lista.size();i++){
            LOG log = lista.get(i);
            dados[i] = log.nome + "\n" + log.data + " - "  +log.operacao;
        }
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        dados);
        ListView listView = findViewById(R.id.listViewLog);
        listView.setAdapter(adapter);
    }
}