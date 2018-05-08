package com.example.android.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUsers (name VARCHAR, age INT(3), id INTEGER PRIMARY KEY)");

            //sqLiteDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Bryce', 26)");
            //sqLiteDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Bob', 45)");
            //sqLiteDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('George', 15)");

            sqLiteDatabase.execSQL("DELETE FROM newUsers WHERE id = 2");

            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM newUsers", null);
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id");
            c.moveToFirst();

            while (c != null) {
                Log.i("UserResults - name", c.getString(nameIndex));
                Log.i("UserResults - age", Integer.toString(c.getInt(ageIndex)));
                Log.i("UserResults - id", Integer.toString(c.getInt(idIndex)));

                c.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
