package com.gyamfimartins.sportsresults.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gyamfimartins.sportsresults.R;

public class NewsViewHolder extends RecyclerView.ViewHolder {
    public TextView textView_publicationDate,textView_description;
    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_publicationDate = itemView.findViewById(R.id.textView_publicationDate);
        textView_description = itemView.findViewById(R.id.textView_description);
    }
}

