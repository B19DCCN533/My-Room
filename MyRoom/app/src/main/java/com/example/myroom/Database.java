package com.example.myroom;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }
    public void QuerryData(String sql)
    {
        SQLiteDatabase data=getWritableDatabase();
        data.execSQL(sql);
    }
    public Cursor getData(String sql)
    {
        SQLiteDatabase data=getReadableDatabase();
        return data.rawQuery(sql,null);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
