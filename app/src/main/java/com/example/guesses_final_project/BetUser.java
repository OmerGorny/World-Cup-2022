package com.example.guesses_final_project;

import com.google.firebase.database.core.Context;

public class BetUser  {
    Integer id;
    String  matchDate;
    Team home ;
    Team away;
    Integer homeScore;
    Integer awayScore;
    String gameTime;


    public BetUser(){}

    @Override
    public String toString() {
        return "BetUser{" +
                ", id=" + id +
                ", matchDate='" + matchDate + '\'' +
                ", home=" + home.teamName +
                ", away=" + away.teamName +
                ", homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                ", gameTime='" + gameTime + '\'' +
                '}';
    }

    public BetUser(Integer id, String matchDate, Team home, Team away, Integer homeScore, Integer awayScore, String gameTime) {
        this.id = id;
        this.matchDate = matchDate;
        this.home = home;
        this.away = away;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.gameTime = gameTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Integer awayScore) {
        this.awayScore = awayScore;
    }

    public String getGameTime() {
        return gameTime;
    }

    public void setGameTime(String gameTime) {
        this.gameTime = gameTime;
    }
}
