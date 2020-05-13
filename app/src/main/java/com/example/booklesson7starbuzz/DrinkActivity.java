package com.example.booklesson7starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DrinkActivity extends AppCompatActivity {
    public static final String DRINKID="drinkid";
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        Intent intent = getIntent();
        id = intent.getIntExtra(DRINKID, 0);
        //id=(int) intent.getExtras().get(DRINKID); //Другой способ получения информации из интента
        StarBuzzDataBaseHelper helper = new StarBuzzDataBaseHelper(this);
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor;
        try {
            cursor = database.query("DRINK",
                    new String[]{"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID INTEGER"},
                    "_id=?",
                    new String[]{Integer.toString(id)}, null, null, null);
            if (cursor.moveToFirst()) {
                //Drinks drink=drinks[id];
                TextView name = findViewById(R.id.Label);
                TextView description = findViewById(R.id.Description);
                ImageView image = findViewById(R.id.DrinkImage);
                name.setText(cursor.getString(0));
                description.setText(cursor.getString(1));
                image.setImageResource(cursor.getInt(2));
                image.setContentDescription(cursor.getString(0));

            }
            cursor.close();
            database.close();
        } catch (SQLiteException e) {
            Toast toast=Toast.makeText(this,"WRONG DATABASE",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}