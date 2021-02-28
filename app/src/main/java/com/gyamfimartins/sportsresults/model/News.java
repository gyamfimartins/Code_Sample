package com.gyamfimartins.sportsresults.model;

import java.util.Comparator;
import java.util.Date;

public class News {
    private String description;
    private Date publicationDate;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
}
