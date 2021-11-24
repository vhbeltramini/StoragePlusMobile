package com.vhbeltramini.storageplus.Model;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private int qtdEstoque;
    private Localizacao localizacao;
    private int imagem;
    private int qtdMinEstoque;
    private List<Categoria> categorias;
    private List<Atributo> atributos;

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

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
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
                ", imagem=" + imagem +
                ", qtdMinEstoque=" + qtdMinEstoque +
                ", categorias=" + categorias +
                ", atributos=" + atributos +
                '}';
    }
}