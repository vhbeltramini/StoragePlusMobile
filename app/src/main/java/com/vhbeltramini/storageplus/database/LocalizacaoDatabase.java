package com.vhbeltramini.storageplus.database;


import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.vhbeltramini.storageplus.dao.LocalizacaoDao;
import com.vhbeltramini.storageplus.dao.UsuarioDao;
import com.vhbeltramini.storageplus.model.Localizacao;
import com.vhbeltramini.storageplus.model.Usuario;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Localizacao.class}, version = 1)
public abstract class LocalizacaoDatabase extends RoomDatabase {

    public abstract LocalizacaoDao localizacaoDao();
    private static final String DB_NAME = "dbstorageplus";
    private static LocalizacaoDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized LocalizacaoDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), LocalizacaoDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .addCallback(sRoomDatabaseCallback)
                    .build();
        }
        return INSTANCE;
    }


    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                LocalizacaoDao dao = INSTANCE.localizacaoDao();

                dao.insert(new Localizacao("Galpão A", "Rua Tiradentes, 85"));
                dao.insert(new Localizacao("Galpão B", "Rua Mariana Marx, 85"));


                Log.i("usuariosssssssssss", dao.getAll().toString());
            });
        }
    };

}
