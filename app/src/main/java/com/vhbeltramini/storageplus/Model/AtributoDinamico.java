package com.vhbeltramini.storageplus.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbatributodinamico")
public class AtributoDinamico {

    @ColumnInfo(name = "idatributodinamico")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "descricao")
    private String descricao;

    @ColumnInfo(name = "idcategoria")
    private Categoria categoria;

    @Ignore
    public AtributoDinamico(String nome, String descricao, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "AtributoDinamico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}