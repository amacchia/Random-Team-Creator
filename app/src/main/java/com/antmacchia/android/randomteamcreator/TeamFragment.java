package com.antmacchia.android.randomteamcreator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamFragment extends Fragment {


    public TeamFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.team_roster, container, false);
        Bundle bundle = getArguments();
        ArrayList<String> playerNames = bundle.getStringArrayList("playerNames");

        ListView listView = (ListView) rootView.findViewById(R.id.list_roster);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, playerNames);
        listView.setAdapter(arrayAdapter);

        return rootView;
    }

}
