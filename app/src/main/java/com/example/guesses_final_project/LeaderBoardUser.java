package com.example.guesses_final_project;

public class LeaderBoardUser {
    String name;
    int rank;
    int score;

    public LeaderBoardUser(String name, Integer rank,  Integer score)
    {
        this.name=name;
        this.rank=rank;
        this.score=score;
    }

    public String getName() {
        return name;
    }

    public Integer getRank() {
        return rank;
    }

    public Integer getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "LeaderBoardUser{" +
                "name='" + name + '\'' +
                ", rank=" + rank +
                ", score=" + score +
                '}';
    }
}
