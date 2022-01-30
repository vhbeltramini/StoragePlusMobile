package com.vhbeltramini.storageplus.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vhbeltramini.storageplus.R;
import com.vhbeltramini.storageplus.model.Estoque;

import java.util.ArrayList;
import java.util.List;

public class ListEstoquesesAdapter extends BaseAdapter {

    private final List<Estoque> storages = new ArrayList<>();
    private final Context context;

    public ListEstoquesesAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return storages.size();
    }

    @Override
    public Estoque getItem(int position) {
        return storages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return storages.get(position).getId();
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
         View createdView = LayoutInflater
                .from(context)
                .inflate(R.layout.simplified_item_list, viewGroup, false);

        Estoque storage = storages.get(position);

        TextView nameField = createdView.findViewById(R.id.item_name);
        nameField.setText(storage.getDescricao());
        TextView descriptionField = createdView.findViewById(R.id.item_description);
        descriptionField.setText("testeste");

        return createdView;
    }

    public void remove(Estoque storage) {
        storages.remove(storage);
    }

    public void clear() {
        storages.clear();
    }

    public void addAll(List<Estoque> all) {
        storages.addAll(all);
    }

}
