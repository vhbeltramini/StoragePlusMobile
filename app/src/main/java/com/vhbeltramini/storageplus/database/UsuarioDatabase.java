package com.vhbeltramini.storageplus.database;


import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.vhbeltramini.storageplus.dao.UsuarioDao;
import com.vhbeltramini.storageplus.model.Usuario;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Usuario.class}, version = 3)
public abstract class UsuarioDatabase extends RoomDatabase {

    public abstract UsuarioDao usuarioDao();
    private static final String DB_NAME = "dbstorageplus";
    private static UsuarioDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized UsuarioDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), UsuarioDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
//                    .addCallback(sRoomDatabaseCallback)
                    .build();
        }
        return INSTANCE;
    }

//    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//
//            databaseWriteExecutor.execute(() -> {
//                UsuarioDao dao = INSTANCE.usuarioDao();
//                dao.deleteAll();
//
//                dao.insert(new Usuario("Victor Hugo", "1234", "vhbeltramini@gmail.com"));
//                dao.insert(new Usuario("Bruce", "1234", "bruce@gmail.com"));
//                Log.i("usuariosssssssssss", dao.getAll().toString());
//            });
//        }
//    };

}
