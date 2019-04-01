package com.example.greenmario;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

@Entity(tableName = "profile_table")
public class Profile implements Parcelable {
    @PrimaryKey
    @NonNull
    public String email = "";

    public String password = "";

    public String name = "";

    public String username = "";

    public String imgName = "";

    public String country = "";

    public int age = 0;

    public String birthDate = "";

    public String gender = "";

    public String address = "";

    public Profile() { }

    public Profile(Profile p) {
        email = p.email;
        password = p.password;
        name = p.name;
        username = p.username;
        imgName = p.imgName;
        country = p.country;
        age = p.age;
        birthDate = p.birthDate;
        gender = p.gender;
        address = p.address;

        if (email == null) {
            username = "EMAIL WAS NULL";
            email = "1234";
        } else if (email.isEmpty()) {
            username = "EMAIL WAS EMPTY";
            email = "1234";
        }
    }

    public Profile(Parcel in) {
        email = in.readString();
        password = in.readString();
        name = in.readString();
        username = in.readString();
        imgName = in.readString();
        country = in.readString();
        age = in.readInt();
        birthDate = in.readString();
        gender = in.readString();
        address = in.readString();
    }

    public static final Creator<Profile> CREATOR = new Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(name);
        dest.writeString(username);
        dest.writeString(imgName);
        dest.writeString(country);
        dest.writeInt(age);
        dest.writeString(birthDate);
        dest.writeString(gender);
        dest.writeString(address);
    }
}
