package com.vhbeltramini.storageplus.Model;

public class Categoria {
    private int id;
    private String nome;
    private String descricao;
    private Estoque estoque;

    public Categoria(String nome, String descricao, Estoque estoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.estoque = estoque;
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

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", estoque=" + estoque +
                '}';
    }
}