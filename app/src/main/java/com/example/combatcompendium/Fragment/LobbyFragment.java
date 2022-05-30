package com.example.combatcompendium.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.combatcompendium.Adapter.LobbyAdapter;
import com.example.combatcompendium.R;
import com.example.combatcompendium.databinding.FragmentLobbyBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LobbyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LobbyFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    FragmentLobbyBinding binding;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<Plan> list = new ArrayList<>();
    FirebaseAuth auth;
    FirebaseDatabase database;

    public LobbyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LobbyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LobbyFragment newInstance(String param1, String param2) {
        LobbyFragment fragment = new LobbyFragment();
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
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLobbyBinding.inflate(inflater, container, false);

        LobbyAdapter adapter = new LobbyAdapter(getContext(), list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.plansRV.setLayoutManager(layoutManager);
        binding.plansRV.setAdapter(adapter);

        database.getReference().child("Plans").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){

                    Plan plan = dataSnapshot.getValue(Plan.class);
                    Log.d("test", plan.getThumbnail());
                    plan.setUserID(dataSnapshot.getKey());
                    list.add(plan);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Button follow = (Button) binding.follow;
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new FollowFragment());
                transaction.commit();
            }
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}