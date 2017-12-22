package com.example.cheolmin.lolwikipedia;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cheolminhwang11 on 12/8/17.
 */

public class Champion implements Parcelable{
    private String name, description;
    private int Imageid;
    private Item items1;
    private Item items2;
    private Item items3;
    private Item items4;
    private Item items5;
    private Item items6;

    //TODO: make Champion Parcelable

    public Champion(String namechamp, String desc, Item it1, Item it2, Item it3, Item it4, Item it5, Item it6, int Image){
        name=namechamp;
        description=desc;
        items1=it1;
        items2=it2;
        items3=it3;
        items4=it4;
        items5=it5;
        items6=it6;
        Imageid=Image;


    }

    public String getName() {
        return name;
    }

    public String getDescription(){return description;}

    @Override
    public String toString() {
        return "Champion{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", Imageid=" + Imageid +
                ", items=" + items1 + items2 + items3 + items4 + items5 + items6 +
                '}';
    }

    public Item getItem1(){return items1;}
    public Item getItem2(){return items2;}
    public Item getItem3(){return items3;}
    public Item getItem4(){return items4;}
    public Item getItem5(){return items5;}
    public Item getItem6(){return items6;}



    public int getImageid(){return Imageid;}


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
        dest.writeTypedObject(this.items1, 0);
        dest.writeTypedObject(this.items2, 1);
        dest.writeTypedObject(this.items3, 2);
        dest.writeTypedObject(this.items4, 3);
        dest.writeTypedObject(this.items5, 4);
        dest.writeTypedObject(this.items6, 5);

        dest.writeInt(this.Imageid);
    }

    protected Champion(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.items1 = in.readTypedObject(Item.CREATOR);
        this.items2 = in.readTypedObject(Item.CREATOR);
        this.items3 = in.readTypedObject(Item.CREATOR);
        this.items4 = in.readTypedObject(Item.CREATOR);
        this.items5 = in.readTypedObject(Item.CREATOR);
        this.items6 = in.readTypedObject(Item.CREATOR);

        this.Imageid = in.readInt();
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
