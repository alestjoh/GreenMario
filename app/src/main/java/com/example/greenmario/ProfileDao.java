package com.example.greenmario;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ProfileDao {
    @Insert
    void insert(Profile profile);

    @Query("SELECT * from profile_table ORDER BY email ASC")
    LiveData<List<Profile>> getAllProfiles();

    @Query("SELECT * FROM profile_table WHERE email = :match")
    Profile findProfile(String match);

    @Update
    void update(Profile profile);


}
