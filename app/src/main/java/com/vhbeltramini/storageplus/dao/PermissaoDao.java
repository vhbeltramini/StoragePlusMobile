//package com.vhbeltramini.storageplus.dao;
//
//import androidx.room.Dao;
//import androidx.room.Delete;
//import androidx.room.Insert;
//import androidx.room.OnConflictStrategy;
//import androidx.room.Query;
//
//import com.vhbeltramini.storageplus.model.Permissao;
//
//import java.util.List;
//
//@Dao
//public interface PermissaoDao {
//
//    @Query("SELECT * FROM tbpermissao")
//    List<Permissao> getPermissoes();
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    void insertPermissao(Permissao permissao);
//
//    @Delete
//    void deletePermissao(Permissao permissao);
//
//    @Query("UPDATE tbpermissao SET nome=:nome,  descricao=:descricao")
//    void updatePermissao(String nome, String descricao);
//
//}
