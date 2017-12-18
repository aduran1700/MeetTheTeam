package com.meettheteam.team;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meettheteam.R;
import com.meettheteam.api.model.Member;

import java.util.List;

import io.reactivex.Observable;


public class TeamListAdapter extends RecyclerView.Adapter<TeamItemViewHolder> {

    private Context context;
    private final OnListInteractionListener onListInteractionListener;
    private List<Member> list;


    public TeamListAdapter(List<Member> list, Context context, OnListInteractionListener onListInteractionListener) {
        this.list = list;
        this.context = context;
        this.onListInteractionListener = onListInteractionListener;
    }

    @Override
    public TeamItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.team_member_row, parent, false);
        return new TeamItemViewHolder(itemView, onListInteractionListener);
    }

    @Override
    public void onBindViewHolder(TeamItemViewHolder holder, int position) {
        holder.setView(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
