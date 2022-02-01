//package com.vhbeltramini.storageplus.model;
//
//import androidx.room.Embedded;
//import androidx.room.Entity;
//
//@Entity(tableName = "tbfuncionario")
//public class Funcionario extends Usuario {
//
//    @Embedded(prefix = "tbestoque")
//    private Estoque estoque;
//
//    @Embedded(prefix = "tbpermissao")
//    public Permissao permissao;
//  //  @Relation(parentColumn = "tbpermissaoid", entityColumn = "id", entity = Permissao.class)
//  //  private List<Permissao> permissoes;
//
//    public Funcionario(Estoque estoque, String nome, String senha, String email) {
//        super(nome, senha, email);
//        this.estoque = estoque;
//    }
//
//    public Estoque getEstoque() {
//        return estoque;
//    }
//
////    public List<Permissao> getPermissoes() {
////        return permissoes;
////    }
//
//    public void setEstoque(Estoque estoque) {
//        this.estoque = estoque;
//    }
//
//    public Permissao getPermissao() {
//        return permissao;
//    }
//
//    public void setPermissao(Permissao permissao) {
//        this.permissao = permissao;
//    }
//
////    public void setPermissoes(List<Permissao> permissoes) {
////        this.permissoes = permissoes;
////    }
//}