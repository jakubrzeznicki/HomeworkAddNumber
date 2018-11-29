package pl.lodz.uni.math.kuba.homeworkandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Baza extends SQLiteOpenHelper {

    public Baza(Context context) {
        super(context, "obliczenia.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "create table obliczenia(" +
                        "nr integer primary key autoincrement," +
                        "wyrazenie text);" +
                        "");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


    public void dodajWyrazenie(String wyrazenie) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues wartosci = new ContentValues();
        wartosci.put("wyrazenie", wyrazenie);

        db.insertOrThrow("obliczenia", null, wartosci);
    }

    public Cursor dajWszystkie() {
        String[] kolumny = {"nr", "wyrazenie"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor kursor = db.query("obliczenia", kolumny, null, null, null, null, null);
        return kursor;
    }

}