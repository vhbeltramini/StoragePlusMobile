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
import com.vhbeltramini.storageplus.model.Localizacao;
import com.vhbeltramini.storageplus.model.viewModel.LocalizacaoViewModel;
import com.vhbeltramini.storageplus.ui.adapter.ListLocalizacaoAdapter;
import com.vhbeltramini.storageplus.ui.adapter.holders.UsuarioHolderView;

import java.io.Serializable;
import java.util.ArrayList;

import static com.vhbeltramini.storageplus.ui.activity.DataConstants.LOCALIZACAO_KEY;

public class LocationsFragment extends Fragment implements UsuarioHolderView.OnUserListener {

    RecyclerView mRecyclerView;
    ArrayList<Localizacao> localizacoes;
    ListLocalizacaoAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_location, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.activity_list_locations_recycler_view);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new ListLocalizacaoAdapter(new ListLocalizacaoAdapter.LocalizacaoDiff(), this::onUserClick);
        mRecyclerView.setAdapter(mAdapter);
        LocalizacaoViewModel viewModel = new ViewModelProvider(this).get(LocalizacaoViewModel.class);

        viewModel.getAll().observe(requireActivity(), entities -> {
            mAdapter.submitList(entities);
            localizacoes = (ArrayList<Localizacao>) entities;

            Log.e("Localizacao", entities.toString());
        });

        openFormAddNewLocation(rootView);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void openFormAddNewLocation(View rootView) {
        FloatingActionButton addStorageButton = rootView.findViewById(R.id.activity_list_locations_button_new_locations);
        addStorageButton.setOnClickListener(v -> startActivity(new Intent(getActivity(), FormNewLocationActivity.class)));
    }


    @Override
    public void onUserClick(int position) {
        Intent goToForm = new Intent(getActivity(), FormNewLocationActivity.class);
        goToForm.putExtra(LOCALIZACAO_KEY, (Serializable) localizacoes.get(position));
        startActivity(goToForm);
    }
}