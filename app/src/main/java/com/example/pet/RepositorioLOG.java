package com.example.pet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class RepositorioLOG extends SQLiteOpenHelper {


    public RepositorioLOG(@Nullable Context context) {
        super(context, "log", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE LOG(id INTEGER NOT NULL PRIMARY KEY, data TEXT, operacao TEXT, nome TEXT)";
        sqLiteDatabase.execSQL(sql);
        Log.i("LOG", "Criado com sucesso a tabela LOG");
    }

    public void adicionarLOG(LOG log){
        String sql = "INSERT INTO pet VALUES(null,'" + log.data + "','" + log.operacao + "', '" + log.operacao + "' )";
        Log.i("log", "SQL insert log: "+ sql);
        super.getWritableDatabase().execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
