package android.example.com.miwokapplication;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_listview);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?","minto wuksus?"));
        words.add(new Word("What is your name?","tinnә oyaase'nә?"));
        words.add(new Word("My name is...","oyaaset..."));
        words.add(new Word("How are you feeling?","michәksәs?"));
        words.add(new Word("I'm feeling good.","kuchi achit."));
        words.add(new Word("Are you coming?","әәnәs'aa?"));
        words.add(new Word("Yes, I'm coming.","hәә’ әәnәm."));
        words.add(new Word("I’m coming.","әәnәm."));
        words.add(new Word("Let's go!","yoowutis."));
        words.add(new Word("Come here.","әnni'nem."));

        //ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<Word>(this, R.layout.item_layout, wordsList);
        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.words_listView);
        listView.setAdapter(adapter);
    }
}
