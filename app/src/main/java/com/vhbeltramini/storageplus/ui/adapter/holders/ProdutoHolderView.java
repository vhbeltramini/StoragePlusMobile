package com.vhbeltramini.storageplus.ui.adapter.holders;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vhbeltramini.storageplus.R;

public class ProdutoHolderView extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final TextView produtoNameItemView, produtoDescriptionItemView, produtoDescriptionItemViewLabel;
    OnProdutoListner onProdutoListner;

    public ProdutoHolderView(@NonNull View itemView, OnProdutoListner onProdutoListner) {
        super(itemView);
        produtoNameItemView = itemView.findViewById(R.id.product_name);
        produtoDescriptionItemView = itemView.findViewById(R.id.product_item_description_quantity);
        produtoDescriptionItemViewLabel = itemView.findViewById(R.id.product_item_description_label);
        this.onProdutoListner = onProdutoListner;
        itemView.setOnClickListener(this);
    }

    public void bind(String name, Integer qtdMin, Integer qtdAtual) {
        produtoNameItemView.setText(name);
        produtoDescriptionItemView.setText("Mínima : " + qtdMin + "   Atual : " + qtdAtual);
        if (qtdMin > qtdAtual) {
            produtoDescriptionItemView.setTextColor(Color.parseColor("#FF0000"));
            produtoDescriptionItemViewLabel.setTextColor(Color.parseColor("#FF0000"));
        } else {
            produtoDescriptionItemView.setTextColor(Color.parseColor("#7F7F7F"));
            produtoDescriptionItemViewLabel.setTextColor(Color.parseColor("#7F7F7F"));

        }
    }

    public static ProdutoHolderView create(ViewGroup parent, OnProdutoListner onProdutoListner) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item_list, parent, false);
        return new ProdutoHolderView(view, onProdutoListner);
    }

    @Override
    public void onClick(View v) {
        onProdutoListner.onProdutoClick(getAdapterPosition());
    }

    public interface OnProdutoListner {
        void onProdutoClick(int position);
    }

}
