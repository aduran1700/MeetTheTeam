package com.meettheteam.api;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.meettheteam.R;
import com.meettheteam.api.model.Member;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;


public class TeamInfoApi {

    private Context context;
    private List<Member> members;

    public TeamInfoApi(Context context) {
        this.context = context;
        members = new ArrayList<>();

    }

    public Observable<Member> readJsonFile() {
        InputStream inputStream = context.getResources().openRawResource(R.raw.team);

        InputStreamReader inputreader = new InputStreamReader(inputStream);
        BufferedReader buffreader = new BufferedReader(inputreader);

        Gson gson = new Gson();
        members = gson.fromJson(buffreader, new TypeToken<List<Member>>() {
        }.getType());

        return Observable.fromIterable(members);
    }
}
