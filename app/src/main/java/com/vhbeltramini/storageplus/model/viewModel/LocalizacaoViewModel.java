package com.vhbeltramini.storageplus.model.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.vhbeltramini.storageplus.model.Localizacao;
import com.vhbeltramini.storageplus.repository.LocalizacaoRepository;

import java.util.List;

public class LocalizacaoViewModel extends AndroidViewModel {

    private final LocalizacaoRepository mRepository;
    private final LiveData<List<Localizacao>> mAll;

    public LocalizacaoViewModel(Application application) {
        super(application);
        mRepository = new LocalizacaoRepository(application);
        mAll = mRepository.getAll();
    }

    public LiveData<List<Localizacao>> getAll() {
        return mAll;
    }

    public Localizacao getByid(Long id) {
        return mRepository.getByid(id);
    }

    public void insert(Localizacao entity) {
        mRepository.insert(entity);
    }

    public void delete(Localizacao entity) {
        mRepository.delete(entity);
    }

    public void edit(Localizacao entity) {
        mRepository.edit(entity);
    }

}
