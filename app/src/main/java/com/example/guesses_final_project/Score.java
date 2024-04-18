package com.example.guesses_final_project;

public class Score {
    Integer score;
    String topScorrer;
    String winnigTeam;

    public Score(String winnigTeam, String player) {
        this.score = 0;
        this.topScorrer = player;
        this.winnigTeam = winnigTeam;
    }
    public Score() {}



    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTopScorrer() {
        return topScorrer;
    }

    public void setTopScorrer(String topScorrer) {
        this.topScorrer = topScorrer;
    }

    public String getWinnigTeam() {
        return winnigTeam;
    }

    public void setWinnigTeam(String winnigTeam) {
        this.winnigTeam = winnigTeam;
    }
}
