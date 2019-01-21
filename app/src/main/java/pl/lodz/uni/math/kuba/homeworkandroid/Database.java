package pl.lodz.uni.math.kuba.homeworkandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "database";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE CALCULATION_HISTORY(" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "RESULT TEXT NOT NULL);" +
                        "");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS CALCULATION_HISTORY");
        db.execSQL("CREATE TABLE CALCULATION_HISTORY(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "RESULT TEXT NOT NULL);" +
                "");
    }


    public void addValue(String value) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("RESULT", value);
        database.insertOrThrow("CALCULATION_HISTORY", null, values);
    }

    public ArrayList<String> getAll() {
        ArrayList<String> list = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String selectQuery = "SELECT * FROM CALCULATION_HISTORY";
        Cursor cursor = database.rawQuery(selectQuery, null);

        while (cursor.moveToNext()) {
            list.add(cursor.getString(1));
        }
        cursor.close();

        return list;
    }

}