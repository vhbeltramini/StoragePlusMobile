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
import com.vhbeltramini.storageplus.model.Estoque;
import com.vhbeltramini.storageplus.model.viewModel.EstoqueViewModel;
import com.vhbeltramini.storageplus.ui.adapter.ListEstoqueAdapter;
import com.vhbeltramini.storageplus.ui.adapter.holders.EstoqueHolderView;

import java.util.ArrayList;

import static com.vhbeltramini.storageplus.ui.activity.DataConstants.STORAGE_KEY;

public class StoragesFragment extends Fragment implements EstoqueHolderView.OnStorageListner {


    RecyclerView mRecyclerView;
    ListEstoqueAdapter mAdapter;
    ArrayList<Estoque> estoques;
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

        mAdapter = new ListEstoqueAdapter(new ListEstoqueAdapter.StoragesDiff(), this);
        mRecyclerView.setAdapter(mAdapter);
        estoqueViewModel = new ViewModelProvider(this).get(EstoqueViewModel.class);

        estoqueViewModel.getAll().observe(requireActivity(), storages -> {

            estoques = (ArrayList<Estoque>) storages;
            mAdapter.submitList(storages);

            Log.e("Storagesssssssssss", storages.toString());
        });

        openFormAddNewStorage(rootView);

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

    @Override
    public void onEstoqueClick(int position) {
        Intent goTo = new Intent(getActivity(), ListProductsActivity.class);
        goTo.putExtra(STORAGE_KEY, estoques.get(position));
        startActivity(goTo);
    }
}
