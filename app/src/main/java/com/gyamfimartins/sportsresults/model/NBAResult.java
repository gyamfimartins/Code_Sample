package com.gyamfimartins.sportsresults.model;

import java.util.Date;

public class NBAResult {
    private String looser, mvp, tournament, winner, gameNumber;
    private Date publicationDate;


    public String getLooser() {
        return looser;
    }

    public String getMvp() {
        return mvp;
    }

    public String getTournament() {
        return tournament;
    }

    public String getWinner() {
        return winner;
    }

    public String getGameNumber() {
        return gameNumber;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }
}
