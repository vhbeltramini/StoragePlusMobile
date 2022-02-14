package com.vhbeltramini.storageplus.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.vhbeltramini.storageplus.dao.CategoriaDao;
import com.vhbeltramini.storageplus.database.CategoriaDatabase;
import com.vhbeltramini.storageplus.model.Categoria;

import java.util.List;

public class CategoriaRepository {

    private CategoriaDao dao;
    private LiveData<List<Categoria>> allEntities;

    public CategoriaRepository(Application application) {
        CategoriaDatabase db = CategoriaDatabase.getInstance(application);
        dao = db.categoriaDao();
        allEntities = dao.getAll();
    }

    public LiveData<List<Categoria>> getAll() {
        return allEntities;
    }

    public Categoria getByid(Long id) {
        return dao.getById(id);
    }

    public void insert(Categoria entity) {
        CategoriaDatabase.databaseWriteExecutor.execute(() -> {
            dao.insert(entity);
        });
    }

    public void delete(Categoria entity) {
        CategoriaDatabase.databaseWriteExecutor.execute(() -> {
            dao.delete(entity);
        });
    }

    public void edit(Categoria entity) {
        CategoriaDatabase.databaseWriteExecutor.execute(() -> {
            dao.update(entity);
        });
    }

}