package com.antmacchia.android.randomteamcreator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    int teams = 2;
    int playersOnTeam = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button subtractTeam = (Button) findViewById(R.id.subtractTeam);
        Button addTeam = (Button) findViewById(R.id.addTeam);
        Button subtractPlayer = (Button) findViewById(R.id.subtractPlayer);
        Button addPlayer = (Button) findViewById(R.id.addPlayer);
        Button enterNames = (Button) findViewById(R.id.enter_names_button);
        final TextView numberOfTeams = (TextView) findViewById(R.id.numberOfTeams);
        final TextView playersPerTeam = (TextView) findViewById(R.id.playersPerTeam);

        subtractTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (teams == 2) {
                    Toast.makeText(MainActivity.this, "Cannot have less than 2 teams!", Toast.LENGTH_SHORT).show();
                    return;
                }

                teams--;
                numberOfTeams.setText("" + teams);
            }
        });

        addTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teams++;
                numberOfTeams.setText("" + teams);
            }
        });

        subtractPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playersOnTeam == 2) {
                    Toast.makeText(MainActivity.this, "Cannot have less than 2 players on a team!", Toast.LENGTH_SHORT).show();
                    return;
                }

                playersOnTeam--;
                playersPerTeam.setText("" + playersOnTeam);
            }
        });

        addPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playersOnTeam++;
                playersPerTeam.setText("" + playersOnTeam);
            }
        });

        enterNames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startEnterNamesActivity();
            }
        });
    }

    private  void startEnterNamesActivity(){
        Intent enterNameIntent = new Intent(MainActivity.this, EnterNameActivity.class);
        enterNameIntent.putExtra("numberOfTeams", teams);
        enterNameIntent.putExtra("playersPerTeam", playersOnTeam);
        startActivity(enterNameIntent);
    }
}
