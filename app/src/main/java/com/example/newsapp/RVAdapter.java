package com.example.newsapp;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.databinding.HeadlintListItemsBinding;
import com.example.newsapp.models.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVAViewHolder> {

    List<NewsHeadlines> headlines;
    private SelectListner listner;

    public RVAdapter(List<NewsHeadlines> headlines, SelectListner listner) {
        this.headlines = headlines;
        this.listner = listner;
    }

    @NonNull
    @Override
    public RVAViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RVAViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.headlint_list_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RVAViewHolder holder, int position) {
        holder.bind(position, listner);
    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }

    class RVAViewHolder extends RecyclerView.ViewHolder {

        HeadlintListItemsBinding binding;

        public RVAViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = HeadlintListItemsBinding.bind(itemView);
        }

        void bind(int i, SelectListner listner) {
            binding.TVTitle.setText(headlines.get(i).getTitle());
            binding.TVSource.setText(headlines.get(i).getSource().getName());
            Uri uri=Uri.parse(headlines.get(i).getUrl());
            binding.IVHeadline.setImageURI(uri);
            if (headlines.get(i).getUrlToImage() != null) {
                Picasso.get().load(headlines.get(i).getUrlToImage()).into(binding.IVHeadline);
            }
            binding.CVMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listner.onNewsClicked(headlines.get(i));

                }
            });

        }
    }

    interface onNewsClickListner {
        void onNewsClicked();
    }
}
