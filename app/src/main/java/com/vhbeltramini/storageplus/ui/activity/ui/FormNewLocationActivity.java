package com.vhbeltramini.storageplus.ui.activity.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.vhbeltramini.storageplus.R;
import com.vhbeltramini.storageplus.model.Localizacao;
import com.vhbeltramini.storageplus.model.viewModel.LocalizacaoViewModel;

import static com.vhbeltramini.storageplus.ui.activity.DataConstants.LOCALIZACAO_KEY;

public class FormNewLocationActivity extends AppCompatActivity {

    public static final String EDIT_LOCATION_TITLE = "Editar Localização";
    public static final String NEW_LOCATION_TITLE = "Nova Localização";
    private LocalizacaoViewModel localizacaoViewModel;
    private EditText nameForm;
    private EditText descriptionForm;
    private Localizacao localizacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Nova Localizacão");
        setContentView(R.layout.activity_form_location);
        localizacaoViewModel = new ViewModelProvider(this).get(LocalizacaoViewModel.class);

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
        nameForm = findViewById(R.id.activity_form_location_name);
        descriptionForm = findViewById(R.id.activity_form_location_description);
    }

    private Localizacao fillData() {
        localizacao.setNome(nameForm.getText().toString());
        localizacao.setDescricao(descriptionForm.getText().toString());

        return localizacao;
    }

    private void handleSaveButton() {
        Button saveButton = findViewById(R.id.activity_form_location_save_button);
        saveButton.setOnClickListener(v -> {
            handleSave();
        });
    }

    private void handleSave() {
        if (localizacao.hasValidId()) {
            localizacaoViewModel.edit(fillData());
        } else {
            localizacaoViewModel.insert(fillData());
        }
        finish();
    }

    private void handleFormData() {
        Intent data = getIntent();
        if (data.hasExtra(LOCALIZACAO_KEY)) {
            localizacao = (Localizacao) data.getSerializableExtra(LOCALIZACAO_KEY);
            nameForm.setText(localizacao.getNome());
            descriptionForm.setText(localizacao.getDescricao());
            setTitle(EDIT_LOCATION_TITLE);
        } else {
            setTitle(NEW_LOCATION_TITLE);
            localizacao = new Localizacao();
        }
    }

}