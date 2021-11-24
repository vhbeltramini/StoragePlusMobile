package com.vhbeltramini.storageplus.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.vhbeltramini.storageplus.Model.Atributo;

import java.util.List;

@Dao
public interface AtributoDao {

    @Query("SELECT * FROM tbatributo")
    List<Atributo> getAtributos();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAtributo(Atributo atributo);

    @Delete
    void deleteAtributo(Atributo atributo);

    @Query("UPDATE tbatributo SET valor=:valor,  idatributodinamico=:idAtributoDinamico")
    void updateAtributo(String valor, int idAtributoDinamico);

}
