package com.example.guesses_final_project;

public class Team
{
    String teamName;
    Integer flagPhoto;

    public Team(){}

    public Team(String teamName, Integer flagPhoto) {
        this.teamName = teamName;
        this.flagPhoto = flagPhoto;
    }

    public String getTeamName() {
        return teamName;
    }

    public Integer getFlagPhoto() {
        return flagPhoto;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setFlagPhoto(Integer flagPhoto) {
        this.flagPhoto = flagPhoto;
    }
}
