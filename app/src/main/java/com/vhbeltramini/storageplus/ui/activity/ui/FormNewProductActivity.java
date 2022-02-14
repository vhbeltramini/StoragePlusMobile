package com.vhbeltramini.storageplus.ui.activity.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
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
import com.vhbeltramini.storageplus.model.Categoria;
import com.vhbeltramini.storageplus.model.Estoque;
import com.vhbeltramini.storageplus.model.Produto;
import com.vhbeltramini.storageplus.model.viewModel.CategoriaViewModel;
import com.vhbeltramini.storageplus.model.viewModel.ProdutoViewModel;

import java.util.ArrayList;

import static com.vhbeltramini.storageplus.ui.activity.DataConstants.PRODUCT_KEY;
import static com.vhbeltramini.storageplus.ui.activity.DataConstants.STORAGE_KEY;

public class FormNewProductActivity extends AppCompatActivity {

    public static final String EDIT_PRODUCT_TITLE = "Editar Produto";
    public static final String NEW_PRODUCT_TITLE = "Novo Produto";
    private TextView formTitle;
    private ProdutoViewModel productViewModel;
    private EditText nameForm, descriptionForm, minStockQuantityForm, stockQuantityForm;
    private Spinner categorySpinner;
    private Produto product;
    private Button deleteButton;
    private CategoriaViewModel mCategoryViewModel;
    private final ArrayList categoria = new ArrayList<>();
    private final ArrayList categoriaId = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_product);
        formTitle = findViewById(R.id.activity_form_product_title);
        deleteButton = findViewById(R.id.activity_form_product_delete_button);
        productViewModel = new ViewModelProvider(this).get(ProdutoViewModel.class);
        startForm();

        handleCategorySpinner();

        handleFormData();
        handleButtons();
        handleIncreaseAndDecreaseButton();
    }

    private void handleCategorySpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categoria);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);

        mCategoryViewModel = new ViewModelProvider(this).get(CategoriaViewModel.class);
        mCategoryViewModel.getAll().observe(this, categories -> {
            for (Categoria category : categories) {
                categoria.add(category.getNome());
                categoriaId.add(category.getId());
            }

            adapter.notifyDataSetChanged();
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_form_save_menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        handleSave();
        return super.onOptionsItemSelected(item);
    }

    private void startForm() {
        nameForm = findViewById(R.id.activity_form_product_name);
        descriptionForm = findViewById(R.id.activity_form_product_description);
        stockQuantityForm = findViewById(R.id.activity_form_product_quantity_in_stock);
        minStockQuantityForm = findViewById(R.id.activity_form_product_min_quantity_in_stock);
        categorySpinner = findViewById(R.id.activity_form_product_spinner_category);
    }

    private Produto fillAndValidateDataFromForm() {


        Long idLoc = Long.valueOf((Long) categoriaId.get(categoria.indexOf(categorySpinner.getSelectedItem())));
        Categoria category = mCategoryViewModel.getByid(idLoc);
        product.setCategoria(category);

        product.setNome(nameForm.getText().toString());
        product.setDescricao(descriptionForm.getText().toString());
        product.setQtdEstoque(Integer.parseInt(stockQuantityForm.getText().toString()));
        product.setQtdMinEstoque(Integer.parseInt(minStockQuantityForm.getText().toString()));

        return product;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void handleSave() {
        fillAndValidateDataFromForm();

        if (product.hasValidId()) {
            productViewModel.edit(product);
        } else {
            productViewModel.insert(product);
        }
        finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void handleButtons() {
        Button saveButton = findViewById(R.id.activity_form_product_save_button);
        saveButton.setOnClickListener(v -> {
            handleSave();
        });
        deleteButton.setOnClickListener(v -> {
            handleSave();
        });
    }

    private void handleFormData() {
        Intent data = getIntent();
        if (data.hasExtra(PRODUCT_KEY)) {
            product = (Produto) data.getSerializableExtra(PRODUCT_KEY);
            nameForm.setText(product.getNome());
            descriptionForm.setText(product.getDescricao());
            minStockQuantityForm.setText(product.getQtdMinEstoque());
            stockQuantityForm.setText(product.getQtdEstoque());
            formTitle.setText(EDIT_PRODUCT_TITLE);
        } else {
            formTitle.setText(NEW_PRODUCT_TITLE);
            product = new Produto();
        }
    }

    private void handleIncreaseAndDecreaseButton() {

        Button decreaseMinStockQuantityButton = findViewById(R.id.activity_form_product_decrease_button_product_min_quantity_stock);
        Button increaseMinStockQuantityButton = findViewById(R.id.activity_form_product_increase_button_product_min_quantity_stock);

        decreaseMinStockQuantityButton.setOnClickListener(v -> {
            minStockQuantityForm.setText(Integer.parseInt(minStockQuantityForm.toString()) - 1);
        });
        increaseMinStockQuantityButton.setOnClickListener(v -> {
            minStockQuantityForm.setText(Integer.parseInt(minStockQuantityForm.toString()) + 1);
        });

        Button decreaseStockQuantityButton = findViewById(R.id.activity_form_product_decrease_button_product_quantity);
        Button increaseStockQuantityButton = findViewById(R.id.activity_form_product_increase_button_product_quantity);

        decreaseStockQuantityButton.setOnClickListener(v -> {
            stockQuantityForm.setText(Integer.parseInt(stockQuantityForm.getText().toString()) - 1);
        });
        increaseStockQuantityButton.setOnClickListener(v -> {
            stockQuantityForm.setText(Integer.parseInt(stockQuantityForm.getText().toString()) + 1);
        });


    }

}