package com.example.combatcompendium.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.combatcompendium.R;
import com.example.combatcompendium.User;
import com.example.combatcompendium.databinding.UserSampleBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.viewHolder>{

    Context context;
    ArrayList<User> list;

    public UserAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_sample, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        User user = list.get(position);
        Picasso.get().load(user.getProfile())
                .placeholder(R.drawable.baiken_logo)
                .into(holder.binding.profilePic);
        holder.binding.username.setText(user.getUsername());

        holder.binding.followSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true){
                    String follower = FirebaseAuth.getInstance().getUid();
                    FirebaseDatabase.getInstance().getReference()
                            .child("Users")
                            .child(user.getUserID())
                            .child("followers")
                            .child(FirebaseAuth.getInstance().getUid())
                            .setValue(follower).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            FirebaseDatabase.getInstance().getReference()
                                    .child("Users")
                                    .child(user.getUserID())
                                    .child("followerCount")
                                    .setValue(user.getFollowerCount() + 1).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(compoundButton.getContext(), "Now Following " + user.getUsername(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });

                }else{
                    Toast.makeText(compoundButton.getContext(), "Unfollowed " + user.getUsername(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        UserSampleBinding binding;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            binding = UserSampleBinding.bind(itemView);
        }
    }
}
