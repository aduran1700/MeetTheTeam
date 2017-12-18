package com.meettheteam.api.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Member implements Parcelable {
    public static String TEAM_MEMBER = "com.meettheteam.api.model.Member";

    public static final Parcelable.Creator<Member> CREATOR = new Parcelable.Creator<Member>() {
        @Override
        public Member createFromParcel(Parcel source) {
            return new Member(source);
        }

        @Override
        public Member[] newArray(int size) {
            return new Member[size];
        }
    };
    private String avatar;
    private String bio;
    private String firstName;
    private int id;
    private String lastName;
    private String title;

    public Member() {
    }

    protected Member(Parcel in) {
        this.avatar = in.readString();
        this.bio = in.readString();
        this.firstName = in.readString();
        this.id = in.readInt();
        this.lastName = in.readString();
        this.title = in.readString();
    }

    public String getAvatar() {
        return avatar;
    }

    public String getBio() {
        return bio;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.avatar);
        dest.writeString(this.bio);
        dest.writeString(this.firstName);
        dest.writeInt(this.id);
        dest.writeString(this.lastName);
        dest.writeString(this.title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (id != member.id) return false;
        if (!firstName.equals(member.firstName)) return false;
        return lastName.equals(member.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + id;
        result = 31 * result + lastName.hashCode();
        return result;
    }

}
