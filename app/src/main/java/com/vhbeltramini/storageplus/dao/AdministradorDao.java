package com.vhbeltramini.storageplus.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.vhbeltramini.storageplus.model.Administrador;

import java.util.List;

@Dao
public interface AdministradorDao {

    @Query("SELECT * FROM tbadministrador")
    LiveData<List<Administrador>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Administrador administrador);

    @Delete
    void delete(Administrador administrador);

    @Query("UPDATE tbadministrador SET nome=:nome,  senha=:senha, email=:email")
    void update(String nome, String senha, String email);

    @Query("DELETE FROM tbadministrador")
    void deleteAll();

}
