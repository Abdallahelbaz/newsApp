package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.example.newsapp.databinding.ActivityDetailsBinding;
import com.example.newsapp.models.NewsHeadlines;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    NewsHeadlines headlines;
    ActivityDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        headlines= (NewsHeadlines) getIntent().getSerializableExtra("data");
        binding.TVDetailTitle.setText(headlines.getTitle());
        binding.TVDetailAuthor.setText(headlines.getAuthor());
        binding.TVDetailTime.setText(headlines.getPublishedAt());
        binding.TVDetailDetail.setText(headlines.getDescription());
        binding.TVDetailContent.setText(headlines.getContent());

        binding.IVDetailNews.setImageURI(Uri.parse(headlines.getUrl()));
        Picasso.get().load(headlines.getUrlToImage()).into(binding.IVDetailNews);
    }
}