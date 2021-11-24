package com.vhbeltramini.storageplus.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.vhbeltramini.storageplus.Model.Estoque;

import java.util.List;

@Dao
public interface EstoqueDao {

    @Query("SELECT * FROM tbestoque")
    List<Estoque> getEstoques();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertEstoque(Estoque estoque);

    @Delete
    void deleteEstoque(Estoque estoque);

    @Query("UPDATE tbestoque SET nome=:nome,  descricao=:descricao, idlocalizacao=:idLocalizacao, idadministrador=:idAdministrador")
    void updateEstoque(String nome, String descricao, int idLocalizacao, int idAdministrador);

}
