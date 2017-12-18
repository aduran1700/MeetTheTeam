package com.meettheteam.team;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.meettheteam.R;
import com.meettheteam.api.model.Member;
import com.meettheteam.root.App;
import com.meettheteam.teammember.TeamMemberActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamActivity extends AppCompatActivity implements TeamActivityMVP.View, OnListInteractionListener {

    @BindView(R.id.team_list_view)
    RecyclerView recyclerView;

    @Inject
    TeamActivityMVP.Presenter presenter;

    private List<Member> memberList = new ArrayList<>();
    private TeamListAdapter listAdapter;
    private int columnCount = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        ((App) getApplication()).getComponent().inject(this);
        ButterKnife.bind(this);

        listAdapter = new TeamListAdapter(memberList, getApplicationContext(), this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), columnCount);

        recyclerView.setAdapter(listAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setView(this);
        presenter.loadTeamData();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.rxDispose();

    }

    @Override
    public void updateData(Member member) {

        if(memberList.contains(member)) {
            int index = memberList.indexOf(member);
            memberList.add(index, member);
        } else {
            memberList.add(member);
        }
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void onListInteractionListener(int index) {
        Intent intent = new Intent(this, TeamMemberActivity.class);
        intent.putExtra(Member.TEAM_MEMBER, memberList.get(index));
        startActivity(intent);
    }
}
