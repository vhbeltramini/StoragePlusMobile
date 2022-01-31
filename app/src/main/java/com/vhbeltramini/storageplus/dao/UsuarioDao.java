package com.vhbeltramini.storageplus.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.vhbeltramini.storageplus.model.Usuario;

import java.util.List;

@Dao
public interface UsuarioDao {

    @Query("SELECT * FROM tbusuario")
    LiveData<List<Usuario>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Usuario usuario);

    @Delete
    void delete(Usuario usuario);

    @Query("UPDATE tbusuario SET nome=:nome,  senha=:senha, email=:email")
    void update(String nome, String senha, String email);

    @Query("DELETE FROM tbusuario")
    void deleteAll();

}
