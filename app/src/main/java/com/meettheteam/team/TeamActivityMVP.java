package com.meettheteam.team;


import com.meettheteam.api.model.Member;

import io.reactivex.Observable;


public interface TeamActivityMVP {
    interface View {
        void updateData(Member member);

    }

    interface Presenter {
        void loadTeamData();
        void rxDispose();
        void setView(TeamActivityMVP.View view);
    }

    interface Model {
        Observable<Member> result();
    }
}
