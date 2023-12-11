package com.example.newsapp;

import com.example.newsapp.models.NewsHeadlines;

import java.util.List;

public interface OnDataListner<NewsApiResponse> {
    void onDateClicked(List<NewsHeadlines> list, String message);
    void onError(String message);
}
