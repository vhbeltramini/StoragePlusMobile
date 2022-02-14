package com.vhbeltramini.storageplus.ui.activity.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vhbeltramini.storageplus.R;
import com.vhbeltramini.storageplus.model.Categoria;
import com.vhbeltramini.storageplus.model.Usuario;
import com.vhbeltramini.storageplus.model.viewModel.CategoriaViewModel;
import com.vhbeltramini.storageplus.model.viewModel.UsuarioViewModel;
import com.vhbeltramini.storageplus.ui.adapter.ListCategoriasAdapter;
import com.vhbeltramini.storageplus.ui.adapter.ListUsuarioAdapter;
import com.vhbeltramini.storageplus.ui.adapter.holders.CategoriaHolderView;
import com.vhbeltramini.storageplus.ui.adapter.holders.UsuarioHolderView;

import java.io.Serializable;
import java.util.ArrayList;

import static com.vhbeltramini.storageplus.ui.activity.DataConstants.CATEGORIA_KEY;
import static com.vhbeltramini.storageplus.ui.activity.DataConstants.USUARIO_KEY;

public class CategoriesFragment extends Fragment implements CategoriaHolderView.OnCategoriaListener {


    RecyclerView mRecyclerView;
    ArrayList<Categoria> categorias;
    ListCategoriasAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_categories, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.activity_list_categories_recycler_view);

        requireActivity().setTitle("Categorias");

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new ListCategoriasAdapter(new ListCategoriasAdapter.CategoriaDiff(), this);
        mRecyclerView.setAdapter(mAdapter);
        CategoriaViewModel viewModel = new ViewModelProvider(this).get(CategoriaViewModel.class);

        viewModel.getAll().observe(requireActivity(), entities -> {

            categorias = (ArrayList<Categoria>) entities;
            mAdapter.submitList(entities);

            Log.e("Categories: ", entities.toString());
        });

        openFormAddNew(rootView);

        return rootView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void openFormAddNew(View rootView) {
        FloatingActionButton addStorageButton = rootView.findViewById(R.id.activity_list_categories_button_new_category);
        addStorageButton.setOnClickListener(v -> startActivity(new Intent(getActivity(), FormNewCategoryActivity.class)));
    }

    @Override
    public void onCategoriaClick(int position) {
        Intent goToUserForm = new Intent(getActivity(), FormNewCategoryActivity.class);
        goToUserForm.putExtra(CATEGORIA_KEY, (Serializable) categorias.get(position));
        startActivity(goToUserForm);
    }
}
