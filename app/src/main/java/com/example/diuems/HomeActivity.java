package com.example.diuems;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView eventlist;
    private ArrayList<Events> arrayList;
    private FirebaseRecyclerOptions<Events> options;
    private FirebaseRecyclerAdapter<Events,EventList> adapter;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthlistener;
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        eventlist = findViewById(R.id.eventListID);
        eventlist.setHasFixedSize(true);
        eventlist.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<Events>();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("addevents");
        mDatabase.keepSynced(true);

        options = new FirebaseRecyclerOptions.Builder<Events>().setQuery(mDatabase,Events.class).build();
        adapter = new FirebaseRecyclerAdapter<Events, EventList>(options) {
            @Override
            protected void onBindViewHolder(@NonNull EventList holder, int position, @NonNull Events model) {
                holder.setName(model.getDate());
                holder.setPrice(model.getPlace());
                holder.setDesc(model.getVenue());
                final String food_key = getRef(position).getKey().toString();


            }

            @NonNull
            @Override
            public EventList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new EventList(LayoutInflater.from(HomeActivity.this).inflate(R.layout.single_event_list,parent,false));

            }
        };


        eventlist.setAdapter(adapter);

    }



}

