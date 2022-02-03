package com.vhbeltramini.storageplus.model;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import static java.util.Objects.nonNull;

@Entity(tableName = "tbusuario")
public class Usuario implements Serializable {

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    protected Long id;

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
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

    @Override
    public java.lang.String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean hasValidId() {
        return nonNull(id) && id > 0;
    }
}
