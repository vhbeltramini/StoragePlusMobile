package com.vhbeltramini.storageplus.model.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.vhbeltramini.storageplus.model.Categoria;
import com.vhbeltramini.storageplus.repository.CategoriaRepository;

import java.util.List;

public class CategoriaViewModel extends AndroidViewModel {

    private final CategoriaRepository mRepository;
    private final LiveData<List<Categoria>> mAll;

    public CategoriaViewModel(Application application) {
        super(application);
        mRepository = new CategoriaRepository(application);
        mAll = mRepository.getAll();
    }

    public LiveData<List<Categoria>> getAll() {
        return mAll;
    }

    public Categoria getByid(Long id) {
        return mRepository.getByid(id);
    }


    public void insert(Categoria entity) {
        mRepository.insert(entity);
    }

    public void delete(Categoria entity) {
        mRepository.delete(entity);
    }

    public void edit(Categoria entity) {
        mRepository.edit(entity);
    }


}
