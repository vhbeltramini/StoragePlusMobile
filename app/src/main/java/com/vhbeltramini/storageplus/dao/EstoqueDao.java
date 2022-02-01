package com.vhbeltramini.storageplus.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.vhbeltramini.storageplus.model.Estoque;

import java.util.List;

@Dao
public interface EstoqueDao {

    @Query("SELECT * FROM tbestoque")
    LiveData<List<Estoque>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Estoque estoque);

    @Delete
    void delete(Estoque estoque);

    @Update
    void update(Estoque estoque);

    @Query("DELETE FROM tbestoque")
    void deleteAll();

}
