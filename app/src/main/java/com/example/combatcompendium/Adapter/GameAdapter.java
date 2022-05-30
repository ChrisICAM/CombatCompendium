package com.example.combatcompendium.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.combatcompendium.Fragment.Games;
import com.example.combatcompendium.R;

import java.util.ArrayList;

public class GameAdapter  extends ArrayAdapter<Games> {
    private ArrayList<Games> gamesList;

    public GameAdapter(@NonNull Context context, int resource, ArrayList<Games> gamesList) {
        super(context, resource, gamesList);
        this.gamesList = gamesList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        ImageView planImage = convertView.findViewById(R.id.game_image);
        TextView planTitle = convertView.findViewById(R.id.game_title);
        planImage.setImageResource(gamesList.get(position).getGameId());
        planTitle.setText(gamesList.get(position).getGameName());
        return convertView;
    }
}
