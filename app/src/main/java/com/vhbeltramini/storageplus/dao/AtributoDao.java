//package com.vhbeltramini.storageplus.dao;
//
//import androidx.room.Dao;
//import androidx.room.Delete;
//import androidx.room.Insert;
//import androidx.room.OnConflictStrategy;
//import androidx.room.Query;
//
//import com.vhbeltramini.storageplus.model.Atributo;
//
//import java.util.List;
//
//@Dao
//public interface AtributoDao {
//
//    @Query("SELECT * FROM tbatributo")
//    List<Atributo> getAtributos();
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    void insertAtributo(Atributo atributo);
//
//    @Delete
//    void deleteAtributo(Atributo atributo);
//
//    @Query("UPDATE tbatributo SET valor=:valor,  tbatributoDinamicoid=:idAtributoDinamico")
//    void updateAtributo(String valor, int idAtributoDinamico);
//
//}