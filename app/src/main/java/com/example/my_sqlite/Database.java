package com.example.my_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE = "UserManager.db";
    private static final String FABLE = "user";
    private static final String EMAIL = "user_email";
    private static final String PASSWORD = "user_password";
    private static final String ID = "user_id";

    public Database(Context context) {
        super( context, DATABASE, null, VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String user_table = " CREATE TABLE " + FABLE + "(" + ID  + " INTEGER PRIMARY KEY AUTOINCREMENT," 
                + EMAIL  + " TEXT," + PASSWORD  + " TEXT" + ")";

        sqLiteDatabase.execSQL( user_table  );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void add_user_update_also(Model model1) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( EMAIL , model1.getEmail() );
        contentValues.put( PASSWORD , model1.getPassword() );
        sqLiteDatabase.insert( FABLE, null, contentValues );
        sqLiteDatabase.close();
    }

    public boolean checkUser(String email, String password) {

        String[] columns = {ID };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = EMAIL  + " = ?" + " AND " + PASSWORD  + " = ?";
        String[] selectionArgs = {email, password};

        Cursor cursor = db.query( FABLE, columns, selection, selectionArgs,
                                  null, null, null );

        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        } else {
            return false;
        }
    }
}