package com.vhbeltramini.storageplus.ui.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.vhbeltramini.storageplus.model.Produto;
import com.vhbeltramini.storageplus.ui.adapter.holders.LocalizacaoHolderView;
import com.vhbeltramini.storageplus.ui.adapter.holders.ProdutoHolderView;

public class ListProdutoAdapter extends ListAdapter<Produto, ProdutoHolderView> {

    private ProdutoHolderView.OnProdutoListner mOnProdutoListner;

    public ListProdutoAdapter(@NonNull DiffUtil.ItemCallback<Produto> diffCallback, ProdutoHolderView.OnProdutoListner mOnProdutoListner) {
        super(diffCallback);
        this.mOnProdutoListner = mOnProdutoListner;
    }

    @NonNull
    @Override
    public ProdutoHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ProdutoHolderView.create(parent, mOnProdutoListner);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoHolderView holder, int position) {
        Produto current = getItem(position);
        holder.bind(current.getNome(), current.getQtdMinEstoque(), current.getQtdEstoque());
    }

    public static class ProdutosDiff extends DiffUtil.ItemCallback<Produto> {

        @Override
        public boolean areItemsTheSame(@NonNull Produto oldItem, @NonNull Produto newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Produto oldItem, @NonNull Produto newItem) {
            return oldItem.getNome().equals(newItem.getNome());
        }
    }

}
