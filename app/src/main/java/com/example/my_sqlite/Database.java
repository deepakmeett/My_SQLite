package com.example.my_sqlite;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
public class Database extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE = "Database.db";
    private static final String ID = "user_id";
    private static final String FABLE = "K";
    private static final String EMAIL = "user_email";
    private static final String PASSWORD = "user_password";

    public Database(Context context) {
        super( context, DATABASE, null, VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL( "create table " + FABLE + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, Email TEXT, Password TEXT)" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void add_user_update_also(Fodel fodel1) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( EMAIL, fodel1.getEmail() );
        contentValues.put( PASSWORD, fodel1.getPassword() );
        sqLiteDatabase.insert( FABLE, null, contentValues );
        sqLiteDatabase.close();
    }

    public boolean checkUser(String email, String password) {
        String[] columns = {ID};
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String selection = EMAIL + "=?" + " AND " + PASSWORD + "=?";
        Log.d( "ep", email );
        Log.d( "ep", password );
        String[] selectionArgs = {email, password};
        Cursor cursor = sqLiteDatabase.query( FABLE, columns, selection, selectionArgs,
                                              null, null, null );
        int cursorCount = cursor.getCount();
        cursor.close();
        sqLiteDatabase.close();
        return cursorCount > 0;
    }
}