package com.example.guesses_final_project.ui.profile;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.guesses_final_project.BetUser;
import com.example.guesses_final_project.CustomBaseAdapterProfile;
import com.example.guesses_final_project.R;
import com.example.guesses_final_project.Score;
import com.example.guesses_final_project.Team;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {

    ListView listView;
    List<BetUser> userBetsList =new ArrayList<>();
    Context context;
    Boolean firstTime=true,firstTime2=true;
    String score,player,country;
    TextView scoreProfile,winningTeamProfile,playerProfile;
    ImageView countryImg;
    ImageButton btnNavBar;
    DrawerLayout mDrawerLayout;
    NavigationView mDrawerList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);
        listView=(ListView) view.findViewById(R.id.listViewProfile);
        FirebaseAuth mAuth =  FirebaseAuth.getInstance();
        scoreProfile=view.findViewById(R.id.profileScore);
        countryImg=view.findViewById(R.id.countryImage);
        playerProfile=view.findViewById(R.id.topScoreer);

        btnNavBar=(ImageButton)view.findViewById(R.id.btnOpenNavBar);
        btnNavBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout=(DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
                mDrawerList=(NavigationView) getActivity().findViewById(R.id.nav_view);
                mDrawerLayout.openDrawer(mDrawerList);

            }
        });




        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users").child(mAuth.getUid()).child("Score");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(!firstTime2)
                    return;
                Score s =  snapshot.getValue(Score.class);
                if (s==null)
                    return;
                Team teamImg = MatchTeamNameToPhoto(s.getWinnigTeam());
                int totalscore=s.getScore();
                 player=s.getTopScorrer();
                countryImg.setImageResource(teamImg.getFlagPhoto());



                score=String.valueOf(totalscore);
                scoreProfile.setText(score);
                playerProfile.setText(player);
                firstTime2=false;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





        DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference().child("Users").child(mAuth.getUid()).child("Bets");
        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(!firstTime)
                    return;

                userBetsList.clear();
                for(DataSnapshot snap :snapshot.getChildren()){

                    BetUser m = snap.getValue(BetUser.class);
                    userBetsList.add(m);
                    Log.i("fireBase",m.toString());


                }






                CustomBaseAdapterProfile customBaseAdapterProfile =new CustomBaseAdapterProfile(getContext(),userBetsList);
                listView.setAdapter(customBaseAdapterProfile);
                customBaseAdapterProfile.notifyDataSetChanged();

                firstTime=false;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





        return view;
    }

    private Team MatchTeamNameToPhoto(String country)
    { Team qatar = new Team("Qatar", R.drawable.qatar_flag);
        Team germany = new Team("Germany", R.drawable.germany_flag_icon);
        Team denmark = new Team("Denmark", R.drawable.denmark_flag_icon);
        Team brazil = new Team("Brazil", R.drawable.brazil_flag_icon);
        Team france = new Team("France", R.drawable.france_flag_icon);
        Team belgium = new Team("Belgium", R.drawable.belgium_flag);
        Team croatia = new Team("Croatia", R.drawable.croatia_icon);
        Team spain = new Team("Spain", R.drawable.spain_flag_icon);
        Team serbia = new Team("Serbia", R.drawable.serbia_flag_icon);
        Team england = new Team("England", R.drawable.england_flag_icon);
        Team switzerland = new Team("Switzerland", R.drawable.switzerland_flag_icon);
        Team netherlands = new Team("Netherlands", R.drawable.netherland_flag);
        Team argentina = new Team("Argentina", R.drawable.argentina_flag);
        Team iran = new Team("Iran", R.drawable.iran_flag);
        Team southKorea = new Team("South Korea", R.drawable.south_korea_icon);
        Team japan = new Team("Japan", R.drawable.japan_flag_icon);
        Team saudiArabia = new Team("Saudi Arabia", R.drawable.saudi_arabia_flag_icon);
        Team ecuador = new Team("Ecuador", R.drawable.ecuadorflag);
        Team uruguay = new Team("Uruguay", R.drawable.uruguay_flag_icon);
        Team canada = new Team("Canada", R.drawable.canada_flag_icon);
        Team ghana = new Team("Ghana", R.drawable.ghana_flag_icon);
        Team senegal = new Team("Senegal", R.drawable.senegal);
        Team portugal = new Team("Portugal", R.drawable.portugal_flag_icon);
        Team poland = new Team("Poland", R.drawable.poland_flag_icon);
        Team tunisia = new Team("Tunisia", R.drawable.tunisia_flag_icon);
        Team morocco = new Team("Morocco", R.drawable.morocco_flag_icon);
        Team cameroon = new Team("Cameroon", R.drawable.cameroon_flag_icon);
        Team usa = new Team("USA", R.drawable.united_states);
        Team mexico = new Team("Mexico", R.drawable.mexico_flag_icon);
        Team wales = new Team("Wales", R.drawable.wale_flag);
        Team australia = new Team("Australia", R.drawable.australia_flag);
        Team costaRica = new Team("Costa Rica", R.drawable.costarica_flag_con);

        ArrayList<Team> countryLst = new ArrayList<>();
        countryLst.add(qatar);
        countryLst.add(germany);
        countryLst.add(denmark);
        countryLst.add(brazil);
        countryLst.add(france);
        countryLst.add(belgium);
        countryLst.add(croatia);
        countryLst.add(spain);
        countryLst.add(senegal);
        countryLst.add(serbia);
        countryLst.add(ecuador);
        countryLst.add(england);
        countryLst.add(switzerland);
        countryLst.add(netherlands);
        countryLst.add(argentina);
        countryLst.add(iran);
        countryLst.add(southKorea);
        countryLst.add(japan);
        countryLst.add(saudiArabia);
        countryLst.add(uruguay);
        countryLst.add(canada);
        countryLst.add(ghana);
        countryLst.add(portugal);
        countryLst.add(poland);
        countryLst.add(tunisia);
        countryLst.add(morocco);
        countryLst.add(cameroon);
        countryLst.add(usa);
        countryLst.add(mexico);
        countryLst.add(wales);
        countryLst.add(australia);
        countryLst.add(costaRica);

        for(Team team :countryLst)
        {
            String countryName= team.getTeamName();
            if (countryName.matches(country))
            {

                Team teamToReturn = team;
                return teamToReturn;
            }



        }
        return null;
    }
}