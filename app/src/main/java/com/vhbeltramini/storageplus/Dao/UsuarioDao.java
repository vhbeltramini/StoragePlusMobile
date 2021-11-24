package com.vhbeltramini.storageplus.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.vhbeltramini.storageplus.Model.Usuario;

import java.util.List;

@Dao
public interface UsuarioDao {

    @Query("SELECT * FROM tbusuario")
    List<Usuario> getUsuarios();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUsuario(Usuario usuario);

    @Delete
    void deleteUsuario(Usuario usuario);

    @Query("UPDATE tbusuario SET nome=:nome,  senha=:senha, email=:email")
    void updateUsuario(String nome, String senha, String email);

}
