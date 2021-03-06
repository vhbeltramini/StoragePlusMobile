package com.vhbeltramini.storageplus.ui.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.vhbeltramini.storageplus.model.Estoque;
import com.vhbeltramini.storageplus.ui.adapter.holders.EstoqueHolderView;
import com.vhbeltramini.storageplus.ui.adapter.holders.LocalizacaoHolderView;

public class ListEstoqueAdapter extends ListAdapter<Estoque, EstoqueHolderView> {

    private EstoqueHolderView.OnStorageListner mOnStorageListner;

    public ListEstoqueAdapter(@NonNull DiffUtil.ItemCallback<Estoque> diffCallback, EstoqueHolderView.OnStorageListner mOnStorageListner) {
        super(diffCallback);
        this.mOnStorageListner = mOnStorageListner;
    }

    @NonNull
    @Override
    public EstoqueHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return EstoqueHolderView.create(parent, mOnStorageListner);
    }

    @Override
    public void onBindViewHolder(@NonNull EstoqueHolderView holder, int position) {
        Estoque current = getItem(position);
        holder.bind(current.getNome(), current.getDescricao());
    }

    public static class StoragesDiff extends DiffUtil.ItemCallback<Estoque> {

        @Override
        public boolean areItemsTheSame(@NonNull Estoque oldItem, @NonNull Estoque newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Estoque oldItem, @NonNull Estoque newItem) {
            return oldItem.getNome().equals(newItem.getNome());
        }
    }

}
