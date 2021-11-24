package com.vhbeltramini.storageplus.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbestoque")
public class Estoque {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idestoque")
    private int id;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "descricao")
    private String descricao;

    @ColumnInfo(name = "idlocalizacao")
    private Localizacao localizacao;

    @ColumnInfo(name = "idadministrador")
    private Administrador administrador;

    @Ignore
    public Estoque(String nome, String descricao, Localizacao localizacao, Administrador administrador) {
        this.nome = nome;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.administrador = administrador;
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

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Estoque{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", localizacao=" + localizacao +
                ", administrador=" + administrador +
                '}';
    }
}