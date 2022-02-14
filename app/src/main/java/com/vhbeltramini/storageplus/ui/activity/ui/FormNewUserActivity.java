package com.vhbeltramini.storageplus.ui.activity.ui;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.vhbeltramini.storageplus.R;
import com.vhbeltramini.storageplus.model.Usuario;
import com.vhbeltramini.storageplus.model.viewModel.UsuarioViewModel;
import com.vhbeltramini.storageplus.repository.AES;
import com.vhbeltramini.storageplus.ui.activity.DataConstants;

import static com.vhbeltramini.storageplus.ui.activity.DataConstants.USUARIO_KEY;

public class FormNewUserActivity extends AppCompatActivity {

    public static final String EDIT_USER_TITLE = "Editar Usuário";
    public static final String NEW_USER_TITLE = "Novo Usuário";
    private UsuarioViewModel viewModel;
    private TextView formTitle;
    private Button deleteButton;
    private EditText nameForm, emailForm, passwordForm, confpasswordForm;
    private CheckBox isAdminForm;
    private Usuario ususario;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_user);
        viewModel = new ViewModelProvider(this).get(UsuarioViewModel.class);

        formTitle = findViewById(R.id.activity_form_user_title);
        deleteButton = findViewById(R.id.activity_form_user_delete_button);

        startForm();
        handleFormData();
        handleSaveButton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_form_save_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
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
        isAdminForm = findViewById(R.id.activity_form_user_admin_checkbox);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private Usuario fillData() {

        ususario.setNome(nameForm.getText().toString());
        ususario.setEmail(emailForm.getText().toString());
        ususario.setSenha(AES.encrypt(passwordForm.getText().toString()));
        ususario.setIsAdmin(isAdminForm.isChecked());

        return ususario;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void handleSaveButton() {
        Button saveButton = findViewById(R.id.activity_form_user_save_button);
        saveButton.setOnClickListener(v -> {
            handleSave();
        });
        deleteButton.setOnClickListener(v -> {
            handleDelete();
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void handleSave() {
        if (!handleData()) {
            return;
        }

        if (ususario.hasValidId()) {
            viewModel.edit(ususario);
        } else {
            viewModel.insert(ususario);
        }
        finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private Boolean handleData() {
        String password = passwordForm.getText().toString();
        String confPassword = confpasswordForm.getText().toString();
        if(password.equals(confPassword)) {
            if (passwordForm.getText().length() < 8) {
                Toast.makeText(this, "A senhas deve ter no mínimo 8 dígitos", Toast.LENGTH_LONG).show();
                passwordForm.setHint("A senhas deve ter no mínimo 8 dígitos");
                return false;
            }
            fillData();
            return true;
        }else{
            Toast.makeText(this, "As senhas não corespondem", Toast.LENGTH_LONG).show();
            confpasswordForm.setHint("As senhas não corespondem");
            confpasswordForm.setBackgroundColor(Color.red(1));
            return false;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void handleDelete() {
        if (ususario.hasValidId()) {
            new AlertDialog
                    .Builder(this)
                    .setTitle("Removendo Usuário")
                    .setMessage("Tem certeza que deseja deletar essa usuário?")
                    .setPositiveButton("Sim", (dialogInterface, i) -> {
                        viewModel.delete(fillData());
                        finish();
                    })
                    .setNegativeButton("Não", null)
                    .show();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void handleFormData() {
        Intent data = getIntent();
        if (data.hasExtra(USUARIO_KEY)) {
            ususario = (Usuario) data.getSerializableExtra(DataConstants.USUARIO_KEY);
            nameForm.setText(ususario.getNome());
            emailForm.setText(ususario.getEmail());
            passwordForm.setText(AES.decrypt(ususario.getSenha()));
            confpasswordForm.setText(AES.decrypt(ususario.getSenha()));
            isAdminForm.setSelected(ususario.getIsAdmin());
            formTitle.setText(EDIT_USER_TITLE);
            deleteButton.setVisibility(View.VISIBLE);
        } else {
            formTitle.setText(NEW_USER_TITLE);
            ususario = new Usuario();
            deleteButton.setVisibility(View.INVISIBLE);
        }
    }

}