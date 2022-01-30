//package com.vhbeltramini.storageplus.model;
//
//import androidx.room.ColumnInfo;
//import androidx.room.Entity;
//import androidx.room.PrimaryKey;
//
//@Entity(tableName = "tbpermissao")
//public class Permissao {
//
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "id")
//    private int id;
//
//    @ColumnInfo(name = "nome")
//    private String nome;
//
//    @ColumnInfo(name = "descricao")
//    private String descricao;
//
//    public Permissao(String nome, String descricao) {
//        this.nome = nome;
//        this.descricao = descricao;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getDescricao() {
//        return descricao;
//    }
//
//    public void setDescricao(String descricao) {
//        this.descricao = descricao;
//    }
//
//    @java.lang.Override
//    public java.lang.String toString() {
//        return "Permissao{" +
//                "id=" + id +
//                ", nome='" + nome + '\'' +
//                ", descricao='" + descricao + '\'' +
//                '}';
//    }
//}