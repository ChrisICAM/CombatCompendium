package com.example.combatcompendium.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.combatcompendium.Fragment.Plan;
import com.example.combatcompendium.R;
import com.example.combatcompendium.databinding.LobbyItemsBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LobbyAdapter extends  RecyclerView.Adapter<LobbyAdapter.viewHolder>{

    Context context;
    ArrayList<Plan> list;

    public LobbyAdapter(Context context, ArrayList<Plan> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lobby_items, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Plan plan = list.get(position);
        Picasso.get()
                .load(plan.getThumbnail())
                .placeholder(R.drawable.naruto_vs_sasuke)
                .into(holder.binding.imgThumbnail);
        holder.binding.gameName.setText(plan.getGame());
        holder.binding.characterName.setText(plan.getCharacter());
        holder.binding.planTitle.setText(plan.getTitle());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        LobbyItemsBinding binding;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            binding = LobbyItemsBinding.bind(itemView);
        }
    }
}
