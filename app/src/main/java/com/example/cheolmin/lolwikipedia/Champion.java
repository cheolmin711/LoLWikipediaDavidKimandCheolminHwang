package com.example.cheolmin.lolwikipedia;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by cheolminhwang11 on 12/8/17.
 */

public class Champion implements Parcelable{
    private String name, description;
    private ArrayList<Item> items;
    //TODO: make Champion Parcelable

    public Champion(String aatrox, String description, Item item){
        super();
    }

    public String getName() {
        return name;
    }

    public String getDescription(){return description;}


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {this.description = description;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeTypedList(this.items);
    }

    protected Champion(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.items = in.createTypedArrayList(Item.CREATOR);
    }

    public static final Creator<Champion> CREATOR = new Creator<Champion>() {
        @Override
        public Champion createFromParcel(Parcel source) {
            return new Champion(source);
        }

        @Override
        public Champion[] newArray(int size) {
            return new Champion[size];
        }
    };
}
