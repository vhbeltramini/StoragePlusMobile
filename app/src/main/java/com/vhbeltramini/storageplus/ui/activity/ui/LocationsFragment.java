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
import com.vhbeltramini.storageplus.model.viewModel.LocalizacaoViewModel;
import com.vhbeltramini.storageplus.ui.adapter.ListEstoqueAdapter;
import com.vhbeltramini.storageplus.ui.adapter.ListLocalizacaoAdapter;

public class LocationsFragment extends Fragment {

    RecyclerView mRecyclerView;
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

        mAdapter = new ListLocalizacaoAdapter(new ListLocalizacaoAdapter.LocalizacaoDiff());
        mRecyclerView.setAdapter(mAdapter);
        LocalizacaoViewModel viewModel = new ViewModelProvider(this).get(LocalizacaoViewModel.class);

        viewModel.getAll().observe(requireActivity(), entities -> {
            mAdapter.submitList(entities);

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


}