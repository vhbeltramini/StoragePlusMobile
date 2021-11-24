package com.vhbeltramini.storageplus.Database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.vhbeltramini.storageplus.Dao.EstoqueDao;
import com.vhbeltramini.storageplus.Model.Estoque;

@Database(entities = {Estoque.class}, exportSchema = false, version = 1)
public abstract class EstoqueDatabase extends RoomDatabase{

    private static final String DB_NAME = "dbstorageplus";
    private static EstoqueDatabase instance;

    public static synchronized EstoqueDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), EstoqueDatabase.class, DB_NAME)
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract EstoqueDao estoqueDao();

}
