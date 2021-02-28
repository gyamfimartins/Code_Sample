package com.gyamfimartins.sportsresults.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gyamfimartins.sportsresults.R;
import com.gyamfimartins.sportsresults.model.News;
import com.gyamfimartins.sportsresults.viewholder.NewsViewHolder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    private List<News> newsList = new ArrayList<>();

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.singlenews, parent, false);
        return new NewsViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News news = newsList.get(position);

        DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
        String publicationDate = dateFormat.format(news.getPublicationDate());
        String description = news.getDescription();
        holder.textView_description.setText(description);

        if (position == 0) {
            holder.textView_publicationDate.setText(publicationDate);
        } else {
            News previousnews = newsList.get(position - 1);
            String previousDate = dateFormat.format(previousnews.getPublicationDate());
            if (previousDate.equals(publicationDate)) {
                holder.textView_publicationDate.setVisibility(View.GONE);
            } else {
                holder.textView_publicationDate.setVisibility(View.VISIBLE);
                holder.textView_publicationDate.setText(publicationDate);
            }
        }
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public void getnewsList(List<News> newsList) {
        this.newsList = newsList;
        notifyDataSetChanged();
    }
}
