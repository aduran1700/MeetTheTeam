package com.meettheteam.teammember;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.meettheteam.R;
import com.meettheteam.api.model.Member;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamMemberActivity extends AppCompatActivity {

    private static final String EXTRA_IMAGE = "com.meettheteam.teammember.extraImage";
    private static final String EXTRA_TITLE = "com.meettheteam.teammember.extraTitle";

    @BindView(R.id.team_member_image)
    ImageView teamMemberImage;
    @BindView(R.id.team_member_name)
    TextView teamMemberName;
    @BindView(R.id.team_member_title)
    TextView teamMemberTitle;
    @BindView(R.id.team_member_bio)
    TextView teamMemberBio;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_member);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        supportPostponeEnterTransition();

        Member member = getIntent().getExtras().getParcelable(Member.TEAM_MEMBER);


        if(member != null) {
            String name = member.getFirstName() + " " + member.getLastName();
            teamMemberName.setText(name);
            collapsingToolbarLayout.setTitle(name);
            collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
            teamMemberTitle.setText(member.getTitle());
            teamMemberBio.setText(member.getBio());
            Glide.with(this).load(member.getAvatar()).into(teamMemberImage);
        }
    }
}
