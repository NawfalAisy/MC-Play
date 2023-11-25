package com.example.a2502009715_mcs_uas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class datahelper_match extends SQLiteOpenHelper {
    private static final String DB_Name_history = "dbHistory", table_Name = "history", image_A = "img_teamA", image_B = "img_teamB", history_ID = "ID", history_tittleMain = "tittleMain", history_tittleSub = "tittleSub", time = "time", date = "date", team_A = "teamA", team_B = "teamB";
    private static final int DB_versi = 1;
    public datahelper_match(@Nullable Context context) {
        super(context, DB_Name_history, null, DB_versi);
    }

    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + table_Name + " ("
                + history_ID + " integer primary key autoincrement,"
                + history_tittleSub + " TEXT,"
                + team_A + " TEXT, "
                + team_B + " TEXT, "
                + history_tittleMain + " TEXT, "
                + time + " TEXT, "
                + date + " TEXT, "
                + image_A + " INTEGER, "
                + image_B + " INTEGER)";
        db.execSQL(query);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_Name);
        onCreate(db);
    }

    public void addNewHistory(String Temp_history_tittleMain, String Temp_history_tittleSub, String date_history, String time_history, Integer imageA, Integer imageB, String temp_nameA, String temp_nameB) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(image_A, imageA);
        values.put(date, date_history);
        values.put(image_B,imageB);
        values.put(team_A, temp_nameA);
        values.put(team_B, temp_nameB);
        values.put(time, time_history);
        values.put(history_tittleSub, Temp_history_tittleMain);
        values.put(history_tittleMain, Temp_history_tittleMain);

        db.insert(table_Name, null, values);
        db.close();
    }

    public ArrayList<history_data> dataOutput(){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursorArt = database.rawQuery("SELECT * FROM " + table_Name, null);

        ArrayList<history_data> history_datas = new ArrayList<>();
        if(cursorArt.moveToFirst()){
            do {
                history_datas.add(new history_data(
                        cursorArt.getString(cursorArt.getColumnIndexOrThrow(history_tittleMain)),
                        cursorArt.getString(cursorArt.getColumnIndexOrThrow(history_tittleSub)),
                        cursorArt.getString(cursorArt.getColumnIndexOrThrow(date)),
                        cursorArt.getString(cursorArt.getColumnIndexOrThrow(time)),
                        cursorArt.getString(cursorArt.getColumnIndexOrThrow(team_A)),
                        cursorArt.getString(cursorArt.getColumnIndexOrThrow(team_B)),
                        cursorArt.getInt(cursorArt.getColumnIndexOrThrow(image_A)),
                        cursorArt.getInt(cursorArt.getColumnIndexOrThrow(image_B))));
            }while (cursorArt.moveToNext());
        }
        cursorArt.close();
        return history_datas;
    }
}
