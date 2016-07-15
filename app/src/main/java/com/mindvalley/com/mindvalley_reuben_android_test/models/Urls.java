package com.mindvalley.com.mindvalley_reuben_android_test.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rjmangubat on 13/07/16.
 */
public class Urls implements Parcelable{
    private String raw;

    private String regular;

    private String full;

    private String thumb;

    private String small;

    protected Urls(Parcel in) {
        raw = in.readString();
        regular = in.readString();
        full = in.readString();
        thumb = in.readString();
        small = in.readString();
    }

    public static final Creator<Urls> CREATOR = new Creator<Urls>() {
        @Override
        public Urls createFromParcel(Parcel in) {
            return new Urls(in);
        }

        @Override
        public Urls[] newArray(int size) {
            return new Urls[size];
        }
    };

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    @Override
    public String toString() {
        return "ClassPojo [raw = " + raw + ", regular = " + regular + ", full = " + full + ", thumb = " + thumb + ", small = " + small + "]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(raw);
        dest.writeString(regular);
        dest.writeString(full);
        dest.writeString(thumb);
        dest.writeString(small);
    }
}