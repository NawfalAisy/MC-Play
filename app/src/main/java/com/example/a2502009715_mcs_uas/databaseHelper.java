package com.example.a2502009715_mcs_uas;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class databaseHelper extends SQLiteOpenHelper {

    private static final String DB_Name = "dbarticle", table_Name = "article", image_art = "img_data", art_ID = "ID", art_tittle = "tittle";
    private static final int DB_versi = 1;
    public databaseHelper(Context context) {
        super(context, DB_Name, null, DB_versi);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + table_Name + " ("
                + art_ID + " integer primary key autoincrement,"
                + art_tittle + " TEXT,"
                + image_art + " INTEGER)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_Name);
        onCreate(db);
    }

    public void addNewArticle(String title_art, Integer image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(image_art, image);
        values.put(art_tittle, title_art);
        db.insert(table_Name, null, values);
        db.close();
    }

    public ArrayList<articles> dataOutput(){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursorArt = database.rawQuery("SELECT * FROM " + table_Name, null);

        ArrayList<articles> articles_Database = new ArrayList<>();
        if(cursorArt.moveToFirst()){
            do {
                articles_Database.add(new articles(cursorArt.getInt(cursorArt.getColumnIndexOrThrow(image_art)), cursorArt.getString(cursorArt.getColumnIndexOrThrow(art_tittle))));
            }while (cursorArt.moveToNext());
        }
        cursorArt.close();
        return articles_Database;
    }
}
