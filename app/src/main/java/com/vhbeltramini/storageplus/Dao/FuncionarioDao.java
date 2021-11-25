package com.vhbeltramini.storageplus.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.vhbeltramini.storageplus.Model.Funcionario;

import java.util.List;

@Dao
public interface FuncionarioDao {

    @Query("SELECT * FROM tbfuncionario")
    List<Funcionario> getFuncionarios();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertFuncionario(Funcionario funcionario);

    @Delete
    void deleteFuncionario(Funcionario funcionario);

    @Query("UPDATE tbfuncionario SET nome=:nome,  senha=:senha, email=:email, tbestoqueid=:idEstoque")
    void updateAdministrador(String nome, String senha, String email, int idEstoque);

}
