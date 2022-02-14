package com.vhbeltramini.storageplus.ui.activity.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vhbeltramini.storageplus.R;
import com.vhbeltramini.storageplus.model.Produto;
import com.vhbeltramini.storageplus.model.viewModel.ProdutoViewModel;
import com.vhbeltramini.storageplus.ui.adapter.ListProdutoAdapter;

import java.util.ArrayList;

public class ListProductsActivity extends AppCompatActivity {

    private ProdutoViewModel productsViewModel;
    private ListProdutoAdapter adapter;
    ArrayList<Produto> produtos;
    ListProdutoAdapter mAdapter;
    RecyclerView mRecyclerView;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_products);

        mRecyclerView = findViewById(R.id.activity_list_products_recycler_view);
        final ListProdutoAdapter adapter = new ListProdutoAdapter(new ListProdutoAdapter.ProdutosDiff());
        mRecyclerView.setAdapter(adapter);

        openFormAddNewProduct();

        handleSetDataOnRecyclerView();
    }

    private void handleSetDataOnRecyclerView() {
        productsViewModel = new ViewModelProvider(this).get(ProdutoViewModel.class);

        mAdapter = new ListProdutoAdapter(new ListProdutoAdapter.ProdutosDiff());
        mRecyclerView.setAdapter(mAdapter);

        productsViewModel.getAll().observe(this, products -> {

            produtos = (ArrayList<Produto>) products;
            mAdapter.submitList(products);

            Log.e("Products", products.toString());
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_list_storages_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.activity_list_storages_button_remove) {
            handleRemoveStorage(item);
        }
        return super.onContextItemSelected(item);
    }

    private void handleRemoveStorage(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Produto produto = adapter.getCurrentList().get(menuInfo.position);
        productsViewModel.delete(produto);
        adapter.getCurrentList().remove(produto);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void openFormAddNewProduct() {
        FloatingActionButton addButton = findViewById(R.id.activity_list_products_button_new_products);
        addButton.setOnClickListener(v -> startActivity(new Intent(ListProductsActivity.this, FormNewProductActivity.class)));
    }

}
