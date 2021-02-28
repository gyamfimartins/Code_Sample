package com.gyamfimartins.sportsresults.model;

import java.util.Date;

public class TennisResult {
    private String looser, tournament, winner, numberOfSets;
    private Date publicationDate;


    public String getLooser() {
        return looser;
    }

    public String getTournament() {
        return tournament;
    }

    public String getWinner() {
        return winner;
    }

    public String getNumberOfSets() {
        return numberOfSets;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }
}
