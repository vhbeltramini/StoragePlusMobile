package com.vhbeltramini.storageplus.ui.activity.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.vhbeltramini.storageplus.R;
import com.vhbeltramini.storageplus.model.Administrador;
import com.vhbeltramini.storageplus.model.Estoque;
import com.vhbeltramini.storageplus.model.Localizacao;
import com.vhbeltramini.storageplus.model.Usuario;
import com.vhbeltramini.storageplus.model.viewModel.EstoqueViewModel;
import com.vhbeltramini.storageplus.model.viewModel.LocalizacaoViewModel;
import com.vhbeltramini.storageplus.model.viewModel.UsuarioViewModel;

import java.util.ArrayList;
import java.util.Objects;

import static com.vhbeltramini.storageplus.ui.activity.DataConstants.STORAGE_KEY;

public class FormNewStorageActivity extends AppCompatActivity {

    public static final String EDIT_STORAGE_TITLE = "Editar Estoque";
    public static final String NEW_STORAGE_TITLE = "Novo Estoque";
    private TextView formTitle;
    private EstoqueViewModel estoqueViewModel;
    private EditText nameForm, descriptionForm;
    private Spinner locationsSpinner, administratorSpinner;
    private Estoque storage;
    private Button deleteButton;
    private LocalizacaoViewModel mLocalizacaoViewModel;
    private UsuarioViewModel mUsuarioViewModel;
    private final ArrayList localizacao = new ArrayList<>();
    private final ArrayList localizacaoId = new ArrayList<>();
    private final ArrayList administrator = new ArrayList<>();
    private final ArrayList administratorId = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_storage);
        formTitle = findViewById(R.id.activity_form_storage_title);
        deleteButton = findViewById(R.id.activity_form_storage_delete_button);
        estoqueViewModel = new ViewModelProvider(this).get(EstoqueViewModel.class);
        startForm();

        handleLocationsSpinner();
        handleOwnerSpinner();

        handleFormData();
        handleButtons();
    }

    private void handleOwnerSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, administrator);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        administratorSpinner.setAdapter(adapter);

        mUsuarioViewModel = new ViewModelProvider(this).get(UsuarioViewModel.class);
        mUsuarioViewModel.getAll().observe(this, users -> {
            for (Usuario user : users) {
                administrator.add(user.getNome());
                administratorId.add(user.getId());
            }
            adapter.notifyDataSetChanged();
        });

    }

    private void handleLocationsSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, localizacao);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationsSpinner.setAdapter(adapter);

        mLocalizacaoViewModel = new ViewModelProvider(this).get(LocalizacaoViewModel.class);
        mLocalizacaoViewModel.getAll().observe(this, locs -> {
            for (Localizacao loc : locs) {
                localizacao.add(loc.getNome());
                localizacaoId.add(loc.getId());
            }

            adapter.notifyDataSetChanged();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_form_save_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        handleSave();
        return super.onOptionsItemSelected(item);
    }

    private void startForm() {
        nameForm = findViewById(R.id.activity_form_storage_name);
        descriptionForm = findViewById(R.id.activity_form_storage_description);
        locationsSpinner = findViewById(R.id.activity_form_storage_spinner_locations);
        administratorSpinner = findViewById(R.id.activity_form_storage_spinner_administrator);
    }

    private Estoque fillStorage() {
        Usuario usuario = mUsuarioViewModel.getByid(Long.valueOf((String) administratorId.get(administrator.indexOf(administratorSpinner.getSelectedItem()))));
        Administrador administrador = new Administrador(usuario.getNome(), usuario.getSenha(), usuario.getEmail());
        storage.setNome(nameForm.getText().toString());
        storage.setDescricao(descriptionForm.getText().toString());
        storage.setLocalizacao(mLocalizacaoViewModel.getByid(Long.valueOf((String) localizacaoId.get(localizacao.indexOf(locationsSpinner.getSelectedItem())))));
        storage.setAdministrador(administrador);

        localizacaoId.get(localizacao.indexOf(locationsSpinner.getSelectedItem()));
        return storage;
    }

    private void handleSave() {
        if (storage.hasValidId()) {
            estoqueViewModel.edit(fillStorage());
        } else {
            estoqueViewModel.insert(fillStorage());
        }
        finish();
    }

    private void handleButtons() {
        Button saveButton = findViewById(R.id.activity_form_storage_save_button);
        saveButton.setOnClickListener(v -> {
            handleSave();
        });
        deleteButton.setOnClickListener(v -> {
            handleSave();
        });
    }

    private void handleFormData() {
        Intent data = getIntent();
        if (data.hasExtra(STORAGE_KEY)) {
            storage = (Estoque) data.getSerializableExtra(STORAGE_KEY);
            nameForm.setText(storage.getNome());
            descriptionForm.setText(storage.getDescricao());
            formTitle.setText(EDIT_STORAGE_TITLE);
        } else {
            formTitle.setText(NEW_STORAGE_TITLE);
            storage = new Estoque();
        }
    }

}