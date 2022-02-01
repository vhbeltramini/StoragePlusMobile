package com.vhbeltramini.storageplus.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.vhbeltramini.storageplus.dao.UsuarioDao;
import com.vhbeltramini.storageplus.database.LocalizacaoDatabase;
import com.vhbeltramini.storageplus.database.UsuarioDatabase;
import com.vhbeltramini.storageplus.model.Usuario;

import java.util.List;

public class UsuarioRepository {

    private UsuarioDao dao;
    private LiveData<List<Usuario>> allEntities;

    public UsuarioRepository(Application application) {
        UsuarioDatabase db = UsuarioDatabase.getInstance(application);
        dao = db.usuarioDao();
        allEntities = dao.getAll();
    }

    public LiveData<List<Usuario>> getAll() {
        return allEntities;
    }

    public void insert(Usuario entity) {
        UsuarioDatabase.databaseWriteExecutor.execute(() -> {
            dao.insert(entity);
        });
    }

    public void delete(Usuario entity) {
        UsuarioDatabase.databaseWriteExecutor.execute(() -> {
            dao.delete(entity);
        });
    }

    public void edit(Usuario entity) {
        UsuarioDatabase.databaseWriteExecutor.execute(() -> {
            dao.update(entity);
        });
    }

}