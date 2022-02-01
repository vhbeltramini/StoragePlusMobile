package com.vhbeltramini.storageplus.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.vhbeltramini.storageplus.model.Categoria;

import java.util.List;

@Dao
public interface CategoriaDao {

    @Query("SELECT * FROM tbcategoria")
    List<Categoria> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Categoria categoria);

    @Delete
    void delete(Categoria categoria);

    @Update
    void update(Categoria categoria);

}
