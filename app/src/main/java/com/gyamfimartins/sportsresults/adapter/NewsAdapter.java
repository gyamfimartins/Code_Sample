package com.gyamfimartins.sportsresults.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gyamfimartins.sportsresults.R;
import com.gyamfimartins.sportsresults.model.News;
import com.gyamfimartins.sportsresults.viewholder.NewsViewHolder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> implements Filterable {
    private List<News> newsList = new ArrayList<>();
  private final DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
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


        String publicationDate = dateFormat.format(news.getPublicationDate());
        String description = news.getDescription();
        holder.textView_description.setText(description);

        if (position == 0) {
            holder.textView_publicationDate.setText(publicationDate);
            getFilter().filter(publicationDate);
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

    @Override
    public Filter getFilter() {
        return newsFilter;
    }


    private final Filter newsFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<News> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(newsList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (News item : newsList) {

                    String filterdate = dateFormat.format(item.getPublicationDate());
                    if (filterdate.toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            newsList.clear();
            newsList.addAll((List) results.values);
            // refresh the list with filtered data
            notifyDataSetChanged();
        }
    };
}
