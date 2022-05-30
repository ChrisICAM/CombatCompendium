package com.example.combatcompendium.Fragment;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.combatcompendium.R;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText title, description;
    private VideoView videoView;
    private Button uploadBtn, saveBtn;
    private FloatingActionButton pickVid, pickThumb;
    private Spinner gameSpinner;
    Spinner charSpinner;
    ImageView thumbnail;
    Uri uri;

    //URI of selected video
    private Uri videoUri;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private static final int VIDEO_PICK_GALLERY_CODE = 100;

    public CreateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateFragment newInstance(String param1, String param2) {
        CreateFragment fragment = new CreateFragment();
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
        View v = inflater.inflate(R.layout.fragment_create, container, false);

        title = v.findViewById(R.id.titleC);
        description = v.findViewById(R.id.desc);
        videoView = v.findViewById(R.id.videoView);
        pickVid = v.findViewById(R.id.fabVid);
        pickThumb = v.findViewById(R.id.fabThumb);
        uploadBtn = v.findViewById(R.id.uploadBtn);
        saveBtn = v.findViewById(R.id.saveBtn);
        gameSpinner = v.findViewById(R.id.gameSelect);
        charSpinner = v.findViewById(R.id.charSelect);
        thumbnail = v.findViewById(R.id.thumbnail);

        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String game = gameSpinner.getSelectedItem().toString();
                String character = charSpinner.getSelectedItem().toString();
                String videoLink = videoUri.toString();
                String imageLink = uri.toString();
                String Data = title.getText().toString();
                String desc = description.getText().toString();

                Plan createPlan = new Plan(game, character, Data, desc);
                if (!videoLink.equals(null)){
                    createPlan.setVideo(videoLink);
                }
                if (!imageLink.equals(null)){
                    createPlan.setThumbnail(imageLink);
                }



                String id = FirebaseAuth.getInstance().getUid();
                createPlan.setUserID(id);
                FirebaseDatabase.getInstance().getReference()
                        .child("Plans")
                        .child(id)
                        .setValue(createPlan).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        FirebaseDatabase.getInstance().getReference()
                                .child("Users")
                                .child(FirebaseAuth.getInstance().getUid())
                                .child("Plans")
                                .setValue(createPlan).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(getContext(), "Plan was made", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

            }
        });

        pickThumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.with(CreateFragment.this)
                        .crop()                    //Crop image(Optional), Check Customization for more option
                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)    //Final image resolution will be less than 1080 x 1080(Optional)
                        .start(10);
            }
        });

        ArrayAdapter<CharSequence> gameAdapter =  ArrayAdapter.createFromResource(getContext(), R.array.gameTitle, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        gameAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        gameSpinner.setAdapter(gameAdapter);

        gameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        ArrayAdapter<CharSequence> charAdapter =  ArrayAdapter.createFromResource(getContext(), R.array.DBChar, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        charAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        charSpinner.setAdapter(charAdapter);
                        break;
                    case 1:
                        ArrayAdapter<CharSequence> charAdapter1 =  ArrayAdapter.createFromResource(getContext(), R.array.MBChar, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        charAdapter1.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        charSpinner.setAdapter(charAdapter1);
                        break;
                    case 2:
                        ArrayAdapter<CharSequence> charAdapter2 =  ArrayAdapter.createFromResource(getContext(), R.array.UniChar, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        charAdapter2.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        charSpinner.setAdapter(charAdapter2);
                        break;
                    case 3:
                        ArrayAdapter<CharSequence> charAdapter3 =  ArrayAdapter.createFromResource(getContext(), R.array.DSChar, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        charAdapter3.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        charSpinner.setAdapter(charAdapter3);
                        break;
                    case 4:
                        ArrayAdapter<CharSequence> charAdapter4 =  ArrayAdapter.createFromResource(getContext(), R.array.SFChar, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        charAdapter4.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        charSpinner.setAdapter(charAdapter4);
                        break;
                    case 5:
                        ArrayAdapter<CharSequence> charAdapter5 =  ArrayAdapter.createFromResource(getContext(), R.array.GGChar, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        charAdapter5.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        charSpinner.setAdapter(charAdapter5);
                        break;
                    case 6:
                        ArrayAdapter<CharSequence> charAdapter6 =  ArrayAdapter.createFromResource(getContext(), R.array.p4Char, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        charAdapter6.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        charSpinner.setAdapter(charAdapter6);
                        break;
                    case 7:
                        ArrayAdapter<CharSequence> charAdapter7 =  ArrayAdapter.createFromResource(getContext(), R.array.MKChar, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        charAdapter7.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                        charSpinner.setAdapter(charAdapter7);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        pickVid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoPickGallery();
            }
        });
        // Inflate the layout for this fragment
        return v;
    }

    private void setVideoToVideoView(){
        MediaController mediaController = new MediaController(getContext());
        mediaController.setAnchorView(videoView);

        //set media controller to video view
        videoView.setMediaController(mediaController);

        videoView.setVideoURI(videoUri);
        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.pause();
            }
        });
    }

    private void videoPickGallery() {
        //pick a video from the gallery
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, VIDEO_PICK_GALLERY_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 10){
                uri = data.getData();
                thumbnail.setImageURI(uri);
            }else{
                videoUri = data.getData();
                Log.d("test", videoUri.toString());
                setVideoToVideoView();
            }

    }
}