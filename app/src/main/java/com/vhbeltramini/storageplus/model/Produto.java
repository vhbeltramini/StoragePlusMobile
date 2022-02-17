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

@Entity(tableName = "tbproduto")
public class Produto implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Long id;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "descricao")
    private String descricao;

    @ColumnInfo(name = "qtdestoque")
    private Integer qtdEstoque;

    @Embedded(prefix = "tbestoque")
    private Estoque estoque;

    @ColumnInfo(name = "urlImage")
    private String urlImage;

    @ColumnInfo(name = "qtdminestoque")
    private Integer qtdMinEstoque;

    @Embedded(prefix = "tbcategoria")
    private Categoria categoria;


    @Ignore
    public Produto(String nome, String descricao, int qtdEstoque, Estoque estoque, int qtdMinEstoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.qtdEstoque = qtdEstoque;
        this.estoque = estoque;
        this.qtdMinEstoque = qtdMinEstoque;
    }

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Integer getQtdMinEstoque() {
        return qtdMinEstoque;
    }

    public void setQtdMinEstoque(Integer qtdMinEstoque) {
        this.qtdMinEstoque = qtdMinEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public java.lang.String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", qtdEstoque=" + qtdEstoque +
                ", estoque=" + estoque +
                ", imagem=" + urlImage +
                ", qtdMinEstoque=" + qtdMinEstoque +
                ", categorias=" + categoria +
                '}';
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Boolean hasValidId() {
        return nonNull(id) && id > 0;
    }

}