package com.vhbeltramini.storageplus.dao;

import androidx.lifecycle.LiveData;
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
    LiveData<List<Categoria>> getAll();

    @Query("SELECT * FROM tbcategoria where id=:id")
    Categoria getById(Long id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Categoria categoria);

    @Delete
    void delete(Categoria categoria);

    @Update
    void update(Categoria categoria);

}
