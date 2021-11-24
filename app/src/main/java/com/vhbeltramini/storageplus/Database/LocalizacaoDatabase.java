package com.vhbeltramini.storageplus.Database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.vhbeltramini.storageplus.Dao.LocalizacaoDao;
import com.vhbeltramini.storageplus.Model.Localizacao;

@Database(entities = {Localizacao.class}, exportSchema = false, version = 1)
public abstract class LocalizacaoDatabase extends RoomDatabase{

    private static final String DB_NAME = "dbstorageplus";
    private static LocalizacaoDatabase instance;

    public static synchronized LocalizacaoDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), LocalizacaoDatabase.class, DB_NAME)
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract LocalizacaoDao localizacaoDao();

}
