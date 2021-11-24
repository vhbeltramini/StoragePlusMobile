package com.vhbeltramini.storageplus.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "tbproduto")
public class Produto {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idlocalizacao")
    private int id;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "descricao")
    private String descricao;

    @ColumnInfo(name = "qtdestoque")
    private int qtdEstoque;

    @ColumnInfo(name = "idlocalizacao")
    private Localizacao localizacao;

    @ColumnInfo(name = "urlImage")
    private String urlImage;

    @ColumnInfo(name = "qtdminestoque")
    private int qtdMinEstoque;

    private List<Categoria> categorias;

    private List<Atributo> atributos;

    @Ignore
    public Produto(String nome, String descricao, int qtdEstoque, Localizacao localizacao, int qtdMinEstoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.qtdEstoque = qtdEstoque;
        this.localizacao = localizacao;
        this.qtdMinEstoque = qtdMinEstoque;
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

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public String getUrlImagem() {
        return urlImage;
    }

    public void setUrlImagem(String UrlImagem) {
        this.urlImage = UrlImagem;
    }

    public int getQtdMinEstoque() {
        return qtdMinEstoque;
    }

    public void setQtdMinEstoque(int qtdMinEstoque) {
        this.qtdMinEstoque = qtdMinEstoque;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public List<Atributo> getAtributos() {
        return atributos;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", qtdEstoque=" + qtdEstoque +
                ", localizacao=" + localizacao +
                ", imagem=" + urlImage +
                ", qtdMinEstoque=" + qtdMinEstoque +
                ", categorias=" + categorias +
                ", atributos=" + atributos +
                '}';
    }
}