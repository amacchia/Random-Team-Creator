package com.antmacchia.android.randomteamcreator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

import static android.text.InputType.TYPE_TEXT_FLAG_CAP_WORDS;

public class EnterNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);

        Bundle bundle = getIntent().getExtras();
        final int numberOfTeams = bundle.getInt("numberOfTeams");
        final int playersPerTeam = bundle.getInt("playersPerTeam");
        final int totalPlayers = numberOfTeams * playersPerTeam;
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        LinearLayout ll = (LinearLayout) findViewById(R.id.linear_layout);

        final ArrayList<String> namesOfPlayers = new ArrayList<>(totalPlayers);
        final EditText textBoxes[] = new EditText[totalPlayers];

        for (int i = 0; i < totalPlayers; i++){
            EditText editText = new EditText(this);
            editText.setHint("Enter name of player " + (i + 1));
            editText.setSingleLine();
            editText.setInputType(TYPE_TEXT_FLAG_CAP_WORDS);
            textBoxes[i] = editText;
            ll.addView(editText);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0; i < totalPlayers; i++) {
                    String name = textBoxes[i].getText().toString();
                    namesOfPlayers.add(i, name);
                }
                startDisplayTeamsActivity(namesOfPlayers, numberOfTeams, playersPerTeam);
            }
        });

    }

    private void startDisplayTeamsActivity(ArrayList<String> playerNames, int numberOfTeams, int playersPerTeam){
        Intent intent = new Intent(EnterNameActivity.this, DisplayTeamsActivity.class);
        intent.putExtra("nameOfPlayers", playerNames);
        intent.putExtra("teams", numberOfTeams);
        intent.putExtra("playersPerTeam", playersPerTeam);

        startActivity(intent);
    }

}
