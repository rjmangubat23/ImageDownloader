package com.mindvalley.com.mindvalley_reuben_android_test.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rjmangubat on 13/07/16.
 */
public class Profile_image implements Parcelable{
    private String small;

    private String large;

    private String medium;

    protected Profile_image(Parcel in) {
        small = in.readString();
        large = in.readString();
        medium = in.readString();
    }

    public static final Creator<Profile_image> CREATOR = new Creator<Profile_image>() {
        @Override
        public Profile_image createFromParcel(Parcel in) {
            return new Profile_image(in);
        }

        @Override
        public Profile_image[] newArray(int size) {
            return new Profile_image[size];
        }
    };

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    @Override
    public String toString() {
        return "ClassPojo [small = " + small + ", large = " + large + ", medium = " + medium + "]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(small);
        dest.writeString(large);
        dest.writeString(medium);
    }
}