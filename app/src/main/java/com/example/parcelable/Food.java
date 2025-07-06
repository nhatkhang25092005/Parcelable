package com.example.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Food implements Parcelable {

    private String name;
    private int image;
    private String desciption;
    double price;

    public Food(String name, int image, String desciption, double price) {
        this.name = name;
        this.image = image;
        this.desciption = desciption;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getDesciption() {
        return desciption;
    }

    public double getPrice() {
        return price;
    }

    protected Food(Parcel in) {
        name = in.readString();
        image = in.readInt();
        desciption = in.readString();
        price = in.readDouble();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(image);
        dest.writeString(desciption);
        dest.writeDouble(price);
    }
}
