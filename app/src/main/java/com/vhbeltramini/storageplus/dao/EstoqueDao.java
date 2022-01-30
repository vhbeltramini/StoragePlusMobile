package com.vhbeltramini.storageplus.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.vhbeltramini.storageplus.model.Estoque;

import java.util.List;

@Dao
public interface EstoqueDao {

    @Query("SELECT * FROM tbestoque")
    LiveData<List<Estoque>> getEstoques();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Estoque estoque);

    @Delete
    void delete(Estoque estoque);

//    @Query("UPDATE tbestoque SET nome=:nome,  descricao=:descricao, tblocalizacaoid=:idLocalizacao, tbadministradorid=:idAdministrador")
    @Query("UPDATE tbestoque SET nome=:nome,  descricao=:descricao")
    void update(String nome, String descricao);

    @Query("DELETE FROM tbestoque")
    void deleteAll();

}
