//package com.vhbeltramini.storageplus.dao;
//
//import androidx.room.Dao;
//import androidx.room.Delete;
//import androidx.room.Insert;
//import androidx.room.OnConflictStrategy;
//import androidx.room.Query;
//import androidx.room.Update;
//
//import com.vhbeltramini.storageplus.model.Funcionario;
//
//import java.util.List;
//
//@Dao
//public interface FuncionarioDao {
//
//    @Query("SELECT * FROM tbfuncionario")
//    List<Funcionario> getAll();
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    void insert(Funcionario funcionario);
//
//    @Delete
//    void delete(Funcionario funcionario);
//
//    @Update
//    void update(String nome, String senha, String email, int idEstoque);
//
//}
