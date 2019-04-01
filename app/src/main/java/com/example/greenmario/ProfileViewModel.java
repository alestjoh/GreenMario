package com.example.greenmario;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.greenmario.Profile;
import com.example.greenmario.ProfileRepository;

import java.util.List;

public class ProfileViewModel extends AndroidViewModel {

    private ProfileRepository repository;
    private LiveData<List<Profile>> allProfiles;

    public ProfileViewModel(Application application) {
        super(application);
        repository = new ProfileRepository(application);
        allProfiles = repository.getAllProfiles();
    }

    public LiveData<List<Profile>> getAllProfiles() {
        return allProfiles;
    }

    public void insert(Profile profile) {
        repository.insert(profile);
    }
}
