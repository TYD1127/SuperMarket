package com.tyd.supermarket;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class my_db_helper extends SQLiteOpenHelper {
    public my_db_helper(@Nullable Context context) {
        super(context, "supermarket.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase mydb) {
        String sqlc = "CREATE TABLE cart(_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20),  price VARCHAR(20), number VARCHAR(20))";
        String sql = "CREATE TABLE user_info(u_id VARCHAR(20) , u_name VARCHAR(20),  u_pwd VARCHAR(20))";
        String  sq = "CREATE TABLE user_sc (u_time integer primary key autoincrement , u_bj_content VARCHAR(1000))";
        String  s = "CREATE TABLE u_sc (u_sc_id integer primary key autoincrement , u_sc VARCHAR(1000))";
        mydb.execSQL(sql);
        mydb.execSQL(sq);
        mydb.execSQL(s);
        mydb.execSQL(sqlc);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user_info");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user_sc");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS u_sc");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS cart");
        onCreate(sqLiteDatabase);
    }
}
