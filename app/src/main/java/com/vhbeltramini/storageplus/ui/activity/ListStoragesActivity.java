package com.vhbeltramini.storageplus.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vhbeltramini.storageplus.R;
import com.vhbeltramini.storageplus.model.Estoque;
import com.vhbeltramini.storageplus.model.viewModel.EstoqueViewModel;
import com.vhbeltramini.storageplus.ui.adapter.ListEstoquesesAdapter;

public class ListStoragesActivity extends AppCompatActivity {

    private EstoqueViewModel estoqueViewModel;
    private ListView studentsListView;
    private ListEstoquesesAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_storages);
        setTitle("All Students");


        estoqueViewModel = new ViewModelProvider(this).get(EstoqueViewModel.class);
        estoqueViewModel.getAll().observe(this, storages -> {
            adapter.addAll(storages);

            Log.e("Storagesssssssssss", storages.toString());
        });

        handleListStudentes();
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
            handleRemoveStudent(item);
        }
        return super.onContextItemSelected(item);
    }

    private void handleRemoveStudent(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Estoque storage = adapter.getItem(menuInfo.position);
        estoqueViewModel.delete(storage);
        adapter.remove(storage);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.clear();
        estoqueViewModel.getAll().observe(this, storages -> {
            adapter.addAll(storages);
        });
    }

    private void handleListStudentes() {
        studentsListView = findViewById(R.id.activity_list_students_listview);
        handleStudentsAdapter();
        handleStudentListSelection();
        registerForContextMenu(studentsListView);
    }

    private void handleStudentsAdapter() {
        adapter = new ListEstoquesesAdapter(this);
        studentsListView.setAdapter(adapter);
    }

    private void handleStudentListSelection() {
        handleSimpleClickStudentList();
    }

    private void handleSimpleClickStudentList() {
        studentsListView.setOnItemClickListener((adapterView, view, position, id) -> {
                    Estoque estoque = (Estoque) adapterView.getItemAtPosition(position);
                    openFormForEdit(estoque);
                }
        );
    }

    private void openFormForEdit(Estoque estoque) {
        Intent goToForm = new Intent(ListStoragesActivity.this, FormNewStorageActivity.class);
        goToForm.putExtra(DataConstants.STORAGE_KEY, estoque);
        startActivity(goToForm);
    }

    private void openFormAddNewStudent() {
        FloatingActionButton addStorageButton = findViewById(R.id.activity_list_storages_button_new_storages);
        addStorageButton.setOnClickListener(v -> startActivity(new Intent(ListStoragesActivity.this, FormNewStorageActivity.class)));
    }

}
