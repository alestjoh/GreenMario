package com.example.greenmario;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Profile.class}, version = 1)
public abstract class ProfileRoomDatabase extends RoomDatabase {
    private static volatile ProfileRoomDatabase instance;

    public static ProfileRoomDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (ProfileRoomDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            ProfileRoomDatabase.class,
                            "profile_database").build();
                }
            }
        }
        return instance;
    }

    public abstract ProfileDao profileDao();
}
