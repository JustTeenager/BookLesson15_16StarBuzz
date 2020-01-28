package com.example.booklesson7starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);
        ArrayAdapter<Drinks> Adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Drinks.drinks);
        ListView DrinksCategories=findViewById(R.id.Drinks_categories);
        DrinksCategories.setAdapter(Adapter);
        AdapterView.OnItemClickListener ClickListener=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(DrinkCategoryActivity.this,DrinkActivity.class);
                intent.putExtra(DrinkActivity.DRINKID,(int) id);
                startActivity(intent);
            }
        };
        DrinksCategories.setOnItemClickListener(ClickListener);
    }
}
