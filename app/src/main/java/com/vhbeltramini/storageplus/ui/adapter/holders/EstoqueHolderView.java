package com.vhbeltramini.storageplus.ui.adapter.holders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vhbeltramini.storageplus.R;

public class EstoqueHolderView extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final TextView storageNameItemView;
    private final TextView storageDescriptionItemView;
    OnStorageListner onStorageListner;

    public EstoqueHolderView(@NonNull View itemView, OnStorageListner onStorageListner) {
        super(itemView);
        storageNameItemView = itemView.findViewById(R.id.item_name);
        storageDescriptionItemView = itemView.findViewById(R.id.item_description);
        this.onStorageListner = onStorageListner;
        itemView.setOnClickListener(this);
    }

    public void bind(String name, String description) {
        storageNameItemView.setText(name);
        storageDescriptionItemView.setText(description);
    }

    public static EstoqueHolderView create(ViewGroup parent, OnStorageListner onStorageListner) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simplified_item_list, parent, false);
        return new EstoqueHolderView(view, onStorageListner);
    }

    @Override
    public void onClick(View v) {
        onStorageListner.onEstoqueClick(getAdapterPosition());
    }

    public interface OnStorageListner {
        void onEstoqueClick(int position);
    }

}
