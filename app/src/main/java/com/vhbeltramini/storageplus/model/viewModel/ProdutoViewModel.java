package com.vhbeltramini.storageplus.model.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.vhbeltramini.storageplus.model.Estoque;
import com.vhbeltramini.storageplus.model.Produto;
import com.vhbeltramini.storageplus.repository.EstoqueRepository;
import com.vhbeltramini.storageplus.repository.ProdutoRepository;

import java.util.List;

public class ProdutoViewModel extends AndroidViewModel {

    private ProdutoRepository mRepository;
    private final LiveData<List<Produto>> mAll;

    public ProdutoViewModel(Application application) {
        super(application);
        mRepository = new ProdutoRepository(application);
        mAll = mRepository.getAll();
    }

    public LiveData<List<Produto>> getAll() {
        return mAll;
    }


    public LiveData<List<Produto>> getByEstoqueId(Long id) {
        return mRepository.getByEstoqueId(id);
    }

    public void insert(Produto entity) {
        mRepository.insert(entity);
    }

    public void delete(Produto entity) {
        mRepository.delete(entity);
    }

    public void edit(Produto entity) {
        mRepository.edit(entity);
    }

}
