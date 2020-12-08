package com.example.diuems;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventList extends RecyclerView.ViewHolder {
    View mView;

    public EventList(@NonNull View itemView) {
        super(itemView);
        mView = itemView;
    }
    public void setName(String name) {
        TextView event_date = mView.findViewById(R.id.dateID);
        event_date.setText("Date : "+name);
    }
    public void setDesc(String desc) {
        TextView event_place = mView.findViewById(R.id.placeId);
        event_place.setText("Place : "+desc);
    }public void setPrice(String price) {
        TextView event_venue = mView.findViewById(R.id.venueID);
        event_venue.setText("Venue :" +price);
    }
}
