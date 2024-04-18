package com.example.guesses_final_project;

import java.util.concurrent.atomic.AtomicInteger;

public class Match {
    private static final AtomicInteger count=new AtomicInteger(0);
    private final int id;
    String  matchDate;
    Team home ;
    Team away;
    Integer homeScore;
    Integer awayScore;
    String gameTime;




    public Match(String matchDate, Team home, Team away, String gameTime ,Integer id)
    {
        this.matchDate=matchDate;
        this.home=home;
        this.away=away;
        this.gameTime=gameTime;
        this.homeScore=0;
        this.awayScore=0;

        this.id=id;
    }

    public Match(int id) {

        this.id = id;
    }

    public String getGameTime() {
        return gameTime;
    }

    public void setGameTime(String gameTime) {
        this.gameTime = gameTime;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public int getId() {
        return id;
    }



    public Team getAway() {
        return away;
    }

    public Team getHome() {
        return home;
    }

    public void setAway(Team away) {
        this.away = away;
    }


    public void setHome(Team home) {
        this.home = home;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Integer awayScore) {
        this.awayScore = awayScore;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", matchDate='" + matchDate + '\'' +
                ", home=" + home.teamName +
                ", away=" + away.teamName +
                ", homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                ", gameTime='" + gameTime + '\'' +
                '}';
    }
}
