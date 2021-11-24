package com.vhbeltramini.storageplus.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.vhbeltramini.storageplus.Model.Administrador;

import java.util.List;

@Dao
public interface AdministradorDao {

    @Query("SELECT * FROM tbadministrador")
    List<Administrador> getAdministrador();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAdministrador(Administrador administrador);

    @Delete
    void deleteAdministrador(Administrador administrador);

    @Query("UPDATE tbadministrador SET nome=:nome,  senha=:senha, email=:email")
    void updateAdministrador(String nome, String senha, String email);

}
