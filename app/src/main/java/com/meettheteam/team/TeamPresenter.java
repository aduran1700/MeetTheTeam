package com.meettheteam.team;

import com.meettheteam.api.model.Member;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class TeamPresenter implements TeamActivityMVP.Presenter {

    private TeamActivityMVP.View view;
    private TeamActivityMVP.Model model;
    private Disposable disposable;

    public TeamPresenter(TeamActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void loadTeamData() {
        disposable = model.result()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Member>() {
                    @Override
                    public void onNext(Member member) {
                        if (view != null)
                            view.updateData(member);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void rxDispose() {
        if (disposable != null) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }

    }

    @Override
    public void setView(TeamActivityMVP.View view) {
        this.view = view;
    }
}
