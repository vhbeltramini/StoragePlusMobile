package com.vhbeltramini.storageplus.ui.adapter.holders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vhbeltramini.storageplus.R;

public class ProdutoHolderView extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final TextView produtoNameItemView, produtoDescriptionItemView;
    OnProdutoListner onProdutoListner;

    public ProdutoHolderView(@NonNull View itemView) {
        super(itemView);
        produtoNameItemView = itemView.findViewById(R.id.item_name);
        produtoDescriptionItemView = itemView.findViewById(R.id.item_description);
    }

    public void bind(String name, String description) {
        produtoNameItemView.setText(name);
        produtoDescriptionItemView.setText(description);
    }

    public static ProdutoHolderView create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simplified_item_list, parent, false);
        return new ProdutoHolderView(view);
    }

    @Override
    public void onClick(View v) {
        onProdutoListner.onProdutoClick(getAdapterPosition());
    }

    public interface OnProdutoListner {
        void onProdutoClick(int position);
    }

}
