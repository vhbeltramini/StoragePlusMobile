package com.vhbeltramini.storageplus.ui.activity.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.vhbeltramini.storageplus.R;
import com.vhbeltramini.storageplus.model.Estoque;
import com.vhbeltramini.storageplus.model.viewModel.EstoqueViewModel;

import static com.vhbeltramini.storageplus.ui.activity.DataConstants.STORAGE_KEY;

public class FormNewStorageActivity extends AppCompatActivity {

    public static final String EDIT_STORAGE_TITLE = "Editar Estoque";
    public static final String NEW_STORAGE_TITLE = "Novo Estoque";
    private EstoqueViewModel estoqueViewModel;
    private EditText nameForm;
    private EditText descriptionForm;
    private Estoque storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_storage);
        estoqueViewModel = new ViewModelProvider(this).get(EstoqueViewModel.class);

        startForm();
        handleFormData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_form_save_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        handleStudentSave();
        return super.onOptionsItemSelected(item);
    }

    private void startForm() {
        nameForm = findViewById(R.id.activity_form_storage_name);
        descriptionForm = findViewById(R.id.activity_form_storage_description);
    }

    private Estoque fillStorage() {
        storage.setNome(nameForm.getText().toString());
        storage.setDescricao(descriptionForm.getText().toString());

        return storage;
    }

    private void handleStudentSave() {

        estoqueViewModel.insert(fillStorage());
//        if (storage.hasValidId()) {
//            estoqueViewModel.edit(fillStorage());
//        } else {
//            estoqueViewModel.insert(fillStorage());
//        }
        finish();
    }

    private void handleFormData() {
        Intent data = getIntent();
        if (data.hasExtra(STORAGE_KEY)) {
            storage = (Estoque) data.getSerializableExtra("student");
            nameForm.setText(storage.getNome());
            descriptionForm.setText(storage.getDescricao());
            setTitle(EDIT_STORAGE_TITLE);
        } else {
            setTitle(NEW_STORAGE_TITLE);
            storage = new Estoque("","");
        }
    }

}