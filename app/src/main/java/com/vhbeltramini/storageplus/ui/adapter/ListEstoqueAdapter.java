package com.vhbeltramini.storageplus.ui.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.vhbeltramini.storageplus.model.Estoque;
import com.vhbeltramini.storageplus.ui.adapter.holders.EstoqueHolderView;

public class ListEstoqueAdapter extends ListAdapter<Estoque, EstoqueHolderView> {

    public ListEstoqueAdapter(@NonNull DiffUtil.ItemCallback<Estoque> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public EstoqueHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return EstoqueHolderView.create(parent);
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

/**
 * private final List<Estoque> storages = new ArrayList<>();
 *     private final Context context;
 *
 *     public ListStoragesAdapter(Context context) {
 *         this.context = context;
 *     }
 *
 *     @Override
 *     public int getCount() {
 *         return storages.size();
 *     }
 *
 *     @Override
 *     public Estoque getItem(int position) {
 *         return storages.get(position);
 *     }
 *
 *     @Override
 *     public long getItemId(int position) {
 *         return storages.get(position).getId();
 *     }
 *
 *     @SuppressLint("ViewHolder")
 *     @Override
 *     public View getView(int position, View convertView, ViewGroup viewGroup) {
 *          View createdView = LayoutInflater
 *                 .from(context)
 *                 .inflate(R.layout.simplified_item_list, viewGroup, false);
 *
 *         Estoque storage = storages.get(position);
 *
 *         TextView nameField = createdView.findViewById(R.id.item_name);
 *         nameField.setText(storage.getDescricao());
 *         TextView descriptionField = createdView.findViewById(R.id.item_description);
 *         descriptionField.setText("testeste");
 *
 *         return createdView;
 *     }
 *
 *     public void remove(Estoque storage) {
 *         storages.remove(storage);
 *     }
 *
 *     public void clear() {
 *         storages.clear();
 *     }
 *
 *     public void addAll(List<Estoque> all) {
 *         storages.addAll(all);
 *     }
 */
