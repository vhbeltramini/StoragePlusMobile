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
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.vhbeltramini.storageplus.R;
import com.vhbeltramini.storageplus.model.Categoria;
import com.vhbeltramini.storageplus.model.viewModel.CategoriaViewModel;

import static com.vhbeltramini.storageplus.ui.activity.DataConstants.CATEGORY_KEY;

public class FormNewCategoryActivity extends AppCompatActivity {

    public static final String EDIT_CATEGORY_TITLE = "Editar Categoria";
    public static final String NEW_CATEGORY_TITLE = "Nova Categoria";
    private CategoriaViewModel viewModel;
    private Button deleteButton;
    private TextView formTitle;
    private EditText nameForm;
    private EditText descriptionForm;
    private Categoria categoria;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_category);
        viewModel = new ViewModelProvider(this).get(CategoriaViewModel.class);
        formTitle = findViewById(R.id.activity_form_category_title);
        deleteButton = findViewById(R.id.activity_form_category_delete_button);

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
        nameForm = findViewById(R.id.activity_form_category_name);
        descriptionForm = findViewById(R.id.activity_form_category_description);
    }

    private Categoria fillData() {
        categoria.setNome(nameForm.getText().toString());
        categoria.setDescricao(descriptionForm.getText().toString());

        return categoria;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void handleButtons() {
        Button saveButton = findViewById(R.id.activity_form_category_save_button);
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
        if (categoria.hasValidId()) {
            viewModel.edit(categoria);
        } else {
            viewModel.insert(categoria);
        }
        finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void handleDelete() {
        if (categoria.hasValidId()) {
            new AlertDialog
                    .Builder(this)
                    .setTitle("Removendo Categoria")
                    .setMessage("Tem certeza que deseja deletar essa categoria?")
                    .setPositiveButton("Sim", (dialogInterface, i) -> {
                        viewModel.delete(fillData());
                        finish();
                    })
                    .setNegativeButton("Não", null)
                    .show();
        }
    }

    private void handleFormData() {
        Intent data = getIntent();
        if (data.hasExtra(CATEGORY_KEY)) {
            categoria = (Categoria) data.getSerializableExtra(CATEGORY_KEY);
            nameForm.setText(categoria.getNome());
            descriptionForm.setText(categoria.getDescricao());
            deleteButton.setVisibility(View.VISIBLE);
            formTitle.setText(EDIT_CATEGORY_TITLE);
        } else {
            formTitle.setText(NEW_CATEGORY_TITLE);
            categoria = new Categoria();
            deleteButton.setVisibility(View.INVISIBLE);
        }
    }

}