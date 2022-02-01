package com.vhbeltramini.storageplus.ui.adapter.holders;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vhbeltramini.storageplus.R;

public class LocalizacaoHolderView extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final TextView nameItemView;
    private final TextView descriptionItemView;
    OnLocalizacaoListener onLocalizacaoListener;


    public LocalizacaoHolderView(@NonNull View itemView, OnLocalizacaoListener onLocalizacaoListener) {
        super(itemView);
        nameItemView = itemView.findViewById(R.id.item_name);
        descriptionItemView = itemView.findViewById(R.id.item_description);
        this.onLocalizacaoListener = onLocalizacaoListener;
        itemView.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    public void bind(String name, String description) {
        nameItemView.setText(name);
        descriptionItemView.setText("Endereço: " + description);
    }

    public static LocalizacaoHolderView create(ViewGroup parent, OnLocalizacaoListener onLocalizacaoListener) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simplified_item_list, parent, false);
        return new LocalizacaoHolderView(view, onLocalizacaoListener);
    }

    @Override
    public void onClick(View v) {
        onLocalizacaoListener.onLocalizacaoClick(getAdapterPosition());
    }

    public interface OnLocalizacaoListener {
        void onLocalizacaoClick(int position);
    }

}
