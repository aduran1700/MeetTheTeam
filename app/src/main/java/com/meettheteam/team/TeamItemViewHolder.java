package com.meettheteam.team;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.meettheteam.R;
import com.meettheteam.api.model.Member;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.subjects.PublishSubject;

public class TeamItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.team_member_image)
    ImageView teamMemberImage;
    @BindView(R.id.team_member_name)
    TextView teamMemberName;
    View view;

    public TeamItemViewHolder(View itemView, final OnListInteractionListener listInteractionListener) {
        super(itemView);
        view = itemView;

        ButterKnife.bind(this, view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listInteractionListener.onListInteractionListener(getAdapterPosition());
            }
        });
    }

    public void setView(Member member) {
        Context context = view.getContext();
        String name = member.getFirstName() + " " + member.getLastName();
        teamMemberName.setText(name);
        teamMemberName.setContentDescription(name);

        Glide.with(context).load(member.getAvatar()).into(teamMemberImage);
        teamMemberImage.setContentDescription(context.getString(R.string.team_member_image_desc) + name);
    }
}
