package com.vhbeltramini.storageplus.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.vhbeltramini.storageplus.model.AtributoDinamico;

import java.util.List;

@Dao
public interface AtributoDinamicoDao {

    @Query("SELECT * FROM tbatributodinamico")
    List<AtributoDinamico> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(AtributoDinamico atributo);

    @Delete
    void delete(AtributoDinamico atributo);

    @Update
    void update(AtributoDinamico atributo);

}
