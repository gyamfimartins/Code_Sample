package com.gyamfimartins.sportsresults.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.gyamfimartins.sportsresults.model.News;
import com.gyamfimartins.sportsresults.repository.NewsRepository;
import java.util.List;

public class NewsViewModel extends AndroidViewModel {
    private NewsRepository newsRepository;

    public NewsViewModel(@NonNull Application application) {
        super(application);
        newsRepository = new NewsRepository();
    }

    public LiveData<List<News>> getAllNews() {
        return newsRepository.getNews();
    }
}
