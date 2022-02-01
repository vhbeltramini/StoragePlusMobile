package com.vhbeltramini.storageplus.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.vhbeltramini.storageplus.R;
import com.vhbeltramini.storageplus.model.Usuario;
import com.vhbeltramini.storageplus.ui.adapter.holders.UsuarioHolderView;

public class ListUsuarioAdapter extends ListAdapter<Usuario, UsuarioHolderView> {

    public ListUsuarioAdapter(@NonNull DiffUtil.ItemCallback<Usuario> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public UsuarioHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return UsuarioHolderView.create(parent);
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title, description;
        onUserListener onUserListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_name);
            description = itemView.findViewById(R.id.item_description);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

    public interface onUserListener {
        void onNoteClick(int position);
    }

}
