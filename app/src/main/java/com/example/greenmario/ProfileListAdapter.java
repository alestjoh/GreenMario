package com.example.greenmario;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.greenmario.ProfileViewHolder;
import com.example.greenmario.R;

import java.util.List;

public class ProfileListAdapter extends RecyclerView.Adapter<ProfileViewHolder> {

    private List<Profile> profiles;

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.recycler_profile_item, viewGroup, false);
        return new ProfileViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder profileViewHolder, int i) {
        if (profiles == null) {
            profileViewHolder.username.setText("USER NOT AVAILABLE");
        } else {
            Profile p = profiles.get(i);
            profileViewHolder.username.setText(p.username);
            profileViewHolder.birthDate.setText(p.birthDate);
            profileViewHolder.address.setText(p.address);
            profileViewHolder.country.setText(p.country);
            profileViewHolder.gender.setText(p.gender);
        }
    }

    @Override
    public int getItemCount() {
        return profiles == null ? 0 : profiles.size();
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
        notifyDataSetChanged();
    }
}
