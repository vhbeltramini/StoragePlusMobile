package com.vhbeltramini.storageplus.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

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

    @Query("UPDATE tblocalizacao SET nome=:nome,  descricao=:descricao")
    void update(String nome, String descricao);

    @Query("DELETE FROM tblocalizacao")
    void deleteAll();

}
