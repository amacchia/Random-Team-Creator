package com.antmacchia.android.randomteamcreator;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class DisplayTeamsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_teams);

        Bundle bundle = getIntent().getExtras();
        int numberOfTeams = bundle.getInt("teams");
        int playersPerTeam = bundle.getInt("playersPerTeam");
        ArrayList<String> nameOfPlayers = bundle.getStringArrayList("nameOfPlayers");

        Team[] createdTeams = new Team[numberOfTeams];
        for (int i = 0; i < numberOfTeams; i++) {
            Team newTeam = new Team(playersPerTeam);
            createdTeams[i] = newTeam;
        }

        Collections.shuffle(nameOfPlayers);

        for (int i = 0; i < numberOfTeams; i++) {

            for (int count = 0; count < playersPerTeam; count++) {
                createdTeams[i].addPlayerNames(nameOfPlayers.get(0));
                nameOfPlayers.remove(0);
            }
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        TeamAdapter teamAdapter = new TeamAdapter(createdTeams, numberOfTeams, getSupportFragmentManager());
        viewPager.setAdapter(teamAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);


    }

}
