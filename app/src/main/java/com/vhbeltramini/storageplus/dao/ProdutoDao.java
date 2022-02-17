package com.vhbeltramini.storageplus.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.vhbeltramini.storageplus.model.Produto;

import java.util.List;

@Dao
public interface ProdutoDao {

    @Query("SELECT * FROM tbproduto")
    LiveData<List<Produto>> getAll();

    @Query("SELECT * FROM tbproduto where id=:id")
    Produto getById(Long id);

    @Query("SELECT * FROM tbproduto where tbestoqueid=:id")
    LiveData<List<Produto>> getByEstoqueId(Long id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Produto entity);

    @Delete
    void delete(Produto entity);

    @Update
    void update(Produto entity);

}
