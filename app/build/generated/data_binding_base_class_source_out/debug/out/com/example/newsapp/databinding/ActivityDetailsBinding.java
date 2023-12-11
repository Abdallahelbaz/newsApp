// Generated by view binder compiler. Do not edit!
package com.example.newsapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.newsapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDetailsBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView IVDetailNews;

  @NonNull
  public final TextView TVDetailAuthor;

  @NonNull
  public final TextView TVDetailContent;

  @NonNull
  public final TextView TVDetailDetail;

  @NonNull
  public final TextView TVDetailTime;

  @NonNull
  public final TextView TVDetailTitle;

  private ActivityDetailsBinding(@NonNull LinearLayout rootView, @NonNull ImageView IVDetailNews,
      @NonNull TextView TVDetailAuthor, @NonNull TextView TVDetailContent,
      @NonNull TextView TVDetailDetail, @NonNull TextView TVDetailTime,
      @NonNull TextView TVDetailTitle) {
    this.rootView = rootView;
    this.IVDetailNews = IVDetailNews;
    this.TVDetailAuthor = TVDetailAuthor;
    this.TVDetailContent = TVDetailContent;
    this.TVDetailDetail = TVDetailDetail;
    this.TVDetailTime = TVDetailTime;
    this.TVDetailTitle = TVDetailTitle;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_details, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDetailsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.IV_detail_news;
      ImageView IVDetailNews = ViewBindings.findChildViewById(rootView, id);
      if (IVDetailNews == null) {
        break missingId;
      }

      id = R.id.TV_detail_author;
      TextView TVDetailAuthor = ViewBindings.findChildViewById(rootView, id);
      if (TVDetailAuthor == null) {
        break missingId;
      }

      id = R.id.TV_detail_content;
      TextView TVDetailContent = ViewBindings.findChildViewById(rootView, id);
      if (TVDetailContent == null) {
        break missingId;
      }

      id = R.id.TV_detail_detail;
      TextView TVDetailDetail = ViewBindings.findChildViewById(rootView, id);
      if (TVDetailDetail == null) {
        break missingId;
      }

      id = R.id.TV_detail_time;
      TextView TVDetailTime = ViewBindings.findChildViewById(rootView, id);
      if (TVDetailTime == null) {
        break missingId;
      }

      id = R.id.TV_detail_title;
      TextView TVDetailTitle = ViewBindings.findChildViewById(rootView, id);
      if (TVDetailTitle == null) {
        break missingId;
      }

      return new ActivityDetailsBinding((LinearLayout) rootView, IVDetailNews, TVDetailAuthor,
          TVDetailContent, TVDetailDetail, TVDetailTime, TVDetailTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
