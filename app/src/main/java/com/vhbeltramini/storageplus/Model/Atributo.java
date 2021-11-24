package com.vhbeltramini.storageplus.Model;

public class Atributo {
    private int id;
    private String valor;
    private AtributoDinamico atributoDinamico;

    public Atributo(String valor, AtributoDinamico atributoDinamico) {
        this.valor = valor;
        this.atributoDinamico = atributoDinamico;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public AtributoDinamico getAtributoDinamico() {
        return atributoDinamico;
    }

    public void setAtributoDinamico(AtributoDinamico atributoDinamico) {
        this.atributoDinamico = atributoDinamico;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Atributo{" +
                "id=" + id +
                ", valor='" + valor + '\'' +
                ", atributoDinamico=" + atributoDinamico +
                '}';
    }
}