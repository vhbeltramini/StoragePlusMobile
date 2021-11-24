package com.vhbeltramini.storageplus.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tblocalizacao")
public class Localizacao {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idlocalizacao")
    private int id;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "descricao")
    private String descricao;

    @Ignore
    public Localizacao(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }


}
