package com.meettheteam.root;

import com.meettheteam.api.ApiModuleTeamInfo;
import com.meettheteam.team.TeamActivity;
import com.meettheteam.team.TeamModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModuleTeamInfo.class, TeamModule.class})
public interface ApplicationComponent {
    void inject(TeamActivity target);
}
