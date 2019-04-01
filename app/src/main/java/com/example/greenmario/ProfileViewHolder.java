package com.example.greenmario;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ProfileViewHolder extends RecyclerView.ViewHolder {
    public final TextView username, gender, address, birthDate, country;

    public ProfileViewHolder(View itemView) {
        super(itemView);

        username = itemView.findViewById(R.id.tv_username_r_item);
        gender = itemView.findViewById(R.id.tv_gender_r_item);
        address = itemView.findViewById(R.id.tv_address_r_item);
        birthDate = itemView.findViewById(R.id.tv_birth_date_r_item);
        country = itemView.findViewById(R.id.tv_country_r_item);
    }
}
