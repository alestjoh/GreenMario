package com.example.greenmario;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class ProfileRepository {
    private ProfileDao profileDao;
    private LiveData<List<Profile>> allProfiles;

    public ProfileRepository(Application application) {
        ProfileRoomDatabase db = ProfileRoomDatabase.getDatabase(application);
        profileDao = db.profileDao();
        allProfiles = profileDao.getAllProfiles();
    }

    public LiveData<List<Profile>> getAllProfiles() {
        return allProfiles;
    }

    public void insert(Profile profile) {
        new InsertAsyncTask(profileDao).execute(profile);
    }

    private static class InsertAsyncTask extends AsyncTask<Profile, Void, Void> {
        private ProfileDao myDao;

        public InsertAsyncTask(ProfileDao pd) {
            myDao = pd;
        }

        @Override
        protected Void doInBackground(final Profile... params) {
            myDao.insert(params[0]);
            return null;
        }
    }
}
