//package com.vhbeltramini.storageplus.database;
//
//
//import android.content.Context;
//
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//
//import com.vhbeltramini.storageplus.dao.AdministradorDao;
//import com.vhbeltramini.storageplus.model.Administrador;
//
//@Database(entities = {Administrador.class}, exportSchema = false, version = 1)
//public abstract class AdministradorDatabase extends RoomDatabase{
//
//    private static final String DB_NAME = "dbstorageplus";
//    private static AdministradorDatabase instance;
//
//    public static synchronized AdministradorDatabase getInstance(Context context) {
//        if (instance == null) {
//            instance = Room.databaseBuilder(context.getApplicationContext(), AdministradorDatabase.class, DB_NAME)
//                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
//        }
//        return instance;
//    }
//
//    public abstract AdministradorDao administradorDao();
//
//}
