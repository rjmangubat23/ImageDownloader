package com.mindvalley.com.mindvalley_reuben_android_test.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rjmangubat on 13/07/16.
 */
public class Links implements Parcelable{
    private String photos;

    private String likes;

    private String html;

    private String self;

    protected Links(Parcel in) {
        photos = in.readString();
        likes = in.readString();
        html = in.readString();
        self = in.readString();
    }

    public static final Creator<Links> CREATOR = new Creator<Links>() {
        @Override
        public Links createFromParcel(Parcel in) {
            return new Links(in);
        }

        @Override
        public Links[] newArray(int size) {
            return new Links[size];
        }
    };

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    @Override
    public String toString() {
        return "ClassPojo [photos = " + photos + ", likes = " + likes + ", html = " + html + ", self = " + self + "]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(photos);
        dest.writeString(likes);
        dest.writeString(html);
        dest.writeString(self);
    }
}