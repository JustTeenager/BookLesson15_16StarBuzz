package com.example.booklesson7starbuzz;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class DrinkCategoryActivity extends Activity {
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);
       // ArrayAdapter<Drinks> Adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Drinks.drinks);
        ListView drinksCategories=findViewById(R.id.Drinks_categories);
        //DrinksCategories.setAdapter(Adapter);

        StarBuzzDataBaseHelper helper=new StarBuzzDataBaseHelper(this);
        db=helper.getReadableDatabase();
        try {
            cursor = db.query("DRINK",
                    new String[]{"_id","NAME"},null,null,null,null,null);
            SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,cursor,new String[]{"NAME"},new int[]{android.R.id.text1},0);
            drinksCategories.setAdapter(adapter);


        }catch (SQLiteException e){
            Toast.makeText(this,"WRONG DATABASE",Toast.LENGTH_SHORT).show();
        }

        AdapterView.OnItemClickListener ClickListener=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(DrinkCategoryActivity.this,DrinkActivity.class);
                intent.putExtra(DrinkActivity.DRINKID,(int) id);
                startActivity(intent);
            }
        };
        drinksCategories.setOnItemClickListener(ClickListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }
}
