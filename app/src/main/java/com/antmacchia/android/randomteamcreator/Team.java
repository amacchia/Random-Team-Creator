package com.antmacchia.android.randomteamcreator;

import java.util.ArrayList;

/**
 * Created by Ant on 3/8/2017.
 */

public class Team {
    private int numberOfPlayersOnTeam;
    private ArrayList<String> playerNames = new ArrayList<>();

    public Team (int numberOfPlayersOnTeam){
        this.numberOfPlayersOnTeam = numberOfPlayersOnTeam;
    }
    public void addPlayerNames(String name){
        playerNames.add(name);
    }

    public ArrayList<String> getPlayerNames() {
        return playerNames;
    }

}
