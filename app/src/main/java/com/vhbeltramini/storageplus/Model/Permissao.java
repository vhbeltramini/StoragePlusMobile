package com.vhbeltramini.storageplus.Model;

public class Permissao {
    private int id;
    private String nome;
    private String descricao;

    public Permissao(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
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

    @java.lang.Override
    public java.lang.String toString() {
        return "Permissao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}