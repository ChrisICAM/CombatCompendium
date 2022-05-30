package com.example.combatcompendium.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.combatcompendium.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UniCharsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UniCharsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ImageSlider altColour;
    private ArrayList<SlideModel> colours;

    public UniCharsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UniCharsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UniCharsFragment newInstance(String param1, String param2) {
        UniCharsFragment fragment = new UniCharsFragment();
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

        View v = inflater.inflate(R.layout.fragment_uni_chars, container, false);

        TextView tv = v.findViewById(R.id.charTitle);
        CircleImageView logo = (CircleImageView) v.findViewById(R.id.char_logo);
        String result = getArguments().getString("character");
        String game = getArguments().getString("game");

        Log.d("alt", result);
        tv.setText(getArguments().getString("character"));

        if (game.equals("UNICLR")){
            if (result.equals("Akatsuki")){
                logo.setImageResource(R.drawable.akatsuki_logo);
            }
            else if (result.equals("Byakuya")){
                logo.setImageResource(R.drawable.byakyua_logo);
            }
            else if (result.equals("Carmine")){
                logo.setImageResource(R.drawable.carmine_logo);
            }
            else if (result.equals("Chaos")){
                logo.setImageResource(R.drawable.chaos_logo);
            }
            else if (result.equals("Eltnum")){
                logo.setImageResource(R.drawable.eltnum_logo);
            }
            else if (result.equals("Enkidu")){
                logo.setImageResource(R.drawable.enkidu_logo);
            }
            else if (result.equals("Gordeau")){
                logo.setImageResource(R.drawable.gordeau_logo);
            }
            else if (result.equals("Hilda")){
                logo.setImageResource(R.drawable.hilda_logo);
            }
            else if (result.equals("Hyde")){
                logo.setImageResource(R.drawable.hyde_logo);
            }
            else if (result.equals("Linne")){
                logo.setImageResource(R.drawable.linne_logo);
            }
            else if (result.equals("Londrekia")){
                logo.setImageResource(R.drawable.londrekia_logo);
            }
            else if (result.equals("Merkava")){
                logo.setImageResource(R.drawable.merkava_logo);
            }
            else if (result.equals("Mika")){
                logo.setImageResource(R.drawable.mika_logo);
            }
            else if (result.equals("Nanase")){
                logo.setImageResource(R.drawable.nanase_logo);
            }
            else if (result.equals("Orie")){
                logo.setImageResource(R.drawable.orie_logo);
            }
            else if (result.equals("Phonon")){
                logo.setImageResource(R.drawable.phonon_logo);
            }
            else if (result.equals("Seth")){
                logo.setImageResource(R.drawable.seth_logo);
            }
            else if (result.equals("Vatista")){
                logo.setImageResource(R.drawable.vatista_logo);
            }
            else if (result.equals("Wagner")){
                logo.setImageResource(R.drawable.wagner_logo);
            }
            else if (result.equals("Waldstein")){
                logo.setImageResource(R.drawable.waldstein_logo);
            }
            else if (result.equals("Yuzuriha")){
                logo.setImageResource(R.drawable.yuzu_logo);
            }
        }else{
            if (result.equals("Akiha")){
                logo.setImageResource(R.drawable.akiha_logo);
            }
            else if (result.equals("Aoko")){
                logo.setImageResource(R.drawable.aoko_logo);
            }
            else if (result.equals("Arcueid")){
                logo.setImageResource(R.drawable.arcueid_logo);
            }
            else if (result.equals("Ciel")){
                logo.setImageResource(R.drawable.ciel_logo);
            }
            else if (result.equals("DA Noel")){
                logo.setImageResource(R.drawable.danoel_logo);
            }
            else if (result.equals("Hisui and Kohaku")){
                logo.setImageResource(R.drawable.h_k_logo);
            }
            else if (result.equals("Hisui")){
                logo.setImageResource(R.drawable.hisui_logo);
            }
            else if (result.equals("Kohaku")){
                logo.setImageResource(R.drawable.kohaku_logo);
            }
            else if (result.equals("Kouma")){
                logo.setImageResource(R.drawable.kouma_logo);
            }
            else if (result.equals("Mario")){
                logo.setImageResource(R.drawable.mario_logo);
            }
            else if (result.equals("Miyako")){
                logo.setImageResource(R.drawable.miyako_logo);
            }
            else if (result.equals("Noel")){
                logo.setImageResource(R.drawable.noel_logo);
            }
            else if (result.equals("Powered Ciel")){
                logo.setImageResource(R.drawable.pciel_logo);
            }
            else if (result.equals("Red Arcueid")){
                logo.setImageResource(R.drawable.rarc_logo);
            }
            else if (result.equals("Roa")){
                logo.setImageResource(R.drawable.roa_logo);
            }
            else if (result.equals("Saber")){
                logo.setImageResource(R.drawable.saber_logo);
            }
            else if (result.equals("Shiki")){
                logo.setImageResource(R.drawable.shinki_logo);
            }
            else if (result.equals("Vlov")){
                logo.setImageResource(R.drawable.vlov_logo);
            }
        }

        altColour = v.findViewById(R.id.alt_colour_slider);
        Button lore = (Button) v.findViewById(R.id.btnLore);
        lore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loreLink = new Intent(Intent.ACTION_VIEW);
                String link;
                if (game.equals("UNICLR")){
                    link = "https://in-birth.fandom.com/wiki/" + result;

                }else{
                    if (result.equals("Akiha")){
                        link = "https://typemoon.fandom.com/wiki/Akiha_Tohno/Remake";
                    }
                    else if (result.equals("Aoko")){
                        link = "https://typemoon.fandom.com/wiki/Aoko_Aozaki";
                    }
                    else if (result.equals("Arcueid") || result.equals("Red Arcueid")){
                        link = "https://typemoon.fandom.com/wiki/Arcueid_Brunestud/Remake";
                    }
                    else if (result.equals("Ciel") || result.equals("Powered Ciel")){
                        link = "https://typemoon.fandom.com/wiki/Ciel/Remake";
                    }
                    else if (result.equals("DA Noel") || result.equals("Noel")){
                        link = "https://typemoon.fandom.com/wiki/Noel";
                    }
                    else if (result.equals("Hisui and Kohaku") || result.equals("Hisui")){
                        link = "https://typemoon.fandom.com/wiki/Hisui/Remake";
                    }
                    else if (result.equals("Kohaku")){
                        link = "https://typemoon.fandom.com/wiki/Kohaku/Remake";
                    }
                    else if (result.equals("Kouma")){
                        link = "https://typemoon.fandom.com/wiki/Kouma_Kishima/Remake";
                    }
                    else if (result.equals("Mario")){
                        link = "https://typemoon.fandom.com/wiki/Mario_Gallo_Bestino";
                    }
                    else if (result.equals("Miyako")){
                        link = "https://typemoon.fandom.com/wiki/Miyako_Arima/Remake";
                    }
                    else if (result.equals("Roa")){
                        link = "https://typemoon.fandom.com/wiki/Michael_Roa_Valdamjong/Remake";
                    }
                    else if (result.equals("Saber")){
                        link = "https://typemoon.fandom.com/wiki/Artoria_Pendragon_(Saber)";
                    }
                    else if (result.equals("Shiki")){
                        link = "https://typemoon.fandom.com/wiki/Shiki_Tohno/Remake";
                    }
                    else if (result.equals("Vlov")){
                        link = "https://typemoon.fandom.com/wiki/Vlov_Arkhangel";
                    }
                    else{
                        link = "";
                    }
                }
                loreLink.setData(Uri.parse(link));
                startActivity(loreLink);


            }
        });

        Button moves = (Button) v.findViewById(R.id.btnMoveList);
        moves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveLink = new Intent(Intent.ACTION_VIEW);
                String link;
                if (game.equals("UNICLR")){

                    link = "https://wiki.gbl.gg/w/Under_Night_In-Birth/UNICLR/" + result + "#Normal_Moves";

                }else{
                    if (result.equals("Akiha")){
                        link = "https://wiki.gbl.gg/w/Melty_Blood/MBTL/Akiha_Tohno#Move_Analysis";
                    }
                    else if (result.equals("Aoko")){
                        link = "https://wiki.gbl.gg/w/Melty_Blood/MBTL/Aoko_Aozaki#Move_Analysis";
                    }
                    else if (result.equals("Arcueid")){
                        link = "https://wiki.gbl.gg/w/Melty_Blood/MBTL/Arcueid_Brunestud#Move_Analysis";
                    }
                    else if (result.equals("Red Arcueid")){
                        link = "https://wiki.gbl.gg/w/Melty_Blood/MBTL/Red_Arcueid#Move_Analysis";
                    }
                    else if (result.equals("Ciel")){
                        link = "https://wiki.gbl.gg/w/Melty_Blood/MBTL/Ciel#Move_Analysis";
                    }
                    else if(result.equals("Powered Ciel")){
                        link = "https://wiki.gbl.gg/w/Melty_Blood/MBTL/Powered_Ciel#Move_Analysis";
                    }
                    else if (result.equals("DA Noel")){
                        link = "https://wiki.gbl.gg/w/Melty_Blood/MBTL/Dead_Apostle_Noel#Move_Analysis";
                    }
                    else if (result.equals("Noel")){
                        link = "https://wiki.gbl.gg/w/Melty_Blood/MBTL/Noel#Move_Analysis";
                    }
                    else if (result.equals("Hisui and Kohaku")){
                        link = "https://wiki.gbl.gg/w/Melty_Blood/MBTL/Hisui_%26_Kohaku#Hisui_Move_Analysis";
                    }
                    else if (result.equals("Hisui")){
                        link = "https://wiki.gbl.gg/w/Melty_Blood/MBTL/Hisui#Move_Analysis";
                    }
                    else if (result.equals("Kohaku")){
                        link = "https://wiki.gbl.gg/w/Melty_Blood/MBTL/Kohaku#Move_Analysis";
                    }
                    else if (result.equals("Kouma")){
                        link = "https://wiki.gbl.gg/w/Melty_Blood/MBTL/Kouma_Kishima#Move_Analysis";
                    }
                    else if (result.equals("Mario")){
                        link = "https://wiki.gbl.gg/w/Melty_Blood/MBTL/Mario_Gallo_Bestino#Move_Analysis";
                    }
                    else if (result.equals("Miyako")){
                        link = "https://wiki.gbl.gg/w/Melty_Blood/MBTL/Miyako_Arima#Move_Analysis";
                    }
                    else if (result.equals("Roa")){
                        link = "https://wiki.gbl.gg/w/Melty_Blood/MBTL/Michael_Roa_Valdamjong#Move_Analysis";
                    }
                    else if (result.equals("Saber")){
                        link = "https://wiki.gbl.gg/w/Melty_Blood/MBTL/Saber#Move_Analysis";
                    }
                    else if (result.equals("Shiki")){
                        link = "https://wiki.gbl.gg/w/Melty_Blood/MBTL/Shiki_Tohno#Move_Analysis";
                    }
                    else if (result.equals("Vlov")){
                        link = "https://wiki.gbl.gg/w/Melty_Blood/MBTL/Vlov_Arkhangel#Move_Analysis";
                    }
                    else{
                        link = "";
                    }
                }
                moveLink.setData(Uri.parse(link));
                startActivity(moveLink);



            }
        });

        ImageButton back = (ImageButton) v.findViewById(R.id.imageButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("amount", game);

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                CharacterFragment data = new CharacterFragment();
                data.setArguments(bundle);
                transaction.replace(R.id.container, data);
                transaction.commit();

            }
        });

        colours = new ArrayList<>();
        fillColours(game, result);
        altColour.setImageList(colours);

        // Inflate the layout for this fragment
        return v;
    }

    public void fillColours(String game, String result){
        if (game.equals("UNICLR")){
            if (result.equals("Akatsuki")){
                colours.add(new SlideModel(R.drawable.aka1, null));
                colours.add(new SlideModel(R.drawable.aka2, null));
                colours.add(new SlideModel(R.drawable.aka3, null));
                colours.add(new SlideModel(R.drawable.aka4, null));
                colours.add(new SlideModel(R.drawable.aka5, null));
                colours.add(new SlideModel(R.drawable.aka6, null));
                colours.add(new SlideModel(R.drawable.aka7, null));
                colours.add(new SlideModel(R.drawable.aka8, null));
                colours.add(new SlideModel(R.drawable.aka9, null));
                colours.add(new SlideModel(R.drawable.aka10, null));
            }
            else if (result.equals("Byakuya")){
                colours.add(new SlideModel(R.drawable.bya01, null));
                colours.add(new SlideModel(R.drawable.bya02, null));
                colours.add(new SlideModel(R.drawable.bya03, null));
                colours.add(new SlideModel(R.drawable.bya04, null));
                colours.add(new SlideModel(R.drawable.bya05, null));
                colours.add(new SlideModel(R.drawable.bya06, null));
                colours.add(new SlideModel(R.drawable.bya07, null));
                colours.add(new SlideModel(R.drawable.bya08, null));
                colours.add(new SlideModel(R.drawable.bya09, null));
                colours.add(new SlideModel(R.drawable.bya10, null));
            }
            else if (result.equals("Carmine")){
                colours.add(new SlideModel(R.drawable.car1, null));
                colours.add(new SlideModel(R.drawable.car2, null));
                colours.add(new SlideModel(R.drawable.car3, null));
                colours.add(new SlideModel(R.drawable.car4, null));
                colours.add(new SlideModel(R.drawable.car5, null));
                colours.add(new SlideModel(R.drawable.car6, null));
                colours.add(new SlideModel(R.drawable.car7, null));
                colours.add(new SlideModel(R.drawable.car8, null));
                colours.add(new SlideModel(R.drawable.car9, null));
                colours.add(new SlideModel(R.drawable.car10, null));
            }
            else if (result.equals("Chaos")){
                colours.add(new SlideModel(R.drawable.cha1, null));
                colours.add(new SlideModel(R.drawable.cha2, null));
                colours.add(new SlideModel(R.drawable.cha3, null));
                colours.add(new SlideModel(R.drawable.cha4, null));
                colours.add(new SlideModel(R.drawable.cha5, null));
                colours.add(new SlideModel(R.drawable.cha6, null));
                colours.add(new SlideModel(R.drawable.cha7, null));
                colours.add(new SlideModel(R.drawable.cha8, null));
                colours.add(new SlideModel(R.drawable.cha9, null));
                colours.add(new SlideModel(R.drawable.cha10, null));
            }
            else if (result.equals("Eltnum")){
                colours.add(new SlideModel(R.drawable.elt1, null));
                colours.add(new SlideModel(R.drawable.elt2, null));
                colours.add(new SlideModel(R.drawable.elt3, null));
                colours.add(new SlideModel(R.drawable.elt4, null));
                colours.add(new SlideModel(R.drawable.elt5, null));
                colours.add(new SlideModel(R.drawable.elt6, null));
                colours.add(new SlideModel(R.drawable.elt7, null));
                colours.add(new SlideModel(R.drawable.elt8, null));
                colours.add(new SlideModel(R.drawable.elt9, null));
                colours.add(new SlideModel(R.drawable.elt10, null));
            }
            else if (result.equals("Enkidu")){
                colours.add(new SlideModel(R.drawable.enkidu_1, null));
                colours.add(new SlideModel(R.drawable.enkidu_2, null));
                colours.add(new SlideModel(R.drawable.enkidu_3, null));
                colours.add(new SlideModel(R.drawable.enkidu_4, null));
                colours.add(new SlideModel(R.drawable.enkidu_5, null));
                colours.add(new SlideModel(R.drawable.enkidu_6, null));
                colours.add(new SlideModel(R.drawable.enkidu_7, null));
                colours.add(new SlideModel(R.drawable.enkidu_8, null));
                colours.add(new SlideModel(R.drawable.enkidu_9, null));
                colours.add(new SlideModel(R.drawable.enkidu_10, null));
            }
            else if (result.equals("Gordeau")){
                colours.add(new SlideModel(R.drawable.gord1, null));
                colours.add(new SlideModel(R.drawable.gord2, null));
                colours.add(new SlideModel(R.drawable.gord3, null));
                colours.add(new SlideModel(R.drawable.gord4, null));
                colours.add(new SlideModel(R.drawable.gord5, null));
                colours.add(new SlideModel(R.drawable.gord6, null));
                colours.add(new SlideModel(R.drawable.gord7, null));
                colours.add(new SlideModel(R.drawable.gord8, null));
                colours.add(new SlideModel(R.drawable.gord9, null));
                colours.add(new SlideModel(R.drawable.gord10, null));
            }
            else if (result.equals("Hilda")){
                colours.add(new SlideModel(R.drawable.hilda1, null));
                colours.add(new SlideModel(R.drawable.hilda2, null));
                colours.add(new SlideModel(R.drawable.hilda3, null));
                colours.add(new SlideModel(R.drawable.hilda4, null));
                colours.add(new SlideModel(R.drawable.hilda5, null));
                colours.add(new SlideModel(R.drawable.hilda6, null));
                colours.add(new SlideModel(R.drawable.hilda7, null));
                colours.add(new SlideModel(R.drawable.hilda8, null));
                colours.add(new SlideModel(R.drawable.hilda9, null));
                colours.add(new SlideModel(R.drawable.hilda10, null));
            }
            else if (result.equals("Hyde")){
                colours.add(new SlideModel(R.drawable.hyde1, null));
                colours.add(new SlideModel(R.drawable.hyde2, null));
                colours.add(new SlideModel(R.drawable.hyde3, null));
                colours.add(new SlideModel(R.drawable.hyde4, null));
                colours.add(new SlideModel(R.drawable.hyde5, null));
                colours.add(new SlideModel(R.drawable.hyde6, null));
                colours.add(new SlideModel(R.drawable.hyde7, null));
                colours.add(new SlideModel(R.drawable.hyde8, null));
                colours.add(new SlideModel(R.drawable.hyde9, null));
                colours.add(new SlideModel(R.drawable.hyde10, null));
            }
            else if (result.equals("Linne")){
                colours.add(new SlideModel(R.drawable.linne1, null));
                colours.add(new SlideModel(R.drawable.linne2, null));
                colours.add(new SlideModel(R.drawable.linne3, null));
                colours.add(new SlideModel(R.drawable.linne4, null));
                colours.add(new SlideModel(R.drawable.linne5, null));
                colours.add(new SlideModel(R.drawable.linne6, null));
                colours.add(new SlideModel(R.drawable.linne7, null));
                colours.add(new SlideModel(R.drawable.linne8, null));
                colours.add(new SlideModel(R.drawable.linne9, null));
                colours.add(new SlideModel(R.drawable.linne10, null));
            }
            else if (result.equals("Londrekia")){
                colours.add(new SlideModel(R.drawable.lnd1, null));
                colours.add(new SlideModel(R.drawable.lnd2, null));
                colours.add(new SlideModel(R.drawable.lnd3, null));
                colours.add(new SlideModel(R.drawable.lnd4, null));
                colours.add(new SlideModel(R.drawable.lnd5, null));
                colours.add(new SlideModel(R.drawable.lnd6, null));
                colours.add(new SlideModel(R.drawable.lnd7, null));
                colours.add(new SlideModel(R.drawable.lnd8, null));
                colours.add(new SlideModel(R.drawable.lnd9, null));
                colours.add(new SlideModel(R.drawable.lnd10, null));
            }
            else if (result.equals("Merkava")){
                colours.add(new SlideModel(R.drawable.mer1, null));
                colours.add(new SlideModel(R.drawable.mer2, null));
                colours.add(new SlideModel(R.drawable.mer3, null));
                colours.add(new SlideModel(R.drawable.mer4, null));
                colours.add(new SlideModel(R.drawable.mer5, null));
                colours.add(new SlideModel(R.drawable.mer6, null));
                colours.add(new SlideModel(R.drawable.mer7, null));
                colours.add(new SlideModel(R.drawable.mer8, null));
                colours.add(new SlideModel(R.drawable.mer9, null));
                colours.add(new SlideModel(R.drawable.mer10, null));
            }
            else if (result.equals("Mika")){
                colours.add(new SlideModel(R.drawable.mika01, null));
                colours.add(new SlideModel(R.drawable.mika02, null));
                colours.add(new SlideModel(R.drawable.mika03, null));
                colours.add(new SlideModel(R.drawable.mika04, null));
                colours.add(new SlideModel(R.drawable.mika05, null));
                colours.add(new SlideModel(R.drawable.mika06, null));
                colours.add(new SlideModel(R.drawable.mika07, null));
                colours.add(new SlideModel(R.drawable.mika08, null));
                colours.add(new SlideModel(R.drawable.mika09, null));
                colours.add(new SlideModel(R.drawable.mika10, null));
            }
            else if (result.equals("Nanase")){
                colours.add(new SlideModel(R.drawable.nan1, null));
                colours.add(new SlideModel(R.drawable.nan2, null));
                colours.add(new SlideModel(R.drawable.nan3, null));
                colours.add(new SlideModel(R.drawable.nan4, null));
                colours.add(new SlideModel(R.drawable.nan5, null));
                colours.add(new SlideModel(R.drawable.nan6, null));
                colours.add(new SlideModel(R.drawable.nan7, null));
                colours.add(new SlideModel(R.drawable.nan8, null));
                colours.add(new SlideModel(R.drawable.nan9, null));
                colours.add(new SlideModel(R.drawable.nan10, null));
            }
            else if (result.equals("Orie")){
                colours.add(new SlideModel(R.drawable.orie1, null));
                colours.add(new SlideModel(R.drawable.orie2, null));
                colours.add(new SlideModel(R.drawable.orie3, null));
                colours.add(new SlideModel(R.drawable.orie4, null));
                colours.add(new SlideModel(R.drawable.orie5, null));
                colours.add(new SlideModel(R.drawable.orie6, null));
                colours.add(new SlideModel(R.drawable.orie7, null));
                colours.add(new SlideModel(R.drawable.orie8, null));
                colours.add(new SlideModel(R.drawable.orie9, null));
                colours.add(new SlideModel(R.drawable.orie10, null));
            }
            else if (result.equals("Phonon")){
                colours.add(new SlideModel(R.drawable.phono1, null));
                colours.add(new SlideModel(R.drawable.phono2, null));
                colours.add(new SlideModel(R.drawable.phono3, null));
                colours.add(new SlideModel(R.drawable.phono4, null));
                colours.add(new SlideModel(R.drawable.phono5, null));
                colours.add(new SlideModel(R.drawable.phono6, null));
                colours.add(new SlideModel(R.drawable.phono7, null));
                colours.add(new SlideModel(R.drawable.phono8, null));
                colours.add(new SlideModel(R.drawable.phono9, null));
                colours.add(new SlideModel(R.drawable.phono10, null));
            }
            else if (result.equals("Seth")){
                colours.add(new SlideModel(R.drawable.seth1, null));
                colours.add(new SlideModel(R.drawable.seth2, null));
                colours.add(new SlideModel(R.drawable.seth3, null));
                colours.add(new SlideModel(R.drawable.seth4, null));
                colours.add(new SlideModel(R.drawable.seth5, null));
                colours.add(new SlideModel(R.drawable.seth6, null));
                colours.add(new SlideModel(R.drawable.seth7, null));
                colours.add(new SlideModel(R.drawable.seth8, null));
                colours.add(new SlideModel(R.drawable.seth9, null));
                colours.add(new SlideModel(R.drawable.seth10, null));
            }
            else if (result.equals("Vatista")){
                colours.add(new SlideModel(R.drawable.vati1, null));
                colours.add(new SlideModel(R.drawable.vati2, null));
                colours.add(new SlideModel(R.drawable.vati3, null));
                colours.add(new SlideModel(R.drawable.vati4, null));
                colours.add(new SlideModel(R.drawable.vati5, null));
                colours.add(new SlideModel(R.drawable.vati6, null));
                colours.add(new SlideModel(R.drawable.vati7, null));
                colours.add(new SlideModel(R.drawable.vati8, null));
                colours.add(new SlideModel(R.drawable.vati9, null));
                colours.add(new SlideModel(R.drawable.vati10, null));
            }
            else if (result.equals("Wagner")){
                colours.add(new SlideModel(R.drawable.wagner_1, null));
                colours.add(new SlideModel(R.drawable.wagner_2, null));
                colours.add(new SlideModel(R.drawable.wagner_3, null));
                colours.add(new SlideModel(R.drawable.wagner_4, null));
                colours.add(new SlideModel(R.drawable.wagner_5, null));
                colours.add(new SlideModel(R.drawable.wagner_6, null));
                colours.add(new SlideModel(R.drawable.wagner_7, null));
                colours.add(new SlideModel(R.drawable.wagner_8, null));
                colours.add(new SlideModel(R.drawable.wagner_9, null));
                colours.add(new SlideModel(R.drawable.wagner_10, null));
            }
            else if (result.equals("Waldstein")){
                colours.add(new SlideModel(R.drawable.wald1, null));
                colours.add(new SlideModel(R.drawable.wald2, null));
                colours.add(new SlideModel(R.drawable.wald3, null));
                colours.add(new SlideModel(R.drawable.wald4, null));
                colours.add(new SlideModel(R.drawable.wald5, null));
                colours.add(new SlideModel(R.drawable.wald6, null));
                colours.add(new SlideModel(R.drawable.wald7, null));
                colours.add(new SlideModel(R.drawable.wald8, null));
                colours.add(new SlideModel(R.drawable.wald9, null));
                colours.add(new SlideModel(R.drawable.wald10, null));
            }
            else if (result.equals("Yuzuriha")){
                colours.add(new SlideModel(R.drawable.yuzu1, null));
                colours.add(new SlideModel(R.drawable.yuzu2, null));
                colours.add(new SlideModel(R.drawable.yuzu3, null));
                colours.add(new SlideModel(R.drawable.yuzu4, null));
                colours.add(new SlideModel(R.drawable.yuzu5, null));
                colours.add(new SlideModel(R.drawable.yuzu6, null));
                colours.add(new SlideModel(R.drawable.yuzu7, null));
                colours.add(new SlideModel(R.drawable.yuzu8, null));
                colours.add(new SlideModel(R.drawable.yuzu9, null));
                colours.add(new SlideModel(R.drawable.yuzu10, null));
            }
        }else{
            //Melty Blood
            if (result.equals("Akiha")){
                colours.add(new SlideModel(R.drawable.akiha_color_01, null));
                colours.add(new SlideModel(R.drawable.akiha_color_02, null));
                colours.add(new SlideModel(R.drawable.akiha_color_03, null));
                colours.add(new SlideModel(R.drawable.akiha_color_04, null));
                colours.add(new SlideModel(R.drawable.akiha_color_05, null));
                colours.add(new SlideModel(R.drawable.akiha_color_06, null));
                colours.add(new SlideModel(R.drawable.akiha_color_07, null));
                colours.add(new SlideModel(R.drawable.akiha_color_08, null));
                colours.add(new SlideModel(R.drawable.akiha_color_09, null));
                colours.add(new SlideModel(R.drawable.akiha_color_10, null));
            }
            else if (result.equals("Aoko")){
                colours.add(new SlideModel(R.drawable.aoko_color_1, null));
                colours.add(new SlideModel(R.drawable.aoko_color_2, null));
                colours.add(new SlideModel(R.drawable.aoko_color_3, null));
                colours.add(new SlideModel(R.drawable.aoko_color_4, null));
                colours.add(new SlideModel(R.drawable.aoko_color_5, null));
            }
            else if (result.equals("Arcueid")){
                colours.add(new SlideModel(R.drawable.arceuid_color_01, null));
                colours.add(new SlideModel(R.drawable.arceuid_color_02, null));
                colours.add(new SlideModel(R.drawable.arceuid_color_03, null));
                colours.add(new SlideModel(R.drawable.arceuid_color_04, null));
                colours.add(new SlideModel(R.drawable.arceuid_color_05, null));
                colours.add(new SlideModel(R.drawable.arceuid_color_06, null));
                colours.add(new SlideModel(R.drawable.arceuid_color_07, null));
                colours.add(new SlideModel(R.drawable.arceuid_color_08, null));
                colours.add(new SlideModel(R.drawable.arceuid_color_09, null));
                colours.add(new SlideModel(R.drawable.arceuid_color_10, null));
            }
            else if (result.equals("Ciel")){
                colours.add(new SlideModel(R.drawable.ciel_color_01, null));
                colours.add(new SlideModel(R.drawable.ciel_color_02, null));
                colours.add(new SlideModel(R.drawable.ciel_color_03, null));
                colours.add(new SlideModel(R.drawable.ciel_color_04, null));
                colours.add(new SlideModel(R.drawable.ciel_color_05, null));
                colours.add(new SlideModel(R.drawable.ciel_color_06, null));
                colours.add(new SlideModel(R.drawable.ciel_color_07, null));
                colours.add(new SlideModel(R.drawable.ciel_color_08, null));
                colours.add(new SlideModel(R.drawable.ciel_color_09, null));
                colours.add(new SlideModel(R.drawable.ciel_color_10, null));
            }
            else if (result.equals("DA Noel")){
                colours.add(new SlideModel(R.drawable.da_noel_color_1, null));
                colours.add(new SlideModel(R.drawable.da_noel_color_2, null));
                colours.add(new SlideModel(R.drawable.da_noel_color_3, null));
                colours.add(new SlideModel(R.drawable.da_noel_color_4, null));
                colours.add(new SlideModel(R.drawable.da_noel_color_5, null));
            }
            else if (result.equals("Hisui and Kohaku")){
                colours.add(new SlideModel(R.drawable.maids_color_01, null));
                colours.add(new SlideModel(R.drawable.maids_color_02, null));
                colours.add(new SlideModel(R.drawable.maids_color_03, null));
                colours.add(new SlideModel(R.drawable.maids_color_04, null));
                colours.add(new SlideModel(R.drawable.maids_color_05, null));
                colours.add(new SlideModel(R.drawable.maids_color_06, null));
                colours.add(new SlideModel(R.drawable.maids_color_07, null));
                colours.add(new SlideModel(R.drawable.maids_color_08, null));
                colours.add(new SlideModel(R.drawable.maids_color_09, null));
                colours.add(new SlideModel(R.drawable.maids_color_10, null));
            }
            else if (result.equals("Hisui")){
                colours.add(new SlideModel(R.drawable.hisui_color_01, null));
                colours.add(new SlideModel(R.drawable.hisui_color_02, null));
                colours.add(new SlideModel(R.drawable.hisui_color_03, null));
                colours.add(new SlideModel(R.drawable.hisui_color_04, null));
                colours.add(new SlideModel(R.drawable.hisui_color_05, null));
                colours.add(new SlideModel(R.drawable.hisui_color_06, null));
                colours.add(new SlideModel(R.drawable.hisui_color_07, null));
                colours.add(new SlideModel(R.drawable.hisui_color_08, null));
                colours.add(new SlideModel(R.drawable.hisui_color_09, null));
                colours.add(new SlideModel(R.drawable.hisui_color_10, null));
            }
            else if (result.equals("Kohaku")){
                colours.add(new SlideModel(R.drawable.kohaku_color_01, null));
                colours.add(new SlideModel(R.drawable.kohaku_color_02, null));
                colours.add(new SlideModel(R.drawable.kohaku_color_03, null));
                colours.add(new SlideModel(R.drawable.kohaku_color_04, null));
                colours.add(new SlideModel(R.drawable.kohaku_color_05, null));
                colours.add(new SlideModel(R.drawable.kohaku_color_06, null));
                colours.add(new SlideModel(R.drawable.kohaku_color_07, null));
                colours.add(new SlideModel(R.drawable.kohaku_color_08, null));
                colours.add(new SlideModel(R.drawable.kohaku_color_09, null));
                colours.add(new SlideModel(R.drawable.kohaku_color_10, null));
            }
            else if (result.equals("Kouma")){
                colours.add(new SlideModel(R.drawable.kouma_color_01, null));
                colours.add(new SlideModel(R.drawable.kouma_color_02, null));
                colours.add(new SlideModel(R.drawable.kouma_color_03, null));
                colours.add(new SlideModel(R.drawable.kouma_color_04, null));
                colours.add(new SlideModel(R.drawable.kouma_color_05, null));
                colours.add(new SlideModel(R.drawable.kouma_color_06, null));
                colours.add(new SlideModel(R.drawable.kouma_color_07, null));
                colours.add(new SlideModel(R.drawable.kouma_color_08, null));
                colours.add(new SlideModel(R.drawable.kouma_color_09, null));
                colours.add(new SlideModel(R.drawable.kouma_color_10, null));
            }
            else if (result.equals("Mario")){
                colours.add(new SlideModel(R.drawable.mario_og, null));
                colours.add(new SlideModel(R.drawable.mario_color_1, null));
                colours.add(new SlideModel(R.drawable.mario_color_2, null));
                colours.add(new SlideModel(R.drawable.mario_color_3, null));
                colours.add(new SlideModel(R.drawable.mario_color_4, null));
            }
            else if (result.equals("Miyako")){
                colours.add(new SlideModel(R.drawable.miyako_color_1, null));
                colours.add(new SlideModel(R.drawable.miyako_color_2, null));
                colours.add(new SlideModel(R.drawable.miyako_color_3, null));
                colours.add(new SlideModel(R.drawable.miyako_color_4, null));
                colours.add(new SlideModel(R.drawable.miyako_color_5, null));
                colours.add(new SlideModel(R.drawable.miyako_color_6, null));
                colours.add(new SlideModel(R.drawable.miyako_color_7, null));
                colours.add(new SlideModel(R.drawable.miyako_color_8, null));
                colours.add(new SlideModel(R.drawable.miyako_color_9, null));
                colours.add(new SlideModel(R.drawable.miyako_color_10, null));
            }
            else if (result.equals("Noel")){
                colours.add(new SlideModel(R.drawable.noel_color_01, null));
                colours.add(new SlideModel(R.drawable.noel_color_02, null));
                colours.add(new SlideModel(R.drawable.noel_color_03, null));
                colours.add(new SlideModel(R.drawable.noel_color_04, null));
                colours.add(new SlideModel(R.drawable.noel_color_05, null));
                colours.add(new SlideModel(R.drawable.noel_color_06, null));
                colours.add(new SlideModel(R.drawable.noel_color_07, null));
                colours.add(new SlideModel(R.drawable.noel_color_08, null));
                colours.add(new SlideModel(R.drawable.noel_color_09, null));
                colours.add(new SlideModel(R.drawable.noel_color_10, null));
            }
            else if (result.equals("Powered Ciel")){
                colours.add(new SlideModel(R.drawable.pciel_color_01, null));
                colours.add(new SlideModel(R.drawable.pciel_color_02, null));
                colours.add(new SlideModel(R.drawable.pciel_color_03, null));
                colours.add(new SlideModel(R.drawable.pciel_color_04, null));
                colours.add(new SlideModel(R.drawable.pciel_color_05, null));
                colours.add(new SlideModel(R.drawable.pciel_color_06, null));
                colours.add(new SlideModel(R.drawable.pciel_color_07, null));
                colours.add(new SlideModel(R.drawable.pciel_color_08, null));
                colours.add(new SlideModel(R.drawable.pciel_color_09, null));
                colours.add(new SlideModel(R.drawable.pciel_color_10, null));
            }
            else if (result.equals("Red Arcueid")){
                colours.add(new SlideModel(R.drawable.warc_color_01, null));
                colours.add(new SlideModel(R.drawable.warc_color_02, null));
                colours.add(new SlideModel(R.drawable.warc_color_03, null));
                colours.add(new SlideModel(R.drawable.warc_color_04, null));
                colours.add(new SlideModel(R.drawable.warc_color_05, null));
                colours.add(new SlideModel(R.drawable.warc_color_06, null));
                colours.add(new SlideModel(R.drawable.warc_color_07, null));
                colours.add(new SlideModel(R.drawable.warc_color_08, null));
                colours.add(new SlideModel(R.drawable.warc_color_09, null));
                colours.add(new SlideModel(R.drawable.warc_color_10, null));
            }
            else if (result.equals("Roa")){
                colours.add(new SlideModel(R.drawable.roa_color_01, null));
                colours.add(new SlideModel(R.drawable.roa_color_02, null));
                colours.add(new SlideModel(R.drawable.roa_color_03, null));
                colours.add(new SlideModel(R.drawable.roa_color_04, null));
                colours.add(new SlideModel(R.drawable.roa_color_05, null));
                colours.add(new SlideModel(R.drawable.roa_color_06, null));
                colours.add(new SlideModel(R.drawable.roa_color_07, null));
                colours.add(new SlideModel(R.drawable.roa_color_08, null));
                colours.add(new SlideModel(R.drawable.roa_color_09, null));
                colours.add(new SlideModel(R.drawable.roa_color_10, null));
            }
            else if (result.equals("Saber")){
                colours.add(new SlideModel(R.drawable.saber_color_01, null));
                colours.add(new SlideModel(R.drawable.saber_color_02, null));
                colours.add(new SlideModel(R.drawable.saber_color_03, null));
                colours.add(new SlideModel(R.drawable.saber_color_04, null));
                colours.add(new SlideModel(R.drawable.saber_color_05, null));
                colours.add(new SlideModel(R.drawable.saber_color_06, null));
                colours.add(new SlideModel(R.drawable.saber_color_07, null));
                colours.add(new SlideModel(R.drawable.saber_color_08, null));
                colours.add(new SlideModel(R.drawable.saber_color_09, null));
                colours.add(new SlideModel(R.drawable.saber_color_10, null));
            }
            else if (result.equals("Shiki")){
                colours.add(new SlideModel(R.drawable.shiki_color_01, null));
                colours.add(new SlideModel(R.drawable.shiki_color_02, null));
                colours.add(new SlideModel(R.drawable.shiki_color_03, null));
                colours.add(new SlideModel(R.drawable.shiki_color_04, null));
                colours.add(new SlideModel(R.drawable.shiki_color_05, null));
                colours.add(new SlideModel(R.drawable.shiki_color_06, null));
                colours.add(new SlideModel(R.drawable.shiki_color_07, null));
                colours.add(new SlideModel(R.drawable.shiki_color_08, null));
                colours.add(new SlideModel(R.drawable.shiki_color_09, null));
                colours.add(new SlideModel(R.drawable.shiki_color_10, null));
            }
            else if (result.equals("Vlov")){
                colours.add(new SlideModel(R.drawable.vlov_color_01, null));
                colours.add(new SlideModel(R.drawable.vlov_color_02, null));
                colours.add(new SlideModel(R.drawable.vlov_color_03, null));
                colours.add(new SlideModel(R.drawable.vlov_color_04, null));
                colours.add(new SlideModel(R.drawable.vlov_color_05, null));
                colours.add(new SlideModel(R.drawable.vlov_color_06, null));
                colours.add(new SlideModel(R.drawable.vlov_color_07, null));
                colours.add(new SlideModel(R.drawable.vlov_color_08, null));
                colours.add(new SlideModel(R.drawable.vlov_color_09, null));
                colours.add(new SlideModel(R.drawable.vlov_color_10, null));
            }
        }

    }
}