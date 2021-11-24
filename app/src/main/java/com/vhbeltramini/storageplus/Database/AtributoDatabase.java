package com.vhbeltramini.storageplus.Database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.vhbeltramini.storageplus.Dao.AtributoDao;
import com.vhbeltramini.storageplus.Model.Atributo;

@Database(entities = {Atributo.class}, exportSchema = false, version = 1)
public abstract class AtributoDatabase extends RoomDatabase{

    private static final String DB_NAME = "dbstorageplus";
    private static AtributoDatabase instance;

    public static synchronized AtributoDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AtributoDatabase.class, DB_NAME)
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract AtributoDao atributoDao();

}
