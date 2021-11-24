package com.vhbeltramini.storageplus.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;

import java.util.List;

@Entity(tableName = "tbfuncionario")
public class Funcionario extends Usuario {

    @ColumnInfo(name = "idestoque")
    private Estoque estoque;
    private List<Permissao> permissoes;

    @Ignore
    public Funcionario(Estoque estoque, String nome, String senha, String email) {
        super(nome, senha, email);
        this.estoque = estoque;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public List<Permissao> getPermissoes() {
        return permissoes;
    }
}