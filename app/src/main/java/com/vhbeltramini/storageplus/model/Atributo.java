package com.vhbeltramini.storageplus.model;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbatributo")
public class Atributo {

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "valor")
    private String valor;

    @Embedded(prefix = "tbatributodinamico")
    private AtributoDinamico atributoDinamico;

    @Ignore
    public Atributo(String valor, AtributoDinamico atributoDinamico) {
        this.valor = valor;
        this.atributoDinamico = atributoDinamico;
    }

    public Atributo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public java.lang.String toString() {
        return "Atributo{" +
                "id=" + id +
                ", valor='" + valor + '\'' +
                ", atributoDinamico=" + atributoDinamico +
                '}';
    }
}