package com.vhbeltramini.storageplus.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.vhbeltramini.storageplus.R;

import java.io.InputStream;

public class InitialSystemPage extends AppCompatActivity {

    TextView name, id;
    ImageView profileImage;
    Button signOut;

    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_system_page);

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
//            Glide.with(this).load(String.valueOf(personPhoto)).centerCrop().into(profileImage);
            LoadImage loadImage = new LoadImage(profileImage);
            loadImage.execute(String.valueOf(personPhoto));

            new LoadImage((ImageView)
            findViewById(R.id.profileImage)).execute(String.valueOf(personPhoto));
        }

    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(InitialSystemPage.this, "Signed out!", Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
    }

    private class LoadImage extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public LoadImage(ImageView image) {
            this.imageView = image;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String urlLink = strings[0];
            Bitmap bitmap = null;
            try {
                InputStream inStream = new java.net.URL(urlLink).openStream();
                bitmap = BitmapFactory.decodeStream(inStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
        }

    }

}
