package com.example.diuems;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdminActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText signInEmailEditText, signInPasswordEditText;
    private Button submitButton;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        signInEmailEditText = findViewById(R.id.emailEditTextID11);
        signInPasswordEditText=findViewById(R.id.passwordEditTextID11);
        submitButton = findViewById(R.id.adminSignInButtonId);
        submitButton.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);

    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        String email = signInEmailEditText.getText().toString().trim();
        String password = signInPasswordEditText.getText().toString().trim();
        progressDialog.setTitle("Adding New Item");
        progressDialog.setMessage("Please, Wait");
        progressDialog.setCancelable(false);
        progressDialog.create();
        if (email.equals("admin@me.com")&& password.equals("adminpass")){
            Intent intent = new Intent(AdminActivity.this,AddMenuActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            progressDialog.dismiss();
        }

    }
}
