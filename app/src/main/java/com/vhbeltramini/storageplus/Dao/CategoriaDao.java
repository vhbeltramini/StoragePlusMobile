package com.vhbeltramini.storageplus.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.vhbeltramini.storageplus.Model.Categoria;

import java.util.List;

@Dao
public interface CategoriaDao {

    @Query("SELECT * FROM tbcategoria")
    List<Categoria> getCategorias();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertCategoria(Categoria categoria);

    @Delete
    void deleteCategoria(Categoria categoria);

    @Query("UPDATE tbcategoria SET nome=:nome,  senha=:senha, email=:email")
    void updateCategoria(String nome, String senha, String email);

}
