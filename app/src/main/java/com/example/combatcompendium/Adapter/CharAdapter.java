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

import com.example.combatcompendium.Fragment.Characters;
import com.example.combatcompendium.R;

import java.util.ArrayList;

public class CharAdapter extends ArrayAdapter<Characters> {
    private ArrayList<Characters> charList;

    public CharAdapter(@NonNull Context context, int resource, ArrayList<Characters> charList) {
        super(context, resource, charList);
        this.charList = charList;
    }

    @NonNull

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_items, parent, false);
        }
        ImageView planImage = convertView.findViewById(R.id.charImage);
        TextView planTitle = convertView.findViewById(R.id.charName);
        planImage.setImageResource(charList.get(position).getCharId());
        planTitle.setText(charList.get(position).getCharName());
        return convertView;
    }
}

