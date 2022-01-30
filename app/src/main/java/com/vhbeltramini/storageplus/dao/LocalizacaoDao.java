//package com.vhbeltramini.storageplus.dao;
//
//import androidx.room.Dao;
//import androidx.room.Delete;
//import androidx.room.Insert;
//import androidx.room.OnConflictStrategy;
//import androidx.room.Query;
//
//import com.vhbeltramini.storageplus.model.Localizacao;
//
//import java.util.List;
//
//@Dao
//public interface LocalizacaoDao {
//
//    @Query("SELECT * FROM tblocalizacao")
//    List<Localizacao> getAtributos();
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    void insertLocalizacao(Localizacao localizacao);
//
//    @Delete
//    void deleteLocalizacao(Localizacao localizacao);
//
//    @Query("UPDATE tblocalizacao SET nome=:nome,  descricao=:descricao")
//    void updateLocalizacao(String nome, String descricao);
//
//}
