package com.vhbeltramini.storageplus.ui.activity.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.vhbeltramini.storageplus.R;
import com.vhbeltramini.storageplus.model.Usuario;
import com.vhbeltramini.storageplus.model.viewModel.UsuarioViewModel;

import static com.vhbeltramini.storageplus.ui.activity.DataConstants.USUARIO_KEY;

public class FormNewUserActivity extends AppCompatActivity {

    public static final String EDIT_USER_TITLE = "Editar Usuário";
    public static final String NEW_USER_TITLE = "Novo Usuário";
    private UsuarioViewModel viewModel;
    private TextView formTitle;
    private EditText nameForm;
    private EditText emailForm;
    private EditText passwordForm;
    private EditText confpasswordForm;
    private Usuario ususario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_user);
        viewModel = new ViewModelProvider(this).get(UsuarioViewModel.class);

        formTitle = findViewById(R.id.activity_form_user_title);

        startForm();
        handleFormData();
        handleSaveButton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_form_save_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        handleSaveButton();
        return super.onOptionsItemSelected(item);
    }


    private void startForm() {
        nameForm = findViewById(R.id.activity_form_user_name);
        emailForm = findViewById(R.id.activity_form_user_email);
        passwordForm = findViewById(R.id.activity_form_user_password);
        confpasswordForm = findViewById(R.id.activity_form_user_password_confirm);
    }

    private Usuario fillData() {
        ususario.setNome(nameForm.getText().toString());
        ususario.setEmail(emailForm.getText().toString());
        ususario.setSenha(passwordForm.getText().toString());

        return ususario;
    }

    private void handleSaveButton() {
        Button saveButton = findViewById(R.id.activity_form_user_save_button);
        saveButton.setOnClickListener(v -> {
            handleSave();
        });
    }

    private void handleSave() {
        if (ususario.hasValidId()) {
            viewModel.edit(fillData());
        } else {
            viewModel.insert(fillData());
        }
        finish();
    }

    private void handleFormData() {
        Intent data = getIntent();
        if (data.hasExtra(USUARIO_KEY)) {
            ususario = (Usuario) data.getSerializableExtra(USUARIO_KEY);
            nameForm.setText(ususario.getNome());
            emailForm.setText(ususario.getEmail());
            passwordForm.setText(ususario.getSenha());
            confpasswordForm.setText(ususario.getSenha());
            formTitle.setText(EDIT_USER_TITLE);
        } else {
            formTitle.setText(NEW_USER_TITLE);
            ususario = new Usuario();
        }
    }

}