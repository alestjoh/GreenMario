package com.example.greenmario;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ViewResultsActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ProfileViewModel pvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_results);

        rv = findViewById(R.id.rv_profile_table_results);
        final ProfileListAdapter pla = new ProfileListAdapter();
        rv.setAdapter(pla);
        rv.setLayoutManager(new LinearLayoutManager(this));

        pvm = ViewModelProviders.of(this).get(ProfileViewModel.class);
        pvm.getAllProfiles().observe(
                this, profiles -> pla.setProfiles(profiles));

        Profile p = new Profile();
        p.email = "MrGreen@lil.bro";
        p.address = "123 N Fake Ln";
        p.username = "Green Mario";
        p.birthDate = "01/15/1776";
        p.gender = "M";
        p.country = "Mushroom Kingdom";
        pvm.insert(p);
        p = new Profile();
        p.name = "???";
        p.username = "???";
        p.email = "Thesame@different.not";
        pvm.insert(p);

        p = getIntent().getParcelableExtra("profile");
        pvm.insert(p);
    }
}
