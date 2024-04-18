package com.example.guesses_final_project.ui.home;

import android.os.Bundle;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.guesses_final_project.CustomBaseAdapter;
import com.example.guesses_final_project.Match;
import com.example.guesses_final_project.R;
import com.example.guesses_final_project.Team;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;


public class GamesFragment extends Fragment {
    ListView listView;
    final List<Match> matchesLst =new ArrayList<>();

    ImageButton btnNavBar;
    DrawerLayout mDrawerLayout;
    NavigationView mDrawerList;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_games, container, false);
        listView=(ListView) view.findViewById(R.id.listViewGames);
        MatchsTeamLst();
        CustomBaseAdapter customBaseAdapter =new CustomBaseAdapter(getContext(),matchesLst);
        listView.setAdapter(customBaseAdapter);

        btnNavBar=(ImageButton)view.findViewById(R.id.btnOpenNavBar);
        btnNavBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout=(DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
                mDrawerList=(NavigationView) getActivity().findViewById(R.id.nav_view);
                mDrawerLayout.openDrawer(mDrawerList);

            }
        });






        return view;

    }
    public void MatchsTeamLst() {


        Team qatar = new Team("Qatar", R.drawable.qatar_flag);
        Team germany = new Team("Germany ", R.drawable.germany_flag_icon);
        Team denmark = new Team("Denmark ", R.drawable.denmark_flag_icon);
        Team brazil = new Team("Brazil ", R.drawable.brazil_flag_icon);
        Team france = new Team("France ", R.drawable.france_flag_icon);
        Team belgium = new Team("Belgium ", R.drawable.belgium_flag);
        Team croatia = new Team("Croatia ", R.drawable.croatia_icon);
        Team spain = new Team("Spain ", R.drawable.spain_flag_icon);
        Team serbia = new Team("Serbia ", R.drawable.serbia_flag_icon);
        Team england = new Team("England ", R.drawable.england_flag_icon);
        Team switzerland = new Team("Switzerland ", R.drawable.switzerland_flag_icon);
        Team netherlands = new Team("Netherlands  ", R.drawable.netherland_flag);
        Team argentina = new Team("Argentina ", R.drawable.argentina_flag);
        Team iran = new Team("Iran ", R.drawable.iran_flag);
        Team southKorea = new Team("South Korea", R.drawable.south_korea_icon);
        Team japan = new Team("Japan ", R.drawable.japan_flag_icon);
        Team saudiArabia = new Team("Saudi Arabia", R.drawable.saudi_arabia_flag_icon);
        Team ecuador = new Team("Ecuador ", R.drawable.ecuadorflag);
        Team uruguay = new Team("Uruguay ", R.drawable.uruguay_flag_icon);
        Team canada = new Team("Canada ", R.drawable.canada_flag_icon);
        Team ghana = new Team("Ghana ", R.drawable.ghana_flag_icon);
        Team senegal = new Team("Senegal ", R.drawable.senegal);
        Team portugal = new Team("Portugal", R.drawable.portugal_flag_icon);
        Team poland = new Team("Poland ", R.drawable.poland_flag_icon);
        Team tunisia = new Team("Tunisia ", R.drawable.tunisia_flag_icon);
        Team morocco = new Team("Morocco ", R.drawable.morocco_flag_icon);
        Team cameroon = new Team("Cameroon ", R.drawable.cameroon_flag_icon);
        Team usa = new Team("USA ", R.drawable.united_states);
        Team mexico = new Team("Mexico ", R.drawable.mexico_flag_icon);
        Team wales = new Team("Wales ", R.drawable.wale_flag);
        Team australia = new Team("Australia ", R.drawable.australia_flag);
        Team costaRica = new Team("Costa Rica", R.drawable.costarica_flag_con);





        String firstDay="21/11/2022";
        String secondDay="22/11/2022";
        String thirdDay="23/11/2022";
        String fourthDay="24/11/2022";
        String fifthDay="25/11/2022";
        String sixDay="26/11/2022";
        String sevenDay="27/11/2022";
        String eigthDay="28/11/2022";
        String nineDay="29/11/2022";
        String tenstDay="30/11/2022";
        String elvensDay="01/12/2022";
        String twelvesDay="02/12/2022";

        String twelveAclock="12:00";
        String threeClock="15:00";
        String sixClock="18:00";
        String niceClock="21:00";
        String fiveClock="17:00";



        Match match1= new Match(firstDay ,senegal,netherlands,twelveAclock,1);
        Match match2= new Match(firstDay ,england,iran,threeClock,2);
        Match match3= new Match(firstDay ,qatar,ecuador,sixClock,3);
        Match match4= new Match(firstDay ,usa,wales,niceClock,4);

        Match match5= new Match(secondDay ,argentina,saudiArabia,twelveAclock,5);
        Match match6= new Match(secondDay ,denmark,tunisia,threeClock,6);
        Match match7= new Match(secondDay ,mexico,poland,sixClock,7);
        Match match8= new Match(secondDay ,france,australia,niceClock,8);

        Match match9= new Match(thirdDay ,morocco,croatia,twelveAclock,9);
        Match match10= new Match(thirdDay ,germany,japan,threeClock,10);
        Match match11= new Match(thirdDay ,spain,costaRica,sixClock,11);
        Match match12= new Match(thirdDay ,belgium,canada,niceClock,12);

        Match match13= new Match(fourthDay ,switzerland,cameroon,twelveAclock,13);
        Match match14= new Match(fourthDay ,uruguay,southKorea,threeClock,14);
        Match match15= new Match(fourthDay ,portugal,ghana,sixClock,15);
        Match match16= new Match(fourthDay ,brazil,serbia,niceClock,16);

        Match match17= new Match(fifthDay ,wales,iran,twelveAclock,17);
        Match match18= new Match(fifthDay ,qatar,senegal,threeClock,18);
        Match match19= new Match(fifthDay ,netherlands,ecuador,sixClock,19);
        Match match20= new Match(fifthDay ,england,usa,niceClock,20);

        Match match21= new Match(sixDay ,tunisia,australia,twelveAclock,21);
        Match match22= new Match(sixDay ,poland,saudiArabia,threeClock,22);
        Match match23= new Match(sixDay ,france,denmark,sixClock,23);
        Match match24= new Match(sixDay ,argentina,mexico,niceClock,24);

        Match match25= new Match(sevenDay ,japan,costaRica,twelveAclock,25);
        Match match26= new Match(sevenDay ,belgium,morocco,threeClock,26);
        Match match27= new Match(sevenDay ,croatia,canada,sixClock,27);
        Match match28= new Match(sevenDay ,spain,germany,niceClock,28);

        Match match29= new Match(eigthDay ,cameroon,serbia,twelveAclock,29);
        Match match30= new Match(eigthDay ,southKorea,ghana,threeClock,30);
        Match match31= new Match(eigthDay ,brazil,switzerland,sixClock,31);
        Match match32= new Match(eigthDay ,portugal,uruguay,niceClock,32);

        Match match33= new Match(nineDay ,ecuador,senegal,fiveClock,33);
        Match match34= new Match(nineDay ,netherlands,qatar,fiveClock,34);
        Match match35= new Match(nineDay ,iran,usa,niceClock,35);
        Match match36= new Match(nineDay ,wales,england,niceClock,36);

        Match match37= new Match(tenstDay ,tunisia,france,fiveClock,37);
        Match match38= new Match(tenstDay ,australia,denmark,fiveClock,38);
        Match match39= new Match(tenstDay ,saudiArabia,mexico,niceClock,39);
        Match match40= new Match(tenstDay ,poland,argentina,niceClock,40);

        Match match41= new Match(elvensDay ,canada,morocco,fiveClock,41);
        Match match42= new Match(elvensDay ,croatia,belgium,fiveClock,42);
        Match match43= new Match(elvensDay ,costaRica,germany,niceClock,43);
        Match match44= new Match(elvensDay ,japan,spain,niceClock,44);

        Match match45= new Match(twelvesDay ,southKorea,portugal,fiveClock,45);
        Match match46= new Match(twelvesDay ,ghana,uruguay,fiveClock,46);
        Match match47= new Match(twelvesDay ,cameroon,brazil,niceClock,47);
        Match match48= new Match(twelvesDay ,serbia,switzerland,niceClock,48);


        matchesLst.add(match1);
        matchesLst.add(match2);
        matchesLst.add(match3);
        matchesLst.add(match4);

        matchesLst.add(match5);
        matchesLst.add(match6);
        matchesLst.add(match7);
        matchesLst.add(match8);

        matchesLst.add(match9);
        matchesLst.add(match10);
        matchesLst.add(match11);
        matchesLst.add(match12);

        matchesLst.add(match13);
        matchesLst.add(match14);
        matchesLst.add(match15);
        matchesLst.add(match16);

        matchesLst.add(match17);
        matchesLst.add(match18);
        matchesLst.add(match19);
        matchesLst.add(match20);

        matchesLst.add(match21);
        matchesLst.add(match22);
        matchesLst.add(match23);
        matchesLst.add(match24);

        matchesLst.add(match25);
        matchesLst.add(match26);
        matchesLst.add(match27);
        matchesLst.add(match28);

        matchesLst.add(match29);
        matchesLst.add(match30);
        matchesLst.add(match31);
        matchesLst.add(match32);

        matchesLst.add(match33);
        matchesLst.add(match34);
        matchesLst.add(match35);
        matchesLst.add(match36);

        matchesLst.add(match37);
        matchesLst.add(match38);
        matchesLst.add(match39);
        matchesLst.add(match40);

        matchesLst.add(match41);
        matchesLst.add(match42);
        matchesLst.add(match43);
        matchesLst.add(match44);

        matchesLst.add(match45);
        matchesLst.add(match46);
        matchesLst.add(match47);
        matchesLst.add(match48);



    }

}
