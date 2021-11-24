package com.vhbeltramini.storageplus;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class SecondActivity extends AppCompatActivity {

    TextView name, id;
    ImageView profileImage;
    Button signOut;

    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        GoogleSignInOptions gso = new GoogleSignInOptions .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        id = findViewById(R.id.personId);
        name = findViewById(R.id.personName);
        profileImage = findViewById(R.id.profileImage);
        signOut = findViewById(R.id.signOutButton);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.signOutButton:
                        signOut();
                        break;
                }

            }
        });


        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();

            id.setText(personId);
            name.setText(personName);
            Glide.with(this).load(String.valueOf(personPhoto)).into(profileImage);
        }

    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(SecondActivity.this, "Signed out!", Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
    }

}
