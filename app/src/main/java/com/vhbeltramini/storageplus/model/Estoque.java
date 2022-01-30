package com.vhbeltramini.storageplus.model;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tbestoque")
public class Estoque implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "descricao")
    private String descricao;
//
//    @Embedded(prefix = "tblocalizacao")
//    private Localizacao localizacao;
//
//    @Embedded(prefix = "tbadministrador")
//    private Administrador administrador;

    public Estoque(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

//    public Localizacao getLocalizacao() {
//        return localizacao;
//    }
//
//    public void setLocalizacao(Localizacao localizacao) {
//        this.localizacao = localizacao;
//    }
//
//    public Administrador getAdministrador() {
//        return administrador;
//    }
//
//    public void setAdministrador(Administrador administrador) {
//        this.administrador = administrador;
//    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Estoque{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
//                ", localizacao=" + localizacao +
//                ", administrador=" + administrador +
                '}';
    }

    public boolean hasValidId() {
        return id > 1;
    }
}