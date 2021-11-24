package com.vhbeltramini.storageplus.Model;

public class AtributoDinamico {
    private int id;
    private String nome;
    private String descricao;
    private Categoria categoria;

    public AtributoDinamico(String nome, String descricao, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "AtributoDinamico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}