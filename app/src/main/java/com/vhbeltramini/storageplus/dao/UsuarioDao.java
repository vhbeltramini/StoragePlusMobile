package com.vhbeltramini.storageplus.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.vhbeltramini.storageplus.model.Usuario;

import java.util.List;

@Dao
public interface UsuarioDao {

    @Query("SELECT * FROM tbusuario")
    LiveData<List<Usuario>> getAll();

    @Query("SELECT * FROM tbusuario where id=:id")
    Usuario getById(Long id);

    @Query("SELECT * FROM tbusuario where email=:email")
    Usuario getByEmail(String email);

    @Query("SELECT * FROM tbusuario where isAdmin=1")
    LiveData<List<Usuario>> getAllAdminUsers();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Usuario usuario);

    @Delete
    void delete(Usuario usuario);

    @Update
    void update(Usuario usuario);

    @Query("DELETE FROM tbusuario")
    void deleteAll();

}
