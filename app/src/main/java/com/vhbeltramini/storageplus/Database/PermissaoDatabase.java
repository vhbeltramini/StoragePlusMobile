package com.vhbeltramini.storageplus.Database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.vhbeltramini.storageplus.Dao.LocalizacaoDao;
import com.vhbeltramini.storageplus.Dao.PermissaoDao;
import com.vhbeltramini.storageplus.Model.Localizacao;
import com.vhbeltramini.storageplus.Model.Permissao;

@Database(entities = {Permissao.class}, exportSchema = false, version = 1)
public abstract class PermissaoDatabase extends RoomDatabase{

    private static final String DB_NAME = "dbstorageplus";
    private static PermissaoDatabase instance;

    public static synchronized PermissaoDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), PermissaoDatabase.class, DB_NAME)
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract PermissaoDao permissaoDao();

}
