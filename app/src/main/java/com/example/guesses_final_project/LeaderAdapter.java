package com.example.guesses_final_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class LeaderAdapter extends BaseAdapter {

    Context context;
    List<LeaderBoardUser> listOfLeaders;
    LayoutInflater inflater;

    public LeaderAdapter(Context ctx , List <LeaderBoardUser> leaderLst)
    {
        this.context=ctx;
        this.listOfLeaders=leaderLst;
        inflater=LayoutInflater.from(ctx);




    }
    @Override
    public int getCount() {
        return listOfLeaders.size();
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
        convertView = inflater.inflate(R.layout.leaderboard_row,null    );
        TextView rank = (TextView) convertView.findViewById(R.id.rankLeader);
        TextView name = (TextView) convertView.findViewById(R.id.nameLeader);
        TextView score = (TextView) convertView.findViewById(R.id.scoreLeader);

        rank.setText(listOfLeaders.get(position).getRank().toString());
        name.setText(listOfLeaders.get(position).getName());
        score.setText(listOfLeaders.get(position).getScore().toString());
        return convertView;

    }
}
