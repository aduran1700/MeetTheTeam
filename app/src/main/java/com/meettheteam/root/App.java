package com.meettheteam.root;

import android.app.Application;

import com.meettheteam.api.ApiModuleTeamInfo;
import com.meettheteam.team.TeamModule;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModuleTeamInfo(new ApiModuleTeamInfo())
                .teamModule(new TeamModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}