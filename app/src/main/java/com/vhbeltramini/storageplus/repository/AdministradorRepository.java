package com.vhbeltramini.storageplus.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.vhbeltramini.storageplus.dao.AdministradorDao;
import com.vhbeltramini.storageplus.database.AdministradorDatabase;
import com.vhbeltramini.storageplus.database.LocalizacaoDatabase;
import com.vhbeltramini.storageplus.model.Administrador;

import java.util.List;

public class AdministradorRepository {

    private AdministradorDao dao;
    private LiveData<List<Administrador>> allEntities;

    public AdministradorRepository(Application application) {
        AdministradorDatabase db = AdministradorDatabase.getInstance(application);
        dao = db.administradorDao();
        allEntities = dao.getAll();
    }

    public LiveData<List<Administrador>> getAll() {
        return allEntities;
    }

    public void insert(Administrador entity) {
        LocalizacaoDatabase.databaseWriteExecutor.execute(() -> {
            dao.insert(entity);
        });
    }

    public void delete(Administrador entity) {
        LocalizacaoDatabase.databaseWriteExecutor.execute(() -> {
            dao.delete(entity);
        });
    }

}