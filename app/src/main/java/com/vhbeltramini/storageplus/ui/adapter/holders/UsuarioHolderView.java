package com.vhbeltramini.storageplus.ui.adapter.holders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vhbeltramini.storageplus.R;

public class UsuarioHolderView extends RecyclerView.ViewHolder {

    private final TextView nameItemView;
    private final TextView descriptionItemView;


    public UsuarioHolderView(@NonNull View itemView) {
        super(itemView);
        nameItemView = itemView.findViewById(R.id.item_name);
        descriptionItemView = itemView.findViewById(R.id.item_description);
    }

    public void bind(String name, String description) {
        nameItemView.setText(name);
        descriptionItemView.setText("Email: " + description);
    }

    public static UsuarioHolderView create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simplified_item_list, parent, false);
        return new UsuarioHolderView(view);
    }

}
