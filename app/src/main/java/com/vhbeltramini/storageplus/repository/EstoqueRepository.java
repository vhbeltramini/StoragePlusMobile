package com.vhbeltramini.storageplus.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.vhbeltramini.storageplus.dao.EstoqueDao;
import com.vhbeltramini.storageplus.database.EstoqueDatabase;
import com.vhbeltramini.storageplus.model.Estoque;

import java.util.List;

public class EstoqueRepository {

    private EstoqueDao estoqueDao;
    private LiveData<List<Estoque>> mAllEstoques;

    public EstoqueRepository(Application application) {
        EstoqueDatabase db = EstoqueDatabase.getInstance(application);
        estoqueDao = db.estoqueDao();
        mAllEstoques = estoqueDao.getEstoques();
    }

    public LiveData<List<Estoque>> getAll() {
        return mAllEstoques;
    }

    public void insert(Estoque storage) {
        EstoqueDatabase.databaseWriteExecutor.execute(() -> {
            estoqueDao.insert(storage);
        });
    }

    public void delete(Estoque storage) {
        EstoqueDatabase.databaseWriteExecutor.execute(() -> {
            estoqueDao.delete(storage);
        });
    }

}
