package com.gyamfimartins.sportsresults.repository;


import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonObject;
import com.gyamfimartins.sportsresults.api.SportApi;
import com.gyamfimartins.sportsresults.model.F1Result;
import com.gyamfimartins.sportsresults.model.NBAResult;
import com.gyamfimartins.sportsresults.model.News;
import com.gyamfimartins.sportsresults.model.Sport;
import com.gyamfimartins.sportsresults.model.TennisResult;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsRepository {
    private String DATE_FORMAT = "MMM dd yyyy HH:mm:ss a";

    public NewsRepository() {

    }

    public LiveData<List<News>> getNews() {
        final MutableLiveData<List<News>> data = new MutableLiveData<>();
        final List<News> newsList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ancient-wood-1161.getsandbox.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SportApi sportApi = retrofit.create(SportApi.class);
        Call<Sport> call = sportApi.getSportResults();

        call.enqueue(new Callback<Sport>() {
            @Override
            public void onResponse(Call<Sport> call, Response<Sport> response) {
                if (!response.isSuccessful()) {
                    String code = "code: " + response.code();
                    return;
                }

                Sport sport = response.body();

                //formula one resuts
                List<F1Result> f1Results = sport.getF1Results();
                for (int i = 0; i < f1Results.size(); i++) {
                    News news = new News();
                    Date publicationDate = f1Results.get(i).getPublicationDate();
                    String tournament = f1Results.get(i).getTournament();
                    String winner = f1Results.get(i).getWinner();
                    String seconds = f1Results.get(i).getSeconds();
                    String description = winner + " wins " + tournament + " by " + seconds + " seconds";
                    news.setDescription(description);
                    news.setPublicationDate(publicationDate);
                    newsList.add(news);
                }

                //NBA result
                List<NBAResult> nbaResults = sport.getNbaResults();
                for (int n = 0; n < nbaResults.size(); n++) {
                    News news = new News();
                    Date publicationDate = nbaResults.get(n).getPublicationDate();
                    String mvp = nbaResults.get(n).getMvp();
                    String tournament = nbaResults.get(n).getTournament();
                    String winner = nbaResults.get(n).getWinner();
                    String gameNumber = nbaResults.get(n).getGameNumber();
                    String description = mvp + " leads " + winner + " to game " + gameNumber + " win in the " + tournament;
                    news.setDescription(description);
                    news.setPublicationDate(publicationDate);
                    newsList.add(news);
                }

                //Tennis result
                List<TennisResult> tennisResults = sport.getTennis();
                for (int t = 0; t < tennisResults.size(); t++) {
                    News news = new News();
                    String looser = tennisResults.get(t).getLooser();
                    Date publicationDate = tennisResults.get(t).getPublicationDate();
                    String tournament = tennisResults.get(t).getTournament();
                    String winner = tennisResults.get(t).getWinner();
                    String numberOfSets = tennisResults.get(t).getNumberOfSets();
                    String description = tournament + ": " + winner + " wins against " + looser + " in " + numberOfSets + " sets";
                    news.setDescription(description);
                    news.setPublicationDate(publicationDate);
                    newsList.add(news);
                }

                Collections.sort(newsList, new Comparator<News>() {
                    public int compare(News d1, News d2) {
                        return Long.valueOf(d2.getPublicationDate().getTime()).compareTo(d1.getPublicationDate().getTime());
                    }
                });
                data.setValue(newsList);
            }

            @Override
            public void onFailure(Call<Sport> call, Throwable t) {

            }
        });


        return data;
    }


}
