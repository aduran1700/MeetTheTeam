package com.meettheteam.team;

import com.meettheteam.api.model.Member;

import io.reactivex.Observable;


public interface Repository {
    Observable<Member> getTeamMembersData();
}
