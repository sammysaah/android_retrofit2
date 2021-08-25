package com.sans_systems.api_interface;

import com.sans_systems.modules.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSON_API {

    @GET("/posts")
    Call<List<Post>> getPosts();
}
