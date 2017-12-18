package com.meettheteam.team;

import com.meettheteam.api.TeamInfoApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TeamModule {

    @Provides
    public TeamActivityMVP.Presenter provideTeamActivityPresenter(TeamActivityMVP.Model teamModel) {
        return new TeamPresenter(teamModel);
    }

    @Provides
    public TeamActivityMVP.Model provideTeamActivityModel(Repository repository) {
        return new TeamModel(repository);
    }

    @Singleton
    @Provides
    public Repository provideRepository(TeamInfoApi teamInfoApi) {
        return new TeamRepository(teamInfoApi);
    }


}
