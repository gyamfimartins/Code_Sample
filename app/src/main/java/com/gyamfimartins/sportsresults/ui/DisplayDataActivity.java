package com.gyamfimartins.sportsresults.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import com.gyamfimartins.sportsresults.R;
import com.gyamfimartins.sportsresults.adapter.NewsAdapter;
import com.gyamfimartins.sportsresults.model.News;
import com.gyamfimartins.sportsresults.util.SimpleDividerItemDecoration;
import com.gyamfimartins.sportsresults.viewmodel.NewsViewModel;

import java.util.List;

public class DisplayDataActivity extends AppCompatActivity {
    private RecyclerView rvnews;
    private NewsViewModel newsViewModel;
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        rvnews = findViewById(R.id.rvnews);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvnews.setHasFixedSize(true);
        rvnews.setLayoutManager(linearLayoutManager);
        rvnews.addItemDecoration(new SimpleDividerItemDecoration(this));

        newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);
        newsAdapter = new NewsAdapter();
        getnews();
    }


    private void getnews() {
        newsViewModel.getAllNews().observe(this, new Observer<List<News>>() {
            @Override
            public void onChanged(List<News> news) {
                newsAdapter.getnewsList(news);
                rvnews.setAdapter(newsAdapter);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        //Initialize SearchView
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // filter recycler view when text is changed
                newsAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }



}