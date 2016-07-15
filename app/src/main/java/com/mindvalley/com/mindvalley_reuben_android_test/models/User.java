package com.mindvalley.com.mindvalley_reuben_android_test.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rjmangubat on 13/07/16.
 */
public class User implements Parcelable{
    private String id;

    private String username;

    private Profile_image profile_image;

    private String name;

    private Links links;

    protected User(Parcel in) {
        id = in.readString();
        username = in.readString();
        profile_image = in.readParcelable(Profile_image.class.getClassLoader());
        name = in.readString();
        links = in.readParcelable(Links.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Profile_image getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(Profile_image profile_image) {
        this.profile_image = profile_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", username = " + username + ", profile_image = " + profile_image + ", name = " + name + ", links = " + links + "]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(username);
        dest.writeParcelable(profile_image, flags);
        dest.writeString(name);
        dest.writeParcelable(links, flags);
    }
}