package com.vhbeltramini.storageplus.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbatributo")
public class Atributo {

    @ColumnInfo(name = "idatributodinamico")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "valor")
    private String valor;

    @ColumnInfo(name = "idatributodinamico")
    private AtributoDinamico atributoDinamico;

    @Ignore
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