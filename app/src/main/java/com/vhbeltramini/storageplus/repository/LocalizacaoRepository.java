package com.vhbeltramini.storageplus.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.vhbeltramini.storageplus.dao.LocalizacaoDao;
import com.vhbeltramini.storageplus.database.LocalizacaoDatabase;
import com.vhbeltramini.storageplus.model.Localizacao;

import java.util.List;

public class LocalizacaoRepository {

    private LocalizacaoDao dao;
    private LiveData<List<Localizacao>> allEntities;

    public LocalizacaoRepository(Application application) {
        LocalizacaoDatabase db = LocalizacaoDatabase.getInstance(application);
        dao = db.localizacaoDao();
        allEntities = dao.getAll();
    }

    public LiveData<List<Localizacao>> getAll() {
        return allEntities;
    }

    public void insert(Localizacao entity) {
        LocalizacaoDatabase.databaseWriteExecutor.execute(() -> {
            dao.insert(entity);
        });
    }

    public void delete(Localizacao entity) {
        LocalizacaoDatabase.databaseWriteExecutor.execute(() -> {
            dao.delete(entity);
        });
    }

    public void edit(Localizacao entity) {
        LocalizacaoDatabase.databaseWriteExecutor.execute(() -> {
            dao.update(entity);
        });
    }



}
