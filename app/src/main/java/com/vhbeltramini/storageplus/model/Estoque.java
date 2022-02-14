package com.vhbeltramini.storageplus.model;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import static java.util.Objects.nonNull;

@Entity(tableName = "tbestoque")
public class Estoque implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Long id;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "descricao")
    private String descricao;

    @Embedded(prefix = "tblocalizacao")
    private Localizacao localizacao;

    @Embedded(prefix = "tbusuario")
    private Usuario usuario;

    @Ignore
    public Estoque(String nome, String descricao, Localizacao localizacao, Usuario usuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.usuario = usuario;
    }

    public Estoque() {
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Estoque{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", localizacao=" + localizacao +
                ", administrador=" + usuario.toString() +
                '}';
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean hasValidId() {
        return nonNull(id) && id > 0;
    }
}