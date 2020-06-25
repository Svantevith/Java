package android.example.com.miwokapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class HomeScreen extends AppCompatActivity {

    CardView numbers;
    CardView familyMembers;
    CardView colors;
    CardView phrases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_toolbar);

        numbers = findViewById(R.id.numbers_CardView);
        familyMembers = findViewById(R.id.family_members_CardView);
        colors = findViewById(R.id.colors_CardView);
        phrases = findViewById(R.id.phrases_CardView);

        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(view.getContext(), "Open the list of numbers", Toast.LENGTH_SHORT).show();
                // we can make declare the context also as MainActivity.this (because we are currently thinking of making a toast starting on the MainActivity screen)
                //view is a variable declared in onClick(View view) by default , and view.getContext() by default defines the view as the MainActivity.this ( we don't need to do it by ourself )
                Intent numbersIntent = new Intent(HomeScreen.this, android.example.com.miwokapplication.NumbersActivity.class );
                startActivity(numbersIntent);
            }
        });

        familyMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(view.getContext(), "Open the list of family members", Toast.LENGTH_SHORT).show();
                Intent familyMembersIntent = new Intent(HomeScreen.this, android.example.com.miwokapplication.FamilyMembersActivity.class);
                startActivity(familyMembersIntent);
            }
        });

        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(view.getContext(), "Open the list of colors", Toast.LENGTH_SHORT).show();
                Intent colorsIntent = new Intent(HomeScreen.this, android.example.com.miwokapplication.ColorsActivity.class);
                startActivity(colorsIntent);
            }
        });

        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(HomeScreen.this, "Open the list of phrases", Toast.LENGTH_SHORT).show();
                Intent phrasesIntent = new Intent(HomeScreen.this, android.example.com.miwokapplication.PhrasesActivity.class);
                startActivity(phrasesIntent);
            }
        });


    }
}
