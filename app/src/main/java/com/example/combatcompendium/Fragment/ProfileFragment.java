package com.example.combatcompendium.Fragment;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.example.combatcompendium.R;
import com.example.combatcompendium.SettingPage;
import com.example.combatcompendium.User;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ImageView banner;
    CircleImageView profile;
    FloatingActionButton btnBanner, btnProfile, btnBio, btnGame, btnSetting;
    TextView bio;
    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;
    EditText newBio;
    Button cancel, pass;
    FirebaseAuth auth;
    FirebaseStorage storage;
    FirebaseDatabase database;


    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getActivity().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        banner = v.findViewById(R.id.bannerView);
        profile = v.findViewById(R.id.profile_image);
        bio = v.findViewById(R.id.bio);
        database.getReference().child("Users").child(auth.getUid())
                .addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    User user = snapshot.getValue(User.class);
                    Picasso.get().load(user.getBanner())
                            .placeholder(R.drawable.naruto_vs_sasuke).into(banner);
                    bio.setText(user.getBio());
                    Picasso.get().load(user.getProfile())
                            .placeholder(R.drawable.seth_logo).into(profile);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        btnBanner = v.findViewById(R.id.fabBanner);
        btnProfile = v.findViewById(R.id.fabProfile);
        btnBio = v.findViewById(R.id.fabBio);
        btnGame = v.findViewById(R.id.fabGame);
        btnSetting = v.findViewById(R.id.fabSettings);

        btnBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.with(ProfileFragment.this)
                        .crop()                    //Crop image(Optional), Check Customization for more option
                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)    //Final image resolution will be less than 1080 x 1080(Optional)
                        .start(10);
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.with(ProfileFragment.this)
                        .cropSquare()                   //Crop image(Optional), Check Customization for more option
                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)    //Final image resolution will be less than 1080 x 1080(Optional)
                        .start(20);
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                //transaction.replace(R.id.container, new SettingsFragment());
                //transaction.hide(ProfileFragment.this);
                //transaction.show(new SettingsFragment());
                //transaction.commit();
                Intent i = new Intent(getContext(), SettingPage.class);
                startActivity(i);

            }
        });

        btnBio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup();
            }
        });

        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri uri = data.getData();

        if(requestCode == 10){
            banner.setImageURI(uri);
            final StorageReference reference = storage.getReference().child("banner")
                    .child(FirebaseAuth.getInstance().getUid());
            reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(getContext(), "Banner Saved", Toast.LENGTH_SHORT).show();
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity(), "My Notification");
                    builder.setContentTitle("New Banner Uploaded");
                    builder.setContentText("Your new banner has been saved & uploaded");
                    builder.setSmallIcon(R.drawable.pencil_18);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getActivity());
                    managerCompat.notify(1, builder.build());

                    reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            database.getReference().child("Users")
                                    .child(auth.getUid()).child("banner").setValue(uri.toString());
                        }
                    });
                }
            });
        }else{
            profile.setImageURI(uri);
            final StorageReference reference = storage.getReference().child("profile")
                    .child(FirebaseAuth.getInstance().getUid());
            reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(getContext(), "Profile Pic Saved", Toast.LENGTH_SHORT).show();
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity(), "My Notification");
                    builder.setContentTitle("New Profile Pic Uploaded");
                    builder.setContentText("Your new profile pic has been saved & uploaded");
                    builder.setSmallIcon(R.drawable.pencil_18);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getActivity());
                    managerCompat.notify(1, builder.build());

                    reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            database.getReference().child("Users")
                                    .child(auth.getUid()).child("profile").setValue(uri.toString());
                        }
                    });
                }
            });
        }

    }

    public void popup(){
        dialogBuilder = new AlertDialog.Builder(getContext());
        View bioPopupView = getLayoutInflater().inflate(R.layout.popup, null);
        newBio = (EditText) bioPopupView.findViewById(R.id.editText);

        pass = (Button) bioPopupView.findViewById(R.id.submit);
        cancel = (Button) bioPopupView.findViewById(R.id.cancel);

        dialogBuilder.setView(bioPopupView);
        dialog = dialogBuilder.create();
        dialog.show();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getActivity().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bio.setText(newBio.getText());
                dialog.dismiss();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity(), "My Notification");
                builder.setContentTitle("Bio Edited");
                builder.setContentText("Congratulations, your bio has been updated");
                builder.setSmallIcon(R.drawable.pencil_18);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getActivity());
                managerCompat.notify(1, builder.build());

                database.getReference().child("Users").child(auth.getUid())
                        .child("bio").setValue(newBio.getText().toString());
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }


}