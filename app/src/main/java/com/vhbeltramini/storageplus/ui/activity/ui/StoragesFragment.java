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
import com.vhbeltramini.storageplus.model.viewModel.EstoqueViewModel;
import com.vhbeltramini.storageplus.ui.adapter.ListEstoqueAdapter;

public class StoragesFragment extends Fragment {


    RecyclerView mRecyclerView;
    ListEstoqueAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    private EstoqueViewModel estoqueViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_storages, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.activity_list_storages_recycler_view);

        requireActivity().setTitle("Estoques");

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new ListEstoqueAdapter(new ListEstoqueAdapter.StoragesDiff());
        mRecyclerView.setAdapter(mAdapter);
        estoqueViewModel = new ViewModelProvider(this).get(EstoqueViewModel.class);

        estoqueViewModel.getAll().observe(requireActivity(), storages -> {
            mAdapter.submitList(storages);

            Log.e("Storagesssssssssss", storages.toString());
        });

        openFormAddNewStorage(rootView);

//        Intent intent = new Intent(getActivity(), mFragmentFavorite.class);
//        startActivity(intent);

//        Intent goToForm = new Intent(getActivity(), ListStoragesActivity.class);
//        startActivity(goToForm);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void openFormAddNewStorage(View rootView) {
        FloatingActionButton addStorageButton = rootView.findViewById(R.id.activity_list_storages_button_new_storages);
        addStorageButton.setOnClickListener(v -> startActivity(new Intent(getActivity(), FormNewStorageActivity.class)));
    }


}
