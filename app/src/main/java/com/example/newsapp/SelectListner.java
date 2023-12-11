package com.example.newsapp;

import com.example.newsapp.models.NewsHeadlines;

public interface SelectListner {
    void onNewsClicked(NewsHeadlines headlines);
}
