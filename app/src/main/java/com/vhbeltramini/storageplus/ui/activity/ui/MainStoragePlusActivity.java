package com.vhbeltramini.storageplus.ui.activity.ui;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.navigation.NavigationView;
import com.vhbeltramini.storageplus.R;
import com.vhbeltramini.storageplus.model.Usuario;
import com.vhbeltramini.storageplus.model.viewModel.UsuarioViewModel;
import com.vhbeltramini.storageplus.repository.AES;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import static java.util.Objects.isNull;

public class MainStoragePlusActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    TextView nameMenuField, id, emailMenuField;
    ImageView profileImageMenu;
    GoogleSignInClient mGoogleSignInClient;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_storage_plus);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationView navigationView = findViewById(R.id.nav_view);

        try {
            handleGoogleLogIn(navigationView);
        } catch (NoSuchAlgorithmException | IllegalBlockSizeException | InvalidKeyException | BadPaddingException | NoSuchPaddingException e) {
            e.printStackTrace();
        }

        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new StoragesFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_storages);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void handleGoogleLogIn(NavigationView navigationView) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        GoogleSignInOptions gso = new GoogleSignInOptions .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        View headerLayout = navigationView.getHeaderView(0);

        nameMenuField = headerLayout.findViewById(R.id.navigation_header_container_name);
        profileImageMenu = headerLayout.findViewById(R.id.navigation_header_container_photo);
        emailMenuField = headerLayout.findViewById(R.id.navigation_header_container_email);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {

            UsuarioViewModel viewModel = new ViewModelProvider(this).get(UsuarioViewModel.class);

            String personName = acct.getDisplayName();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();
            String email = acct.getEmail();

            if (isNull(viewModel.getByEmail(email))) {
                viewModel.insert(new Usuario(personName, AES.encrypt(personId.concat(personName.substring(0,3))), email, true));
            }

            nameMenuField.setText(personName);
            emailMenuField.setText(acct.getEmail());
            Glide
                .with(this)
                .load(String.valueOf(personPhoto))
                .apply(new RequestOptions().override(200, 200))
                .centerCrop()
                .into(profileImageMenu);
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_storages:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new StoragesFragment()).commit();
                break;
            case R.id.nav_locations:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LocationsFragment()).commit();
                break;
            case R.id.nav_users:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new UsersFragment()).commit();
            break;
            case R.id.nav_categories:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CategoriesFragment()).commit();
            break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
