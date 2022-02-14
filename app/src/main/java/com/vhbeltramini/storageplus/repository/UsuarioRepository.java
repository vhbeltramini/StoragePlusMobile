package com.vhbeltramini.storageplus.repository;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;

import com.vhbeltramini.storageplus.dao.UsuarioDao;
import com.vhbeltramini.storageplus.database.UsuarioDatabase;
import com.vhbeltramini.storageplus.model.Usuario;

import java.util.Comparator;
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Usuario getLastCreatedUser() {
        return allEntities.getValue().stream().max(Comparator.comparing(Usuario::getId)).get();
    }

    public LiveData<List<Usuario>> getAllAdminUsers() {
        return dao.getAllAdminUsers();
    }

    public Usuario getByid(Long id) {
        return dao.getById(id);
    }

    public Usuario getByEmail(String email) {
        return dao.getByEmail(email);
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