package com.vhbeltramini.storageplus.model.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.vhbeltramini.storageplus.model.Localizacao;
import com.vhbeltramini.storageplus.model.Usuario;
import com.vhbeltramini.storageplus.repository.LocalizacaoRepository;
import com.vhbeltramini.storageplus.repository.UsuarioRepository;

import java.util.List;

public class UsuarioViewModel extends AndroidViewModel {

    private final UsuarioRepository mRepository;
    private final LiveData<List<Usuario>> mAll;

    public UsuarioViewModel(Application application) {
        super(application);
        mRepository = new UsuarioRepository(application);
        mAll = mRepository.getAll();
    }

    public LiveData<List<Usuario>> getAll() {
        return mAll;
    }

    public Usuario getByid(Long id) {
        return mRepository.getByid(id);
    }

    public void insert(Usuario entity) {
        mRepository.insert(entity);
    }

    public void delete(Usuario entity) {
        mRepository.delete(entity);
    }

    public void edit(Usuario entity) {
        mRepository.edit(entity);
    }


}
