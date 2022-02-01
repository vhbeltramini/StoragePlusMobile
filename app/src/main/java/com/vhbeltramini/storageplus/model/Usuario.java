package com.vhbeltramini.storageplus.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbusuario")
public class Usuario {

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    protected int id;

    @ColumnInfo(name = "nome")
    protected String nome;

    @ColumnInfo(name = "senha")
    protected String senha;

    @ColumnInfo(name = "email")
    protected String email;

    @Ignore
    public Usuario(String nome, String senha, String email) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public Usuario() {
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

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public boolean hasValidId() {
        return id > 0;
    }
}
