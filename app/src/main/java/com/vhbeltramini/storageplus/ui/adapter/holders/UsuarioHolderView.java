package com.vhbeltramini.storageplus.ui.adapter.holders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vhbeltramini.storageplus.R;

public class UsuarioHolderView extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final TextView nameItemView;
    private final TextView descriptionItemView;
    OnUserListener onUserListener;

    public UsuarioHolderView(@NonNull View itemView, OnUserListener onUserListener) {
        super(itemView);
        nameItemView = itemView.findViewById(R.id.item_name);
        descriptionItemView = itemView.findViewById(R.id.item_description);
        this.onUserListener = onUserListener;
        itemView.setOnClickListener(this);
    }

    public void bind(String name, String description) {
        nameItemView.setText(name);
        descriptionItemView.setText("Email: " + description);
    }

    public static UsuarioHolderView create(ViewGroup parent, OnUserListener onUserListener) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simplified_item_list, parent, false);
        return new UsuarioHolderView(view, onUserListener);
    }

    @Override
    public void onClick(View v) {
        onUserListener.onUserClick(getAdapterPosition());
    }

    public interface OnUserListener {
        void onUserClick(int position);
    }

}
