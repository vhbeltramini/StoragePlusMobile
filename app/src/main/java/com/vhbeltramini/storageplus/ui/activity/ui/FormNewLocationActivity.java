package com.vhbeltramini.storageplus.ui.activity.ui;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.vhbeltramini.storageplus.R;
import com.vhbeltramini.storageplus.model.Localizacao;
import com.vhbeltramini.storageplus.model.viewModel.LocalizacaoViewModel;

import static com.vhbeltramini.storageplus.ui.activity.DataConstants.LOCATION_KEY;

public class FormNewLocationActivity extends AppCompatActivity {

    public static final String EDIT_LOCATION_TITLE = "Editar Localização";
    public static final String NEW_LOCATION_TITLE = "Nova Localização";
    private LocalizacaoViewModel localizacaoViewModel;
    private Button deleteButton;
    private TextView formTitle;
    private EditText nameForm;
    private EditText descriptionForm;
    private Localizacao localizacao;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Nova Localizacão");
        setContentView(R.layout.activity_form_location);
        localizacaoViewModel = new ViewModelProvider(this).get(LocalizacaoViewModel.class);
        formTitle = findViewById(R.id.activity_form_location_title);
        deleteButton = findViewById(R.id.activity_form_location_delete_button);

        startForm();
        handleFormData();
        handleButtons();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_form_save_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        handleButtons();
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void handleButtons() {
        Button saveButton = findViewById(R.id.activity_form_location_save_button);
        saveButton.setOnClickListener(v -> {
            handleSave();
        });
        deleteButton.setOnClickListener(v -> {
            handleDelete();
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void handleSave() {
        fillData();
        if (localizacao.hasValidId()) {
            localizacaoViewModel.edit(localizacao);
        } else {
            localizacaoViewModel.insert(localizacao);
        }
        finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void handleDelete() {
        if (localizacao.hasValidId()) {
            new AlertDialog
                    .Builder(this)
                    .setTitle("Removendo Localização")
                    .setMessage("Tem certeza que deseja deletar essa localização?")
                    .setPositiveButton("Sim", (dialogInterface, i) -> {
                        localizacaoViewModel.delete(fillData());
                        finish();
                    })
                    .setNegativeButton("Não", null)
                    .show();
        }
    }

    private void handleFormData() {
        Intent data = getIntent();
        if (data.hasExtra(LOCATION_KEY)) {
            localizacao = (Localizacao) data.getSerializableExtra(LOCATION_KEY);
            nameForm.setText(localizacao.getNome());
            descriptionForm.setText(localizacao.getDescricao());
            formTitle.setText(EDIT_LOCATION_TITLE);
            deleteButton.setVisibility(View.VISIBLE);
        } else {
            formTitle.setText(NEW_LOCATION_TITLE);
            localizacao = new Localizacao();
            deleteButton.setVisibility(View.INVISIBLE);
        }
    }

}