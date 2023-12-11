package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.newsapp.databinding.ActivityMainBinding;
import com.example.newsapp.models.NewsApiResponse;
import com.example.newsapp.models.NewsHeadlines;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListner, View.OnClickListener {

    ActivityMainBinding binding;
    RVAdapter adapter;
    ProgressDialog dialog;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dialog = new ProgressDialog(this);
        dialog.setTitle("News Articles...");
        dialog.show();
        binding.btnBusiness.setOnClickListener(this);
        binding.btnEntertainment.setOnClickListener(this);
        binding.btnGeneral.setOnClickListener(this);
        binding.btnHealth.setOnClickListener(this);
        binding.btnScience.setOnClickListener(this);
        binding.btnSports.setOnClickListener(this);
        binding.btnTechnology.setOnClickListener(this);
        recyclerView=findViewById(R.id.RV_main);


        binding.SVMain.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Searching for your Search News "+query);
                dialog.show();
                RequestManager manager = new RequestManager(getBaseContext());
                manager.getNewsHeadlines(listner, "general", query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listner, "sports", null);

    }

    private final OnDataListner<NewsApiResponse> listner = new OnDataListner<NewsApiResponse>() {
        @Override
        public void onDateClicked(List<NewsHeadlines> list, String message) {

            if(list.isEmpty()){
                Toast.makeText(MainActivity.this, "No News Founded", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
            else {
                showNews(list);
                dialog.dismiss();
            }



        }

        @Override
        public void onError(String message) {

        }
    };

    public void showNews(List<NewsHeadlines> list) {
        adapter = new RVAdapter(list, this);
        binding.RVMain.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        binding.RVMain.setAdapter(adapter);
        binding.RVMain.setHasFixedSize(true);

    }

    @Override
    public void onNewsClicked(NewsHeadlines headlines) {
        startActivity(new Intent(MainActivity.this, DetailsActivity.class)
                .putExtra("data", headlines));
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String category = button.getText().toString();
        dialog.setTitle("Loading news of " + category);
        dialog.show();

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listner, category, null);
    }
}