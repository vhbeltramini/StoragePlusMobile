package com.vhbeltramini.storageplus.ui.adapter.holders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vhbeltramini.storageplus.R;

public class CategoriaHolderView extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final TextView nameItemView;
    private final TextView descriptionItemView;
    OnCategoriaListener onCategoriaListener;


    public CategoriaHolderView(@NonNull View itemView, OnCategoriaListener onCategoriaListener) {
        super(itemView);
        nameItemView = itemView.findViewById(R.id.item_name);
        descriptionItemView = itemView.findViewById(R.id.item_description);
        this.onCategoriaListener = onCategoriaListener;
        itemView.setOnClickListener(this);
    }

    public void bind(String name, String description) {
        nameItemView.setText(name);
        descriptionItemView.setText("Descrição: " + description);
    }

    public static CategoriaHolderView create(ViewGroup parent, OnCategoriaListener onCategoriaListener) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simplified_item_list, parent, false);
        return new CategoriaHolderView(view, onCategoriaListener);
    }

    @Override
    public void onClick(View v) {
        onCategoriaListener.onCategoriaClick(getAdapterPosition());
    }

    public interface OnCategoriaListener {
        void onCategoriaClick(int position);
    }

}
