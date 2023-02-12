package com.jadikoding.jmpaplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "PendaftaranSQL.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE session(id integer PRIMARY KEY, login text)");
        sqLiteDatabase.execSQL("CREATE TABLE user(id integer PRIMARY KEY AUTOINCREMENT, nama text, alamat text)");
        sqLiteDatabase.execSQL("INSERT INTO session(id, login) VALUES(1,'kosong')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS session");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user");

        onCreate(sqLiteDatabase);


    }
}
