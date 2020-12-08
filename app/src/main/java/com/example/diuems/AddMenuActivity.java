package com.example.diuems;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AddMenuActivity extends AppCompatActivity {
    private EditText dateEditText,placeEditText,VenuEditText;
    private Button submitButton;
    private DatabaseReference mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu);
        dateEditText = findViewById(R.id.editTextDateID);
        placeEditText = findViewById(R.id.editTextPlaceID);
        VenuEditText = findViewById(R.id.editTextVenueID);
        mRef = FirebaseDatabase.getInstance().getReference().child("addevents");
        submitButton = findViewById(R.id.menusubmitButtonID);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String date = dateEditText.getText().toString();
                String place = placeEditText.getText().toString();
                String venue = VenuEditText.getText().toString();
                if(TextUtils.isEmpty(date)){
                    dateEditText.setError("Please Enter A date");
                }
                if(TextUtils.isEmpty(place)){
                    dateEditText.setError("Please Enter A date");
                }if(TextUtils.isEmpty(venue)){
                    dateEditText.setError("Please Enter A date");
                }
                else {
                    HashMap<String,Object> eventdetails= new HashMap();
                    eventdetails.put("date",date);
                    eventdetails.put("place",place);
                    eventdetails.put("venue",venue);

                    mRef.push().updateChildren(eventdetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(AddMenuActivity.this, "successfully added", Toast.LENGTH_SHORT).show();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),""+e,Toast.LENGTH_LONG).show();
                        }
                    });
                }

            }
        });


    }
}
