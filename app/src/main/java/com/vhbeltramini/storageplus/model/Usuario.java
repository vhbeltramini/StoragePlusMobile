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

    @ColumnInfo(name = "isAdmin")
    private Boolean isAdmin;

    @Ignore
    public Usuario(Long id, String nome, String senha, String email, Boolean isAdmin) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    @Ignore
    public Usuario(String nome, String senha, String email, Boolean isAdmin) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.isAdmin = isAdmin;
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

    public Boolean getIsAdmin() {
        return isAdmin;
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

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean hasValidId() {
        return nonNull(id) && id > 0;
    }
}
