package com.vhbeltramini.storageplus.Model;

public class Funcionario extends Usuario {
    private Estoque estoque;
    private List<Permissao> permissoes;

    public Funcionario(Estoque estoque, String nome, String senha, String email) {
        this.estoque = estoque;
        permissoes = new List<Permissao>();
        super(nome, senha, email);
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public List<Permissao> getPermissoes() {
        return permissoes;
    }
}