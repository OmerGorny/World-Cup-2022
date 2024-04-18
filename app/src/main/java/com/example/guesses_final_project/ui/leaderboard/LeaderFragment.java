package com.example.guesses_final_project.ui.leaderboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.guesses_final_project.LeaderAdapter;
import com.example.guesses_final_project.LeaderBoardUser;
import com.example.guesses_final_project.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class LeaderFragment extends Fragment {
    ListView listView;
    final List<LeaderBoardUser> leaderLst =new ArrayList<>();
    Integer score;
    String name;
    ImageButton btnNavBar;
    DrawerLayout mDrawerLayout;
    NavigationView mDrawerList;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_leader, container, false);

        btnNavBar=(ImageButton)view.findViewById(R.id.btnOpenNavBar);
        btnNavBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout=(DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
                mDrawerList=(NavigationView) getActivity().findViewById(R.id.nav_view);
                mDrawerLayout.openDrawer(mDrawerList);

            }
        });


        DatabaseReference reference = (DatabaseReference) FirebaseDatabase.getInstance().getReference().child("Users");
        reference.addValueEventListener(new ValueEventListener()


        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int i = 0;
                LeaderBoardUser [] arrToSort = new LeaderBoardUser[(int) snapshot.getChildrenCount()];
                for(DataSnapshot snap :snapshot.getChildren()){


                    score= snap.child("Score").child("score").getValue(Integer.class);
                    name= snap.child("User").child("fullName").getValue(String.class);
                    LeaderBoardUser userToadd=new LeaderBoardUser ( name, 0 ,score);
                    arrToSort[i]=userToadd;
                    i++;


                }

                if (arrToSort==null){return;}
                BubbleSort(arrToSort);


                for (int t = 0; t <arrToSort.length ; t++) {
                    arrToSort[t].setRank(t+1);
                    leaderLst.add(arrToSort[t]);

                }
                listView=   (ListView) view.findViewById(R.id.listViewLeader);
                LeaderAdapter leaderboardAdapter =new LeaderAdapter(getContext(),leaderLst);
                listView.setAdapter(leaderboardAdapter);




            }






            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });
        return  view;







    }
    public void BubbleSort(LeaderBoardUser  [] arrToSort) {

        if (arrToSort==null )
            return;




        int n = arrToSort.length;
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(arrToSort[j-1].getScore() < arrToSort[j].getScore()){
                    //swap elements
                    temp = arrToSort[j-1].getScore();
                    arrToSort[j-1].setScore(arrToSort[j].getScore());
                    arrToSort[j].setScore(temp);
                }

            }
        }


    }

}
