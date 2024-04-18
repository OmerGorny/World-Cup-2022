package com.example.guesses_final_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminActivity extends AppCompatActivity   {

    EditText idInput,homeScoreInput,awayScoreInput;
    Button btnSend,btnReSend;
    Boolean firstTime=true;



    User user;
    Integer totalScore=0,counterUsers=0;
    String id,homeScore,awayScore;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        idInput=findViewById(R.id.idField);
        homeScoreInput=findViewById(R.id.HomeTeamScore);
        awayScoreInput=findViewById(R.id.AwayTeamScore);
        btnSend=findViewById(R.id.btnSendScore);
        btnReSend=findViewById(R.id.btnReSendScore);
        btnReSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstTime=true;
                counterUsers=0;
                idInput.getText().clear();
                homeScoreInput.getText().clear();
                awayScoreInput.getText().clear();
            }

        });
        btnSend.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                FirebaseAuth mAuth =  FirebaseAuth.getInstance();
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override

                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        id=idInput.getText().toString();
                        homeScore=homeScoreInput.getText().toString();
                        awayScore=awayScoreInput.getText().toString();
                        int homeScoreInt=Integer.parseInt(homeScore);
                        int awayScoreInt=Integer.parseInt(awayScore);
                        String uIDuser="";
                        Integer scoreAway,scoreHome,scoreUser;

                        if(!firstTime)
                            return;

                        for(DataSnapshot snap :snapshot.getChildren()) {

                            if(snap.getValue().toString().contains("Bets")) {

                                if(snap.child("Bets").child(id).getValue()!=null) {
                                    counterUsers++;

                                    scoreAway = snap.child("Bets").child(id).child("awayScore").getValue(Integer.class);
                                    scoreHome = snap.child("Bets").child(id).child("homeScore").getValue(Integer.class);
                                    scoreUser = snap.child("Score").child("score").getValue(Integer.class);
                                    uIDuser = snap.getKey();


                                    if (scoreAway == awayScoreInt && scoreHome == homeScoreInt) {
                                        totalScore = 3 + scoreUser;
                                        reference.child(uIDuser).child("Score").child("score").setValue(totalScore);
                                    }
                                    if (homeScoreInt > awayScoreInt && scoreHome > scoreAway) {
                                        totalScore = 1 + scoreUser;
                                        reference.child(uIDuser).child("Score").child("score").setValue(totalScore);
                                    }
                                    if (homeScoreInt < awayScoreInt && scoreHome < scoreAway) {
                                        totalScore = 1 + scoreUser;
                                        reference.child(uIDuser).child("Score").child("score").setValue(totalScore);
                                    }
                                    if (homeScoreInt == awayScoreInt && scoreHome == scoreAway) {
                                        totalScore = 1 + scoreUser;
                                        reference.child(uIDuser).child("Score").child("score").setValue(totalScore);
                                    }
                                }

                            }
                        }

                        Toast.makeText(AdminActivity.this, "number of users that bet on this game is:"+counterUsers,
                                Toast.LENGTH_SHORT).show();
                        firstTime=false;

//                        for(DataSnapshot snap :snapshot.getChildren()){
//                            if(snap.getValue().toString().contains("Bets")) {
//                                for (int i = 0; i < len; i++) {
//                                    String s=snap.child("Bets").getValue().toString();
//
//
//                                  Toast.makeText(AdminActivity.this,s ,
//                                            Toast.LENGTH_LONG).show();
//
//
//
//                                  //  Log.i("FireBase",snap.child(uIDList.remove(i)).child("Bets").getValue().toString());
//                                   // betList.add(b);
////                                    String awayScroe = snap.child(uIDList.remove(i)).child("Bets").child("awayScore").getValue().toString();
////                                    String homeScore = snap.child(uIDList.remove(i)).child("Bets").child("homeScore").getValue().toString();
//                                }
//                            }
//
//                        }


                        //אין הימור לאו

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });








            }




        });




    }


}