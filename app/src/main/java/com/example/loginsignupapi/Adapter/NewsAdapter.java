package com.example.loginsignupapi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginsignupapi.Model.Article;
import com.example.loginsignupapi.Model.News;
import com.example.loginsignupapi.R;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.holder> {
    Context context;
    ArrayList<Article> articleList;

    public NewsAdapter(Context context, ArrayList<Article> articleList) {
        this.context = context;
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public NewsAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custem_news, parent, false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.holder holder, int position) {
        Article article=articleList.get(position);
        holder.title.setText(article.getTitle());
        holder.author.setText(article.getAuthor());
        holder.totalResult.setText(article.g());
        holder.title.setText(article.getTitle());
        holder.title.setText(article.getTitle());
        holder.title.setText(article.getTitle());


        holder.title.setText(news.);
    }

    @Override
    public int getItemCount() {

        return newsList.size();
    }

    public class holder extends RecyclerView.ViewHolder {
        TextView title, id, name, author, status, totalResult;

        public holder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            status = itemView.findViewById(R.id.status);
            totalResult = itemView.findViewById(R.id.tottal_result);
            author = itemView.findViewById(R.id.author);

        }
    }
}
