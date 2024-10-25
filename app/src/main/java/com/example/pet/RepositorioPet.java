package com.example.pet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class RepositorioPet extends SQLiteOpenHelper {

    public RepositorioPet(@Nullable Context context) {
        super(context, "pet", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE PET(id INTEGER NOT NULL PRIMARY KEY, nome TEXT, idade INTEGER)";
        sqLiteDatabase.execSQL(sql);
        Log.i("pet", "Criado com sucesso a tabela pet");
    }

    public void adicionarPet(Pet pet){
        String sql = "INSERT INTO pet VALUES(null,'" + pet.nome + "', " + pet.idade + ")";
        Log.i("pet", "SQL insert pet: "+ sql);
        super.getWritableDatabase().execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
