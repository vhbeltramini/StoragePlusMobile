package com.vhbeltramini.storageplus.ui.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.vhbeltramini.storageplus.model.Categoria;
import com.vhbeltramini.storageplus.ui.adapter.holders.CategoriaHolderView;

public class ListCategoriaAdapter extends ListAdapter<Categoria, CategoriaHolderView> {

    private CategoriaHolderView.OnCategoriaListener mOnCategoriaListener;

    public ListCategoriaAdapter(@NonNull DiffUtil.ItemCallback<Categoria> diffCallback, CategoriaHolderView.OnCategoriaListener onCategoriaListener) {
        super(diffCallback);
        this.mOnCategoriaListener = onCategoriaListener;
    }

    @NonNull
    @Override
    public CategoriaHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return CategoriaHolderView.create(parent, mOnCategoriaListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaHolderView holder, int position) {
        Categoria current = getItem(position);
        holder.bind(current.getNome(), current.getDescricao());
    }

    public static class CategoriaDiff extends DiffUtil.ItemCallback<Categoria> {

        @Override
        public boolean areItemsTheSame(@NonNull Categoria oldItem, @NonNull Categoria newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Categoria oldItem, @NonNull Categoria newItem) {
            return oldItem.getNome().equals(newItem.getNome());
        }
    }

}
