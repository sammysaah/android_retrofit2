package com.sans_systems.consumingapidata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sans_systems.RetrofitClient;
import com.sans_systems.adapters.PostAdapter;
import com.sans_systems.api_interface.JSON_API;
import com.sans_systems.modules.Post;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerview;
    private PostAdapter postAdapter;
    private RetrofitClient retrofitClient;
    private List<Post> postList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerview = findViewById(R.id.post_list);
        postList = new ArrayList<>();


        JSON_API json_api = RetrofitClient.getClient("https://jsonplaceholder.typicode.com").create(JSON_API.class);
        Call<List<Post>> postCall = json_api.getPosts();
        postCall.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    List<Post> posts = response.body();
                    for (int i = 0; i < posts.size(); i++) {
                        postList.add(posts.get(i));
                    }
                    postAdapter = new PostAdapter(getApplicationContext(), postList);
                    mRecyclerview.setAdapter(postAdapter);
                    mRecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }
}