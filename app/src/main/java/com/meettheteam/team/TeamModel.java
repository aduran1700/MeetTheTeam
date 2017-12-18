package com.meettheteam.team;

import com.meettheteam.api.model.Member;

import io.reactivex.Observable;

public class TeamModel implements TeamActivityMVP.Model {
    private Repository repository;

    public TeamModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<Member> result() {
        return repository.getTeamMembersData();
    }
}
