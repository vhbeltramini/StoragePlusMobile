package com.vhbeltramini.storageplus.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.vhbeltramini.storageplus.model.Localizacao;

import java.util.List;

@Dao
public interface LocalizacaoDao {

    @Query("SELECT * FROM tblocalizacao")
    LiveData<List<Localizacao>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Localizacao localizacao);

    @Delete
    void delete(Localizacao localizacao);

    @Update
    void update(Localizacao localizacao);

    @Query("DELETE FROM tblocalizacao")
    void deleteAll();

}
