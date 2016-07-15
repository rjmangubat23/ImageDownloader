package com.mindvalley.com.mindvalley_reuben_android_test.models;

import android.os.Parcel;
import android.os.Parcelable;
/**
 * Created by rjmangubat on 13/07/16.
 */
public class Categories implements Parcelable{
    private String id;

    private String title;

    private Links links;

    private String photo_count;

    protected Categories(Parcel in) {
        id = in.readString();
        title = in.readString();
        photo_count = in.readString();
    }

    public static final Creator<Categories> CREATOR = new Creator<Categories>() {
        @Override
        public Categories createFromParcel(Parcel in) {
            return new Categories(in);
        }

        @Override
        public Categories[] newArray(int size) {
            return new Categories[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getPhoto_count() {
        return photo_count;
    }

    public void setPhoto_count(String photo_count) {
        this.photo_count = photo_count;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", title = " + title + ", links = " + links + ", photo_count = " + photo_count + "]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(photo_count);
    }
}