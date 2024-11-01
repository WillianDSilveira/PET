package com.example.pet;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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

    public List<LOG> listarLOG(){
        ArrayList<LOG> lista = new ArrayList<>();
        String sql = "select * from LOG";
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            LOG log = new LOG();
            log.id = cursor.getInt(0); // coluna 0
            log.data = cursor.getString(1); // coluna 2
            log.operacao = cursor.getString(2); // coluna 2
            log.nome = cursor.getString(3); // coluna 1
            lista.add(log);
            cursor.moveToNext();
        }
        cursor.close();
        return lista;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
