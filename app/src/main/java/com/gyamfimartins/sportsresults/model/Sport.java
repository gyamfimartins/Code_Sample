package com.gyamfimartins.sportsresults.model;


import java.util.ArrayList;


public class Sport {
    private ArrayList<F1Result> f1Results;

   private ArrayList<NBAResult> nbaResults;

    private ArrayList<TennisResult> Tennis;

    public Sport(ArrayList<F1Result> f1Results, ArrayList<NBAResult> nbaResults, ArrayList<TennisResult> tennis) {
        this.f1Results = f1Results;
        this.nbaResults = nbaResults;
        Tennis = tennis;

    }

    public ArrayList<F1Result> getF1Results() {
        return f1Results;
    }

    public ArrayList<NBAResult> getNbaResults() {
        return nbaResults;
    }

    public ArrayList<TennisResult> getTennis() {
        return Tennis;
    }
}
