package com.vhbeltramini.storageplus.ui.activity.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vhbeltramini.storageplus.R;
import com.vhbeltramini.storageplus.model.Estoque;
import com.vhbeltramini.storageplus.model.Produto;
import com.vhbeltramini.storageplus.model.viewModel.ProdutoViewModel;
import com.vhbeltramini.storageplus.ui.adapter.ListProdutoAdapter;
import com.vhbeltramini.storageplus.ui.adapter.holders.ProdutoHolderView;

import java.util.ArrayList;

import static com.vhbeltramini.storageplus.ui.activity.DataConstants.PRODUCT_KEY;
import static com.vhbeltramini.storageplus.ui.activity.DataConstants.STORAGE_KEY;

public class ListProductsActivity extends AppCompatActivity implements ProdutoHolderView.OnProdutoListner{

    private ProdutoViewModel productsViewModel;
    private ListProdutoAdapter adapter;
    private Intent data;
    ArrayList<Produto> produtos;
    ListProdutoAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView mRecyclerView;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_products);

        mRecyclerView = findViewById(R.id.activity_list_products_recycler_view);

        openFormAddNewProduct();

        handleSetDataOnRecyclerView();
    }

    private void handleSetDataOnRecyclerView() {

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        productsViewModel = new ViewModelProvider(this).get(ProdutoViewModel.class);

        mAdapter = new ListProdutoAdapter(new ListProdutoAdapter.ProdutosDiff(), this);
        mRecyclerView.setAdapter(mAdapter);

        data = getIntent();

        if (data.hasExtra(STORAGE_KEY)) {
            Estoque storage = (Estoque) data.getSerializableExtra(STORAGE_KEY);
            productsViewModel.getByEstoqueId(storage.getId()).observe(this, products -> {

                produtos = (ArrayList<Produto>) products;
                mAdapter.submitList(products);
            });

        } else {
            productsViewModel.getAll().observe(this, products -> {

                produtos = (ArrayList<Produto>) products;
                mAdapter.submitList(products);
            });
        }
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
        addButton.setOnClickListener(v -> startActivity(new Intent(ListProductsActivity.this, FormNewProductActivity.class).putExtra(STORAGE_KEY, data.getSerializableExtra(STORAGE_KEY))));
    }

    @Override
    public void onProdutoClick(int position) {
        Intent goTo = new Intent(ListProductsActivity.this, FormNewProductActivity.class);
        goTo.putExtra(PRODUCT_KEY, produtos.get(position));
        goTo.putExtra(STORAGE_KEY, data.getSerializableExtra(STORAGE_KEY));
        startActivity(goTo);
    }

}
