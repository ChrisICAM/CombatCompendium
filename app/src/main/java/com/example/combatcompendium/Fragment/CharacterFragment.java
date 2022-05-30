package com.example.combatcompendium.Fragment;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.combatcompendium.Adapter.CharAdapter;
import com.example.combatcompendium.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharacterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    GridView gridView;
    private ArrayList<Characters> charList;

    public CharacterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CharacterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterFragment newInstance(String param1, String param2) {
        CharacterFragment fragment = new CharacterFragment();
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

        View v = inflater.inflate(R.layout.fragment_character, container, false);

        TextView tv = v.findViewById(R.id.charTitle);
        CircleImageView logo = (CircleImageView) v.findViewById(R.id.game_logo);
        String result = getArguments().getString("amount");
        Log.d("alt", result);
        tv.setText(getArguments().getString("amount"));
        charList = new ArrayList<>();

        //get string array from resource
        Resources res = getResources();
        String[] allChar = new String[0];
        if (result.equals("UNICLR")){
            logo.setImageResource(R.drawable.uni);
            allChar = res.getStringArray(R.array.UniChar);
        }else if (result.equals("Melty Blood Type Lumina")){
            tv.setText("Melty Blood");
            logo.setImageResource(R.drawable.mb);
            allChar = res.getStringArray(R.array.MBChar);
        }else if (result.equals("Guilty Gear Strive")){
            logo.setImageResource(R.drawable.gg);
            allChar = res.getStringArray(R.array.GGChar);
        }else if (result.equals("Persona 4 Arena Ultimax")){
            tv.setText("Persona 4 AU");
            logo.setImageResource(R.drawable.p4);
            allChar = res.getStringArray(R.array.p4Char);
        }else if (result.equals("Demon Slayer Hinokami Chronicles")){
            tv.setText("Demon Slayer");
            logo.setImageResource(R.drawable.ds);
            allChar = res.getStringArray(R.array.DSChar);
        }else if (result.equals("Mortal Kombat 11")){
            logo.setImageResource(R.drawable.mk);
            allChar = res.getStringArray(R.array.MKChar);
        }else if (result.equals("Dragon Ball FighterZ")){
            tv.setText("DB FighterZ");
            logo.setImageResource(R.drawable.db);
            allChar = res.getStringArray(R.array.DBChar);
        }else if (result.equals("Street Fighter 5")){
            logo.setImageResource(R.drawable.sf);
            allChar = res.getStringArray(R.array.SFChar);
        }

        ImageButton back = (ImageButton) v.findViewById(R.id.imageButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new CompendiumFragment());
                transaction.commit();
            }
        });
        fillCharList(allChar, result);

        CharAdapter adapter = new CharAdapter(getActivity().getApplicationContext(),
                R.layout.row_items, charList);
        gridView = v.findViewById(R.id.charView);


        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedChar = ((Characters) adapterView.getItemAtPosition(i)).getCharName();

                Bundle bundle = new Bundle();
                bundle.putString("character", selectedChar);
                bundle.putString("game", result);

                if (result.equals("UNICLR") || result.equals("Melty Blood Type Lumina")){


                    Toast.makeText(v.getContext(), selectedChar,
                            Toast.LENGTH_SHORT).show();

                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                    UniCharsFragment data = new UniCharsFragment();
                    data.setArguments(bundle);
                    transaction.replace(R.id.container, data);
                    transaction.commit();

                }
            }
        });


        // Inflate the layout for this fragment
        return v;
    }
    public void fillCharList(String[] plans, String game){
        if (game.equals("UNICLR")){
            charList.add(new Characters(plans[0],R.drawable.akatsuki_logo));
            charList.add(new Characters(plans[1],R.drawable.byakyua_logo));
            charList.add(new Characters(plans[2],R.drawable.carmine_logo));
            charList.add(new Characters(plans[3],R.drawable.chaos_logo));
            charList.add(new Characters(plans[4],R.drawable.eltnum_logo));
            charList.add(new Characters(plans[5],R.drawable.enkidu_logo));
            charList.add(new Characters(plans[6],R.drawable.gordeau_logo));
            charList.add(new Characters(plans[7],R.drawable.hilda_logo));
            charList.add(new Characters(plans[8],R.drawable.hyde_logo));
            charList.add(new Characters(plans[9],R.drawable.linne_logo));
            charList.add(new Characters(plans[10],R.drawable.londrekia_logo));
            charList.add(new Characters(plans[11],R.drawable.merkava_logo));
            charList.add(new Characters(plans[12],R.drawable.mika_logo));
            charList.add(new Characters(plans[13],R.drawable.nanase_logo));
            charList.add(new Characters(plans[14],R.drawable.orie_logo));
            charList.add(new Characters(plans[15],R.drawable.phonon_logo));
            charList.add(new Characters(plans[16],R.drawable.seth_logo));
            charList.add(new Characters(plans[17],R.drawable.vatista_logo));
            charList.add(new Characters(plans[18],R.drawable.wagner_logo));
            charList.add(new Characters(plans[19],R.drawable.waldstein_logo));
            charList.add(new Characters(plans[20],R.drawable.yuzu_logo));
        }
        else if (game.equals("Melty Blood Type Lumina")) {
            charList.add(new Characters(plans[0], R.drawable.akiha_logo));
            charList.add(new Characters(plans[1], R.drawable.aoko_logo));
            charList.add(new Characters(plans[2], R.drawable.arcueid_logo));
            charList.add(new Characters(plans[3], R.drawable.ciel_logo));
            charList.add(new Characters(plans[4], R.drawable.danoel_logo));
            charList.add(new Characters(plans[5], R.drawable.h_k_logo));
            charList.add(new Characters(plans[6], R.drawable.hisui_logo));
            charList.add(new Characters(plans[7], R.drawable.kohaku_logo));
            charList.add(new Characters(plans[8], R.drawable.kouma_logo));
            charList.add(new Characters(plans[9], R.drawable.mario_logo));
            charList.add(new Characters(plans[10], R.drawable.miyako_logo));
            charList.add(new Characters(plans[11], R.drawable.noel_logo));
            charList.add(new Characters(plans[12], R.drawable.pciel_logo));
            charList.add(new Characters(plans[13], R.drawable.rarc_logo));
            charList.add(new Characters(plans[14], R.drawable.roa_logo));
            charList.add(new Characters(plans[15], R.drawable.saber_logo));
            charList.add(new Characters(plans[16], R.drawable.shinki_logo));
            charList.add(new Characters(plans[17], R.drawable.vlov_logo));
        }
        else if (game.equals("Guilty Gear Strive")){
            charList.add(new Characters(plans[0],R.drawable.anji_logo));
            charList.add(new Characters(plans[1],R.drawable.axl_logo));
            charList.add(new Characters(plans[2],R.drawable.baiken_logo));
            charList.add(new Characters(plans[3],R.drawable.chipp_logo));
            charList.add(new Characters(plans[4],R.drawable.faust_logo));
            charList.add(new Characters(plans[5],R.drawable.giovanna_logo));
            charList.add(new Characters(plans[6],R.drawable.goldlewis_logo));
            charList.add(new Characters(plans[7],R.drawable.happychaos_logo));
            charList.add(new Characters(plans[8],R.drawable.ino_logo));
            charList.add(new Characters(plans[9],R.drawable.jacko_logo));
            charList.add(new Characters(plans[10],R.drawable.ky_logo));
            charList.add(new Characters(plans[11],R.drawable.leo_logo));
            charList.add(new Characters(plans[12],R.drawable.may_logo));
            charList.add(new Characters(plans[13],R.drawable.millia_logo));
            charList.add(new Characters(plans[14],R.drawable.nago_logo));
            charList.add(new Characters(plans[15],R.drawable.pot_logo));
            charList.add(new Characters(plans[16],R.drawable.ram_logo));
            charList.add(new Characters(plans[17],R.drawable.sol_logo));
            charList.add(new Characters(plans[18],R.drawable.testament_logo));
            charList.add(new Characters(plans[19],R.drawable.zato_logo));

        }
        else if (game.equals("Persona 4 Arena Ultimax")){
            charList.add(new Characters(plans[0],R.drawable.adachi_logo));
            charList.add(new Characters(plans[1],R.drawable.aigis_logo));
            charList.add(new Characters(plans[2],R.drawable.akihiko_logo));
            charList.add(new Characters(plans[3],R.drawable.chie_logo));
            charList.add(new Characters(plans[4],R.drawable.elizabeth_logo));
            charList.add(new Characters(plans[5],R.drawable.junpei_logo));
            charList.add(new Characters(plans[6],R.drawable.kanji_logo));
            charList.add(new Characters(plans[7],R.drawable.ken_koro_logo));
            charList.add(new Characters(plans[8],R.drawable.labrys_logo));
            charList.add(new Characters(plans[9],R.drawable.margaret_logo));
            charList.add(new Characters(plans[10],R.drawable.marie_logo));
            charList.add(new Characters(plans[11],R.drawable.minazuki_logo));
            charList.add(new Characters(plans[12],R.drawable.mitsuru_logo));
            charList.add(new Characters(plans[13],R.drawable.naoto_logo));
            charList.add(new Characters(plans[14],R.drawable.rise_logo));
            charList.add(new Characters(plans[15],R.drawable.sho_logo));
            charList.add(new Characters(plans[16],R.drawable.slabrys_logo));
            charList.add(new Characters(plans[17],R.drawable.teddie_logo));
            charList.add(new Characters(plans[18],R.drawable.yosuke_logo));
            charList.add(new Characters(plans[19],R.drawable.yu_logo));
            charList.add(new Characters(plans[20],R.drawable.yukari_logo));
            charList.add(new Characters(plans[21],R.drawable.yukiko_logo));
        }
        else if (game.equals("Demon Slayer Hinokami Chronicles")){
            charList.add(new Characters(plans[0],R.drawable.akaza_logo));
            charList.add(new Characters(plans[1],R.drawable.enmu_logo));
            charList.add(new Characters(plans[2],R.drawable.giyu_logo));
            charList.add(new Characters(plans[3],R.drawable.htanjiro_logo));
            charList.add(new Characters(plans[4],R.drawable.inosuke_logo));
            charList.add(new Characters(plans[5],R.drawable.makomo_logo));
            charList.add(new Characters(plans[6],R.drawable.murata_logo));
            charList.add(new Characters(plans[7],R.drawable.nezuko_logo));
            charList.add(new Characters(plans[8],R.drawable.rengoku_logo));
            charList.add(new Characters(plans[9],R.drawable.rui_logo));
            charList.add(new Characters(plans[10],R.drawable.sabito_logo));
            charList.add(new Characters(plans[11],R.drawable.shinobu_logo));
            charList.add(new Characters(plans[12],R.drawable.susamaru_logo));
            charList.add(new Characters(plans[13],R.drawable.tanjiro_logo));
            charList.add(new Characters(plans[14],R.drawable.tengen_logo));
            charList.add(new Characters(plans[15],R.drawable.uro_logo));
            charList.add(new Characters(plans[16],R.drawable.yahaba_logo));
            charList.add(new Characters(plans[17],R.drawable.yushiro_tamayo_logo));
            charList.add(new Characters(plans[18],R.drawable.zenitsu_logo));
        }
        else if (game.equals("Mortal Kombat 11")){
            charList.add(new Characters(plans[0],R.drawable.baraka_logo));
            charList.add(new Characters(plans[1],R.drawable.cassie_logo));
            charList.add(new Characters(plans[2],R.drawable.cetrion_logo));
            charList.add(new Characters(plans[3],R.drawable.d_vorah_logo));
            charList.add(new Characters(plans[4],R.drawable.erronblack_logo));
            charList.add(new Characters(plans[5],R.drawable.frost_logo));
            charList.add(new Characters(plans[6],R.drawable.fujin_logo));
            charList.add(new Characters(plans[7],R.drawable.geras_logo));
            charList.add(new Characters(plans[8],R.drawable.jacqui_logo));
            charList.add(new Characters(plans[9],R.drawable.jade_logo));
            charList.add(new Characters(plans[10],R.drawable.jax_logo));
            charList.add(new Characters(plans[11],R.drawable.johnny_logo));
            charList.add(new Characters(plans[12],R.drawable.joker_logo));
            charList.add(new Characters(plans[13],R.drawable.kabal_logo));
            charList.add(new Characters(plans[14],R.drawable.kano_logo));
            charList.add(new Characters(plans[15],R.drawable.kitana_logo));
            charList.add(new Characters(plans[16],R.drawable.kollector_logo));
            charList.add(new Characters(plans[17],R.drawable.kotalkhan_logo));
            charList.add(new Characters(plans[18],R.drawable.kunglao_logo));
            charList.add(new Characters(plans[19],R.drawable.liukang_logo));
            charList.add(new Characters(plans[20],R.drawable.mileena_logo));
            charList.add(new Characters(plans[21],R.drawable.nightwolf_logo));
            charList.add(new Characters(plans[22],R.drawable.noobsaibot_logo));
            charList.add(new Characters(plans[23],R.drawable.raiden_logo));
            charList.add(new Characters(plans[24],R.drawable.rain_logo));
            charList.add(new Characters(plans[25],R.drawable.rambo_logo));
            charList.add(new Characters(plans[26],R.drawable.robocob_logo));
            charList.add(new Characters(plans[27],R.drawable.scorpion_logo));
            charList.add(new Characters(plans[28],R.drawable.shangtsung_logo));
            charList.add(new Characters(plans[29],R.drawable.shaokahn_logo));
            charList.add(new Characters(plans[30],R.drawable.sheeva_logo));
            charList.add(new Characters(plans[31],R.drawable.sindel_logo));
            charList.add(new Characters(plans[32],R.drawable.skarlet_logo));
            charList.add(new Characters(plans[33],R.drawable.sonya_logo));
            charList.add(new Characters(plans[34],R.drawable.spawn_logo));
            charList.add(new Characters(plans[35],R.drawable.sub_zero_logo));
            charList.add(new Characters(plans[36],R.drawable.term_logo));
        }
        else if (game.equals("Dragon Ball FighterZ")){
            charList.add(new Characters(plans[0],R.drawable.a16_logo));
            charList.add(new Characters(plans[1],R.drawable.a17_logo));
            charList.add(new Characters(plans[2],R.drawable.a18_logo));
            charList.add(new Characters(plans[3],R.drawable.a21_logo));
            charList.add(new Characters(plans[4],R.drawable.agohan_logo));
            charList.add(new Characters(plans[5],R.drawable.baby_logo));
            charList.add(new Characters(plans[6],R.drawable.bardock_logo));
            charList.add(new Characters(plans[7],R.drawable.beerus_logo));
            charList.add(new Characters(plans[8],R.drawable.bgoku_logo));
            charList.add(new Characters(plans[9],R.drawable.bvegeta_logo));
            charList.add(new Characters(plans[10],R.drawable.cell_logo));
            charList.add(new Characters(plans[11],R.drawable.cooler_logo));
            charList.add(new Characters(plans[12],R.drawable.frieza_logo));
            charList.add(new Characters(plans[13],R.drawable.ginyu_logo));
            charList.add(new Characters(plans[14],R.drawable.goku_logo));
            charList.add(new Characters(plans[15],R.drawable.gokub_logo));
            charList.add(new Characters(plans[16],R.drawable.gotenks_logo));
            charList.add(new Characters(plans[17],R.drawable.gtgoku_logo));
            charList.add(new Characters(plans[18],R.drawable.hit_logo));
            charList.add(new Characters(plans[19],R.drawable.janemba_logo));
            charList.add(new Characters(plans[20],R.drawable.jiren_logo));
            charList.add(new Characters(plans[21],R.drawable.kbuu_logo));
            charList.add(new Characters(plans[22],R.drawable.kefla_logo));
            charList.add(new Characters(plans[23],R.drawable.krillin_logo));
            charList.add(new Characters(plans[24],R.drawable.m21_logo));
            charList.add(new Characters(plans[25],R.drawable.mbuu_logo));
            charList.add(new Characters(plans[26],R.drawable.nappa_logo));
            charList.add(new Characters(plans[27],R.drawable.piccolo_logo));
            charList.add(new Characters(plans[28],R.drawable.roshi_logo));
            charList.add(new Characters(plans[29],R.drawable.ss4gogeta_logo));
            charList.add(new Characters(plans[30],R.drawable.ssbgogeta_logo));
            charList.add(new Characters(plans[31],R.drawable.ssbgoku_logo));
            charList.add(new Characters(plans[32],R.drawable.ssbvegeta_logo));
            charList.add(new Characters(plans[33],R.drawable.superbroly_logo));
            charList.add(new Characters(plans[34],R.drawable.tgohan_logo));
            charList.add(new Characters(plans[35],R.drawable.tien_logo));
            charList.add(new Characters(plans[36],R.drawable.trunks_logo));
            charList.add(new Characters(plans[37],R.drawable.uigoku_logo));
            charList.add(new Characters(plans[38],R.drawable.vegeta_logo));
            charList.add(new Characters(plans[39],R.drawable.vegito_logo));
            charList.add(new Characters(plans[40],R.drawable.videl_logo));
            charList.add(new Characters(plans[41],R.drawable.yamcha_logo));
            charList.add(new Characters(plans[42],R.drawable.zamasu_logo));
            charList.add(new Characters(plans[43],R.drawable.zbroly_logo));
        }
        else if (game.equals("Street Fighter 5")){
            charList.add(new Characters(plans[0],R.drawable.abigail_logo));
            charList.add(new Characters(plans[1],R.drawable.akuma_logo));
            charList.add(new Characters(plans[2],R.drawable.alex_logo));
            charList.add(new Characters(plans[3],R.drawable.balrog_logo));
            charList.add(new Characters(plans[4],R.drawable.birdie_logo));
            charList.add(new Characters(plans[5],R.drawable.blanka_logo));
            charList.add(new Characters(plans[6],R.drawable.cammy_logo));
            charList.add(new Characters(plans[7],R.drawable.chun_li_logo));
            charList.add(new Characters(plans[8],R.drawable.cody_logo));
            charList.add(new Characters(plans[9],R.drawable.dhal_logo));
            charList.add(new Characters(plans[10],R.drawable.ed_logo));
            charList.add(new Characters(plans[11],R.drawable.ehonda_logo));
            charList.add(new Characters(plans[12],R.drawable.falke_logo));
            charList.add(new Characters(plans[13],R.drawable.fang_logo));
            charList.add(new Characters(plans[14],R.drawable.g_logo));
            charList.add(new Characters(plans[15],R.drawable.gill_logo));
            charList.add(new Characters(plans[16],R.drawable.guile_logo));
            charList.add(new Characters(plans[17],R.drawable.ibuki_logo));
            charList.add(new Characters(plans[18],R.drawable.juri_logo));
            charList.add(new Characters(plans[19],R.drawable.kage_logo));
            charList.add(new Characters(plans[20],R.drawable.karin_logo));
            charList.add(new Characters(plans[21],R.drawable.ken_logo));
            charList.add(new Characters(plans[22],R.drawable.kolin_logo));
            charList.add(new Characters(plans[23],R.drawable.laura_logo));
            charList.add(new Characters(plans[24],R.drawable.lucia_logo));
            charList.add(new Characters(plans[25],R.drawable.mbison_logo));
            charList.add(new Characters(plans[26],R.drawable.menat_logo));
            charList.add(new Characters(plans[27],R.drawable.nash_logo));
            charList.add(new Characters(plans[28],R.drawable.nec_logo));
            charList.add(new Characters(plans[29],R.drawable.poison_logo));
            charList.add(new Characters(plans[30],R.drawable.rashid_logo));
            charList.add(new Characters(plans[31],R.drawable.rmika_logo));
            charList.add(new Characters(plans[32],R.drawable.ryu_logo));
            charList.add(new Characters(plans[33],R.drawable.sagat_logo));
            charList.add(new Characters(plans[34],R.drawable.sakura_logo));
            charList.add(new Characters(plans[35],R.drawable.sth_logo));
            charList.add(new Characters(plans[36],R.drawable.urien_logo));
            charList.add(new Characters(plans[37],R.drawable.vega_logo));
            charList.add(new Characters(plans[38],R.drawable.zan_logo));
            charList.add(new Characters(plans[39],R.drawable.zeku_logo));
        }


    }
}