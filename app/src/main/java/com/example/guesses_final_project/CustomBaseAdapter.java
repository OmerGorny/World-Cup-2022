package com.example.guesses_final_project;

import android.content.Context;
import android.graphics.drawable.shapes.Shape;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.ktx.Firebase;

import org.w3c.dom.Text;

import java.util.List;

public class CustomBaseAdapter extends BaseAdapter  {

    Context context;
    List<Match> listOfGames;
    LayoutInflater inflater;
    FirebaseDatabase database;
    DatabaseReference myRef;
    FirebaseAuth mAuth;

    Boolean firstTime=true;




    public CustomBaseAdapter(Context ctx,List<Match> listOfGames){
        this.context=ctx;
        this.listOfGames=listOfGames;
        inflater=LayoutInflater.from(ctx);

    }

    @Override
    public int getCount() {
        return listOfGames.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder mainViewholder=new ViewHolder();
        convertView=inflater.inflate(R.layout.card_item,null);
        mainViewholder.flagLeft=(ImageView) convertView.findViewById(R.id.imageLeft);
        mainViewholder.flagRight=(ImageView) convertView.findViewById(R.id.imageRight);
        mainViewholder.teamLeft=(TextView) convertView.findViewById(R.id.teamLeft);
        mainViewholder.teamRight=(TextView) convertView.findViewById(R.id.teamRight);
        mainViewholder.score_TeamLeft=(TextView)convertView.findViewById(R.id.txt_score_teamLeft);
        mainViewholder.score_TeamRight=(TextView)convertView.findViewById(R.id.txt_score_teamRight);
        mainViewholder.dateGame=(TextView)convertView.findViewById(R.id.date);
        mainViewholder.hourGame=(TextView)convertView.findViewById(R.id.hour);

        //btns
        mainViewholder.score_incrase_teamLeft=(ImageButton)convertView.findViewById(R.id.arrow_up_TeamLeft);
        mainViewholder.score_incrase_teamRight=(ImageButton)convertView.findViewById(R.id.arrow_up_TeamRight);
        mainViewholder.score_decrase_teamLeft=(ImageButton)convertView.findViewById(R.id.arrow_down_TeamLeft);
        mainViewholder.score_decrase_teamRight=(ImageButton)convertView.findViewById(R.id.arrow_down_TeamRight);
        mainViewholder.button=(Button) convertView.findViewById(R.id.btnList);

   // affter sending score the score save on the screen
        mainViewholder.score_TeamLeft.setText(Integer.toString(listOfGames.get(position).homeScore));
        mainViewholder.score_TeamRight.setText(Integer.toString(listOfGames.get(position).awayScore));




////////////////////////////////////////////on click events= /////////////////////////////////////////////////////////////////////

        //score incrase team left
        mainViewholder.score_incrase_teamLeft.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                listOfGames.get(position).setHomeScore(listOfGames.get(position).getHomeScore()+1);
                mainViewholder.score_TeamLeft.setText(Integer.toString(listOfGames.get(position).getHomeScore()));

            }
        });

        //score incrase team right
        mainViewholder.score_incrase_teamRight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                listOfGames.get(position).setAwayScore(listOfGames.get(position).getAwayScore()+1);
                mainViewholder.score_TeamRight.setText(Integer.toString(listOfGames.get(position).getAwayScore()));

            }
        });

        //score decrase team right
        mainViewholder.score_decrase_teamRight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if((listOfGames.get(position).getAwayScore()==0))
                    return;

                listOfGames.get(position).setAwayScore(listOfGames.get(position).getAwayScore()-1);
                mainViewholder.score_TeamRight.setText(Integer.toString(listOfGames.get(position).getAwayScore()));
            }
        });

        //score decrase team Left
        mainViewholder.score_decrase_teamLeft.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if((listOfGames.get(position).getHomeScore()==0))
                    return;
                listOfGames.get(position).setHomeScore(listOfGames.get(position).getHomeScore()-1);
                mainViewholder.score_TeamLeft.setText(Integer.toString(listOfGames.get(position).getHomeScore()));
            }
        });




        mainViewholder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context.getApplicationContext() ,"You Placed a Bet",Toast.LENGTH_SHORT).show();
                database=FirebaseDatabase.getInstance();
                myRef=database.getReference("Users");
                mAuth =  FirebaseAuth.getInstance();
                addNewBet(position);


            }
        });

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





            //צד שמאל
            mainViewholder.flagLeft.setImageResource(listOfGames.get(position).home.getFlagPhoto());
            mainViewholder.teamLeft.setText(listOfGames.get(position).home.getTeamName());

            // תאריכים
            mainViewholder.hourGame.setText(listOfGames.get(position).gameTime);
            mainViewholder.dateGame.setText(listOfGames.get(position).matchDate);

            //צד ימיו
            mainViewholder.flagRight.setImageResource(listOfGames.get(position).away.getFlagPhoto());
            mainViewholder.teamRight.setText(listOfGames.get(position).away.getTeamName());


        convertView.setTag(mainViewholder);
        return convertView;
    }

    private void addNewBet(Integer position) {
        firstTime=true;
        BetUser b=new BetUser();
        b.setHome(listOfGames.get(position).home);
        b.setAway(listOfGames.get(position).away);
        b.setHomeScore(listOfGames.get(position).homeScore);
        b.setAwayScore(listOfGames.get(position).awayScore);
        b.setGameTime(listOfGames.get(position).gameTime.toString());
        b.setMatchDate(listOfGames.get(position).getMatchDate());
        b.setId(listOfGames.get(position).getId());
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(!firstTime)
                    return;


                myRef.child(mAuth.getUid()).child("Bets").child(Integer.toString(b.getId())).setValue(b);


                firstTime=false;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



    private Object getContext() {
        return this.context;
    }


}



class ViewHolder{
    ImageView flagLeft;
    ImageView flagRight;
    ImageButton score_incrase_teamLeft;
    ImageButton score_incrase_teamRight;
    ImageButton score_decrase_teamLeft;
    ImageButton score_decrase_teamRight;
    ImageButton delBtn;
    TextView score_TeamLeft;
    TextView score_TeamRight;
    TextView teamLeft;
    TextView teamRight;
    TextView dateGame;
    TextView hourGame;
    TextView score;
    Button button;

}
