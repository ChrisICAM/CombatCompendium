package com.example.combatcompendium.Fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.combatcompendium.Adapter.GameAdapter;
import com.example.combatcompendium.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CompendiumFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CompendiumFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ArrayList<Games> gamesList;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CompendiumFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CompendiumFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CompendiumFragment newInstance(String param1, String param2) {
        CompendiumFragment fragment = new CompendiumFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_compendium, container, false);

        gamesList = new ArrayList<>();

        //get string array from resource
        Resources res = getResources();
        String[] allGames = res.getStringArray(R.array.gameTitle);

        fillGameList(allGames);

        //setting adapter and listview
        GameAdapter adapter = new GameAdapter(getActivity().getApplicationContext(),
                R.layout.list_item, gamesList);
        ListView listview = root.findViewById(R.id.game_list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedGame = ((Games) parent.getItemAtPosition(position)).getGameName();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                Log.d("test", selectedGame);
                Toast.makeText(root.getContext(), selectedGame,
                        Toast.LENGTH_LONG).show();

                CharacterFragment charFrag = new CharacterFragment();
                Bundle bundle = new Bundle();
                bundle.putString("amount", selectedGame);
                charFrag.setArguments(bundle);
                transaction.replace(R.id.container, charFrag);
                transaction.commit();

            }
        });




        // Inflate the layout for this fragment
        return root;
    }

    public void fillGameList(String[] plans){
        gamesList.add(new Games(plans[0],R.drawable.db));
        gamesList.add(new Games(plans[1],R.drawable.mb));
        gamesList.add(new Games(plans[2],R.drawable.uni));
        gamesList.add(new Games(plans[3],R.drawable.ds));
        gamesList.add(new Games(plans[4],R.drawable.sf));
        gamesList.add(new Games(plans[5],R.drawable.gg));
        gamesList.add(new Games(plans[6],R.drawable.p4));
        gamesList.add(new Games(plans[7],R.drawable.mk));
    }
}