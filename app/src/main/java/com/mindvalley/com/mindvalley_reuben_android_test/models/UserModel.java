package com.mindvalley.com.mindvalley_reuben_android_test.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rjmangubat on 13/07/16.
 */
public class UserModel implements Parcelable{
    private String id;

    private String height;

    private String[] current_user_collections;

    private String color;

    private Urls urls;

    private String likes;

    private String width;

    private Links links;

    private Categories[] categories;

    private User user;

    private String liked_by_user;

    protected UserModel(Parcel in) {
        id = in.readString();
        height = in.readString();
        current_user_collections = in.createStringArray();
        color = in.readString();
        likes = in.readString();
        width = in.readString();
        liked_by_user = in.readString();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String[] getCurrent_user_collections() {
        return current_user_collections;
    }

    public void setCurrent_user_collections(String[] current_user_collections) {
        this.current_user_collections = current_user_collections;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Categories[] getCategories() {
        return categories;
    }

    public void setCategories(Categories[] categories) {
        this.categories = categories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLiked_by_user() {
        return liked_by_user;
    }

    public void setLiked_by_user(String liked_by_user) {
        this.liked_by_user = liked_by_user;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", height = " + height + ", current_user_collections = " + current_user_collections + ", color = " + color + ", urls = " + urls + ", likes = " + likes + ", width = " + width + ", links = " + links + ", categories = " + categories + ", user = " + user + ", liked_by_user = " + liked_by_user + "]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(height);
        dest.writeStringArray(current_user_collections);
        dest.writeString(color);
        dest.writeString(likes);
        dest.writeString(width);
        dest.writeString(liked_by_user);
    }
}