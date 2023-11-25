package com.example.a2502009715_mcs_uas;

import android.widget.ImageButton;

import java.time.LocalDate;

public class history_data {
    private String mainTitle, subMainTitle, date, time, teamA, teamB, id;
    private Integer imageTeamA, imageTeamB;

    public history_data(String mainTitle, String subMainTitle, String date, String time, String teamA, String teamB, Integer imageTeamA, Integer imageTeamB) {
        this.date = date;
        this.mainTitle = mainTitle;
        this.subMainTitle = subMainTitle;
        this.time = time;
        this.teamA = teamA;
        this.teamB = teamB;
        this.imageTeamA = imageTeamA;
        this.imageTeamB = imageTeamB;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getSubMainTitle() {
        return subMainTitle;
    }

    public void setSubMainTitle(String subMainTitle) {
        this.subMainTitle = subMainTitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getImageTeamA() {
        return imageTeamA;
    }

    public void setImageTeamA(Integer imageTeamA) {
        this.imageTeamA = imageTeamA;
    }

    public Integer getImageTeamB() {
        return imageTeamB;
    }

    public void setImageTeamB(Integer imageTeamB) {
        this.imageTeamB = imageTeamB;
    }
}
