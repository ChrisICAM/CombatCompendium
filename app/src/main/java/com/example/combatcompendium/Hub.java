package com.example.combatcompendium;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.combatcompendium.Fragment.CompendiumFragment;
import com.example.combatcompendium.Fragment.CreateFragment;
import com.example.combatcompendium.Fragment.LobbyFragment;
import com.example.combatcompendium.Fragment.MyFeed;
import com.example.combatcompendium.Fragment.ProfileFragment;

import com.example.combatcompendium.databinding.ActivityHubBinding;
import com.flarebit.flarebarlib.FlareBar;
import com.flarebit.flarebarlib.Flaretab;
import com.flarebit.flarebarlib.TabEventObject;

import java.util.ArrayList;


public class Hub extends AppCompatActivity {

    private ActivityHubBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHubBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_hub);

        final FlareBar bottomBar = findViewById(R.id.bottomBar);
        bottomBar.setBarBackgroundColor(Color.parseColor("#FFFFFF"));
        ArrayList<Flaretab> tabs = new ArrayList<>();
        tabs.add(new Flaretab(getResources().getDrawable(R.drawable.home_18),"Feed","#FFECB3"));
        tabs.add(new Flaretab(getResources().getDrawable(R.drawable.e_learning),"Compendium","#80DEEA"));
        tabs.add(new Flaretab(getResources().getDrawable(R.drawable.add_24),"Create","#B39DDB"));
        tabs.add(new Flaretab(getResources().getDrawable(R.drawable.users_alt),"Lobby","#EF9A9A"));
        tabs.add(new Flaretab(getResources().getDrawable(R.drawable.user_20),"Profile","#B2DFDB"));

        bottomBar.setTabList(tabs);
        bottomBar.attachTabs(Hub.this);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new MyFeed());
        transaction.commit();
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_hub);

        bottomBar.setTabChangedListener(new TabEventObject.TabChangedListener() {
            @Override
            public void onTabChanged(LinearLayout selectedTab, int selectedIndex, int oldIndex) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (selectedIndex){
                    case 0:
                        transaction.replace(R.id.container, new MyFeed());
                        break;
                    case 1:
                        transaction.replace(R.id.container, new CompendiumFragment());
                        break;
                    case 2:
                        transaction.replace(R.id.container, new CreateFragment());
                        break;
                    case 3:
                        transaction.replace(R.id.container, new LobbyFragment());
                        break;
                    case 4:
                        transaction.replace(R.id.container, new ProfileFragment());
                        break;
                }
                transaction.commit();
            }
        });



    }
}