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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vhbeltramini.storageplus.R;
import com.vhbeltramini.storageplus.model.Estoque;
import com.vhbeltramini.storageplus.model.viewModel.EstoqueViewModel;
import com.vhbeltramini.storageplus.ui.adapter.ListEstoqueAdapter;

public class ListStoragesActivity extends AppCompatActivity {

    private EstoqueViewModel estoqueViewModel;
    private ListEstoqueAdapter adapter;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_storages);

        RecyclerView recyclerView = findViewById(R.id.activity_list_storages_recycler_view);
        final ListEstoqueAdapter adapter = new ListEstoqueAdapter(new ListEstoqueAdapter.StoragesDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        estoqueViewModel = new ViewModelProvider(this).get(EstoqueViewModel.class);
        estoqueViewModel.getAll().observe(this, storages -> {
            adapter.submitList(storages);

            Log.e("Storagesssssssssss", storages.toString());
        });
        openFormAddNewStudent();
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
        Estoque storage = adapter.getCurrentList().get(menuInfo.position);
        estoqueViewModel.delete(storage);
        adapter.getCurrentList().remove(storage);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

//    private void handleListStudentes() {
//        handleStudentsAdapter();
//        handleStudentListSelection();
//        registerForContextMenu(studentsListView);
//    }


//
//    private void handleSimpleClickStudentList() {
//        studentsListView.setOnItemClickListener((adapterView, view, position, id) -> {
//                    Estoque estoque = (Estoque) adapterView.getItemAtPosition(position);
//                    openFormForEdit(estoque);
//                }
//        );
//    }
//
//    private void openFormForEdit(Estoque estoque) {
//        Intent goToForm = new Intent(ListStoragesActivity.this, FormNewStorageActivity.class);
//        goToForm.putExtra(DataConstants.STORAGE_KEY, estoque);
//        startActivity(goToForm);
//    }

    private void openFormAddNewStudent() {
        FloatingActionButton addStorageButton = findViewById(R.id.activity_list_storages_button_new_storages);
        addStorageButton.setOnClickListener(v -> startActivity(new Intent(ListStoragesActivity.this, FormNewStorageActivity.class)));
    }

}
