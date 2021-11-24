package com.vhbeltramini.storageplus.Model;

public class Estoque {
    private int id;
    private String nome;
    private String descricao;
    private Localizacao localizacao;
    private Administrador administrador;

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