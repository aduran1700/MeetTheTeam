package com.meettheteam.team;

import com.meettheteam.api.TeamInfoApi;
import com.meettheteam.api.model.Member;

import io.reactivex.Observable;


public class TeamRepository implements Repository {
    private TeamInfoApi teamInfoApi;

    public TeamRepository(TeamInfoApi teamInfoApi) {
        this.teamInfoApi = teamInfoApi;
    }

    @Override
    public Observable<Member> getTeamMembersData() {
        return teamInfoApi.readJsonFile();
    }
}
