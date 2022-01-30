package com.vhbeltramini.storageplus.model.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.vhbeltramini.storageplus.model.Estoque;
import com.vhbeltramini.storageplus.repository.EstoqueRepository;

import java.util.List;

public class EstoqueViewModel extends AndroidViewModel {

    private EstoqueRepository mStorageRepository;
    private final LiveData<List<Estoque>> mAllStorages;

    public EstoqueViewModel(Application application) {
        super(application);
        mStorageRepository = new EstoqueRepository(application);
        mAllStorages = mStorageRepository.getAll();
    }

    public LiveData<List<Estoque>> getAll() {
        return mAllStorages;
    }

    public void insert(Estoque storage) {
        mStorageRepository.insert(storage);
    }

    public void delete(Estoque storage) {
        mStorageRepository.delete(storage);
    }

}
