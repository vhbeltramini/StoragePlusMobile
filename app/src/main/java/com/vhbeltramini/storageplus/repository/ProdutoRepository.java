package com.vhbeltramini.storageplus.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.vhbeltramini.storageplus.dao.CategoriaDao;
import com.vhbeltramini.storageplus.dao.ProdutoDao;
import com.vhbeltramini.storageplus.database.CategoriaDatabase;
import com.vhbeltramini.storageplus.database.ProdutoDatabase;
import com.vhbeltramini.storageplus.model.Categoria;
import com.vhbeltramini.storageplus.model.Produto;

import java.util.List;

public class ProdutoRepository {

    private ProdutoDao dao;
    private LiveData<List<Produto>> allEntities;

    public ProdutoRepository(Application application) {
        ProdutoDatabase db = ProdutoDatabase.getInstance(application);
        dao = db.produtoDao();
        allEntities = dao.getAll();
    }

    public LiveData<List<Produto>> getAll() {
        return allEntities;
    }

    public Produto getById(Long id) {
        return dao.getById(id);
    }

    public LiveData<List<Produto>> getByEstoqueId(Long id) {
        return dao.getByEstoqueId(id);
    }

    public void insert(Produto entity) {
        CategoriaDatabase.databaseWriteExecutor.execute(() -> {
            dao.insert(entity);
        });
    }

    public void delete(Produto entity) {
        CategoriaDatabase.databaseWriteExecutor.execute(() -> {
            dao.delete(entity);
        });
    }

    public void edit(Produto entity) {
        CategoriaDatabase.databaseWriteExecutor.execute(() -> {
            dao.update(entity);
        });
    }

}