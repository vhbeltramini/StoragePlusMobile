package com.vhbeltramini.storageplus.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.vhbeltramini.storageplus.Model.Permissao;
import com.vhbeltramini.storageplus.Model.Produto;

import java.util.List;

@Dao
public interface ProdutoDao {

    @Query("SELECT * FROM tbproduto")
    List<Produto> getProdutos();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertProduto(Produto produto);

    @Delete
    void deleteProduto(Produto produto);

    @Query("UPDATE tbproduto SET nome=:nome,  descricao=:descricao, qtdestoque=:qtdEstoque, idlocalizacao=:idLocalizacao, urlImage=:urlImage, qtdminestoque=:qtdMinestoque")
    void updatePermissao(String nome, String descricao, int qtdEstoque, int idLocalizacao, String urlImage, int qtdMinestoque);

}
