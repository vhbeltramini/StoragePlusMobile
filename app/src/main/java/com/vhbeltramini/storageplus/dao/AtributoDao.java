package com.vhbeltramini.storageplus.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.vhbeltramini.storageplus.model.Atributo;

import java.util.List;

@Dao
public interface AtributoDao {

    @Query("SELECT * FROM tbatributo")
    List<Atributo> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Atributo atributo);

    @Delete
    void delete(Atributo atributo);

    @Update
    void update(Atributo atributo);

}
