package com.antmacchia.android.randomteamcreator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Ant on 3/11/2017.
 */

public class TeamAdapter extends FragmentPagerAdapter {

    private int numberOfTeams;
    private Team[] createdTeams;

    public TeamAdapter(Team[] createdTeams,int numberOfTeams, FragmentManager fragmentManager){
        super(fragmentManager);
        this.numberOfTeams = numberOfTeams;
        this.createdTeams = createdTeams;
    }

    @Override
    public int getCount() {
        return numberOfTeams;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new TeamFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("playerNames", createdTeams[position].getPlayerNames());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Team " + (position + 1);
    }
}
