package android.example.com.miwokapplication;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_listview);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father","әpә", R.drawable.family_father));
        words.add(new Word("mother","әṭa", R.drawable.family_mother));
        words.add(new Word("son","angsi", R.drawable.family_son));
        words.add(new Word("daughter","tune", R.drawable.family_daughter));
        words.add(new Word("older brother","taachi", R.drawable.family_older_brother));
        words.add(new Word("younger brother","chalitty", R.drawable.family_younger_brother));
        words.add(new Word("older sister","teṭe", R.drawable.family_older_sister));
        words.add(new Word("younger sister","kolliti", R.drawable.family_older_sister));
        words.add(new Word("grandfather","paapa", R.drawable.family_grandfather));
        words.add(new Word("grandmother","ama", R.drawable.family_grandmother));

        //ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<Word>(this, R.layout.item_layout, wordsList);
        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.words_listView);
        listView.setAdapter(adapter);
    }
}
