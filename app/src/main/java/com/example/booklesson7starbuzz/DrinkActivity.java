package com.example.booklesson7starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.booklesson7starbuzz.Drinks.drinks;

public class DrinkActivity extends AppCompatActivity {
    public static final String DRINKID="drinkid";
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        Intent intent=getIntent();
        id=intent.getIntExtra(DRINKID,0);
        //id=(int) intent.getExtras().get(DRINKID); //Другой способ получения информации из интента
        Drinks drink=drinks[id];
        TextView name=findViewById(R.id.Label);
        TextView description=findViewById(R.id.Description);
        ImageView image=findViewById(R.id.DrinkImage);
        name.setText(drink.GetName());
        description.setText(drink.Getdescription());
        image.setImageResource(drink.GetImageId());
        image.setContentDescription(drink.GetName());
    }
}