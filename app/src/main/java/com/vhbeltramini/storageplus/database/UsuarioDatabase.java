//package com.vhbeltramini.storageplus.database;
//
//
//import android.content.Context;
//
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//
//import com.vhbeltramini.storageplus.dao.UsuarioDao;
//import com.vhbeltramini.storageplus.model.Usuario;
//
//@Database(entities = {Usuario.class}, exportSchema = false, version = 1)
//public abstract class UsuarioDatabase extends RoomDatabase{
//
//    private static final String DB_NAME = "dbstorageplus";
//    private static UsuarioDatabase instance;
//
//    public static synchronized UsuarioDatabase getInstance(Context context) {
//        if (instance == null) {
//            instance = Room.databaseBuilder(context.getApplicationContext(), UsuarioDatabase.class, DB_NAME)
//                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
//        }
//        return instance;
//    }
//
//    public abstract UsuarioDao usuarioDao();
//
//}
