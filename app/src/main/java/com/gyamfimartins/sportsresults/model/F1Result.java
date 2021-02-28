package com.gyamfimartins.sportsresults.model;

import java.util.Date;

public class F1Result {
    private String tournament, winner, seconds;
    private Date publicationDate;

    public String getTournament() {
        return tournament;
    }

    public String getWinner() {
        return winner;
    }

    public String getSeconds() {
        return seconds;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }
}
