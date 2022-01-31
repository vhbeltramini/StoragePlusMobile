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
import com.vhbeltramini.storageplus.model.viewModel.UsuarioViewModel;
import com.vhbeltramini.storageplus.ui.adapter.ListUsuarioAdapter;

public class UsersFragment extends Fragment {


    RecyclerView mRecyclerView;
    ListUsuarioAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_users, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.activity_list_users_recycler_view);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new ListUsuarioAdapter(new ListUsuarioAdapter.UsuarioDiff());
        mRecyclerView.setAdapter(mAdapter);
        UsuarioViewModel viewModel = new ViewModelProvider(this).get(UsuarioViewModel.class);

        viewModel.getAll().observe(requireActivity(), entities -> {
            mAdapter.submitList(entities);

            Log.e("Users: ", entities.toString());
        });

        openFormAddNew(rootView);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void openFormAddNew(View rootView) {
        FloatingActionButton addStorageButton = rootView.findViewById(R.id.activity_list_users_button_new_user);
        addStorageButton.setOnClickListener(v -> startActivity(new Intent(getActivity(), FormNewLocationActivity.class)));
    }

}
