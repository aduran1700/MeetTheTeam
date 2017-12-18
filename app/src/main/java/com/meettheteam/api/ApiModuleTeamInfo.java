package com.meettheteam.api;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ApiModuleTeamInfo {
    @Provides
    public TeamInfoApi provideApiService(Context context) {
        return new TeamInfoApi(context);
    }
}
