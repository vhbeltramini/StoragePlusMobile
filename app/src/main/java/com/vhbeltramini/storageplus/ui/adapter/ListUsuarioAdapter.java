package com.vhbeltramini.storageplus.ui.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.vhbeltramini.storageplus.model.Usuario;
import com.vhbeltramini.storageplus.ui.adapter.holders.UsuarioHolderView;

public class ListUsuarioAdapter extends ListAdapter<Usuario, UsuarioHolderView> {

    private UsuarioHolderView.OnUserListener mOnUserListener;

    public ListUsuarioAdapter(@NonNull DiffUtil.ItemCallback<Usuario> diffCallback, UsuarioHolderView.OnUserListener onUserListener) {
        super(diffCallback);
        this.mOnUserListener = onUserListener;
    }

    @NonNull
    @Override
    public UsuarioHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return UsuarioHolderView.create(parent, mOnUserListener);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioHolderView holder, int position) {
        Usuario current = getItem(position);
        holder.bind(current.getNome(), current.getEmail());
    }

    public static class UsuarioDiff extends DiffUtil.ItemCallback<Usuario> {

        @Override
        public boolean areItemsTheSame(@NonNull Usuario oldItem, @NonNull Usuario newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Usuario oldItem, @NonNull Usuario newItem) {
            return oldItem.getNome().equals(newItem.getNome());
        }
    }

}
