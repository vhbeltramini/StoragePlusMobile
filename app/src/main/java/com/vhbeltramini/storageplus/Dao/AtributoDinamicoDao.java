package com.vhbeltramini.storageplus.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.vhbeltramini.storageplus.Model.AtributoDinamico;

import java.util.List;

@Dao
public interface AtributoDinamicoDao {

    @Query("SELECT * FROM tbatributodinamico")
    List<AtributoDinamico> getAtributosDinamicos();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAtributoDinamico(AtributoDinamico atributo);

    @Delete
    void deleteAtributoDinamico(AtributoDinamico atributo);

    @Query("UPDATE tbatributodinamico SET nome=:nome,  descricao=:descricao, tbcategoriaid=:idCategoria")
    void updateAtributoDinamico(String nome, String descricao, int idCategoria);

}
