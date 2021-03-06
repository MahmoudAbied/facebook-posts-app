package com.kira.facebookapplication.data;


import com.kira.facebookapplication.pojo.PostModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    Observable<List<PostModel>> getPosts();
}