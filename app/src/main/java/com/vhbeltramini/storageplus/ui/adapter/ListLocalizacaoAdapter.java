package com.vhbeltramini.storageplus.ui.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.vhbeltramini.storageplus.model.Localizacao;
import com.vhbeltramini.storageplus.ui.adapter.holders.LocalizacaoHolderView;

public class ListLocalizacaoAdapter extends ListAdapter<Localizacao, LocalizacaoHolderView> {

    private LocalizacaoHolderView.OnLocalizacaoListener mOnLocalizacaoListener;

    public ListLocalizacaoAdapter(@NonNull DiffUtil.ItemCallback<Localizacao> diffCallback, LocalizacaoHolderView.OnLocalizacaoListener onLocalizacaoListener) {
        super(diffCallback);
        this.mOnLocalizacaoListener = onLocalizacaoListener;
    }

    @NonNull
    @Override
    public LocalizacaoHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return LocalizacaoHolderView.create(parent, mOnLocalizacaoListener);
    }

    @Override
    public void onBindViewHolder(@NonNull LocalizacaoHolderView holder, int position) {
        Localizacao current = getItem(position);
        holder.bind(current.getNome(), current.getDescricao());
    }

    public static class LocalizacaoDiff extends DiffUtil.ItemCallback<Localizacao> {

        @Override
        public boolean areItemsTheSame(@NonNull Localizacao oldItem, @NonNull Localizacao newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Localizacao oldItem, @NonNull Localizacao newItem) {
            return oldItem.getNome().equals(newItem.getNome());
        }
    }

}
