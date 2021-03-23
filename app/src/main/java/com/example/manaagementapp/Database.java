package com.example.manaagementapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//source code from :
//https://www.allcodingtutorials.com/post/insert-delete-update-and-view-data-in-sqlite-database-android-studio


public class Database extends SQLiteOpenHelper {

        public Database( Context context ) {
            super(context, "ManagementTool", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create Table ManagementTool(ProjectName TEXT primary key,Description TEXT,Goal TEXT, StartDate DATE, endDate DATE)");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop Table if exists ManagementTool");

        }

        public Boolean insertuserdata(String ProjectName, String Description, String Goal, String StartDate, String endDate)
        {
            SQLiteDatabase DB = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("ProjectName", ProjectName);
            contentValues.put("Description", Description);
            contentValues.put("Goal", Goal);
            contentValues.put("StartDate", StartDate);
            contentValues.put("endDate", endDate);

            long result=DB.insert("ManagementTool", null, contentValues);
            if(result==-1){
                return false;
            }else{
                return true;
            }
        }

        public Boolean deletedata (String title)
        {
            SQLiteDatabase DB = this.getWritableDatabase();
            Cursor cursor = DB.rawQuery("Select * from ManagementTool where title = ?", new String[]{title});
            if (cursor.getCount() > 0) {
                long result = DB.delete("ManagementTool", "title=?", new String[]{title});
                if (result == -1) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }

        public Cursor getdata ()
        {
            SQLiteDatabase DB = this.getWritableDatabase();
            Cursor cursor = DB.rawQuery("Select * from ManagementTool", null);
            //Cursor cursor = DB.rawQuery("Select * from reminder Order By date ASC", null);//
            return cursor;

        }
    }




