package com.example.loginsignupapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class NewsActivity extends AppCompatActivity {
private static final String url="http://newsapi.org/v2/everything?q=bitcoin&from=2020-07-12&sortBy=publishedAt&apiKey=7227eca2dc64418bac0b1b0e1db08aaa";
RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
    }
}