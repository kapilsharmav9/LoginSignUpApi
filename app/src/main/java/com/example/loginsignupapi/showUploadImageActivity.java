package com.example.loginsignupapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.loginsignupapi.Adapter.ImageAdapter;
import com.example.loginsignupapi.Model.Images;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class showUploadImageActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageAdapter adapter;
    ArrayList<Images> imageslist;
    LinearLayoutManager linearLayoutManager;
    private String url = "https://mukulyadav222.000webhostapp.com/fetchImage.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_upload_image);
        recyclerView = findViewById(R.id.recyleshowimage);
        recyclerView.setLayoutManager(linearLayoutManager);
        imageslist = new ArrayList<>();
        adapter = new ImageAdapter(imageslist, getApplicationContext());
        recyclerView.setAdapter(adapter);
        fetchImage();
    }

    private void fetchImage() {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    if (success.equals('1')) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            String id = jsonObject.getString("id");
                            String imageurl = jsonObject1.getString("studentProfile");
                            String url = "https://mukulyadav222.000webhostapp.com/studentProfile/"+imageurl;
                            Images images=new Images(id,url);
                            imageslist.add(images);
                            adapter.notifyDataSetChanged();
                            recyclerView.setAdapter(adapter);
                        }

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }
}