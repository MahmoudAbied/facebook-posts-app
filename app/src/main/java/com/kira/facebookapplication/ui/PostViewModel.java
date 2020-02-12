package com.kira.facebookapplication.ui;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kira.facebookapplication.data.PostClient;
import com.kira.facebookapplication.pojo.PostModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostViewModel extends ViewModel {
    MutableLiveData<List<PostModel>> postsMutableLiveData = new MutableLiveData<>();
    //    MutableLiveData<String> posts = new MutableLiveData<>();
    private static final String TAG = "PostViewModel";

    @SuppressLint("CheckResult")
    public void getPosts() {
        Observable<List<PostModel>> observable = PostClient.getINSTANCE().getPosts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());


//        Observer<List<PostModel>> observer = new Observer<List<PostModel>>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(List<PostModel> postModels) {
//                postsMutableLiveData.setValue(postModels);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "onError: " + e);
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };
//        observable.subscribe(observer);

observable.subscribe(o -> postsMutableLiveData.setValue(o),e-> Log.d(TAG, "getPostError: "+e));

    }
}
