package ffscompany.howmanytimes.DB;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConnection extends SQLiteOpenHelper {
    //DB Stats
    public static final String DBNAME = "howmanytimes.db";
    // Versão
    public static final int VERSAO = 1;
    //Tables
    public static final String USER = "USER";
    public static final String TASK = "TASK";
    // COMMON COLUMNS
    public static final String ID = "id";
    public static final String NAME = "name";
    // USER TABLE
    // HAS ID
    // HAS NAME
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String REMINDER = "reminder";
    public static final String EMAIL = "email";
    // TASK TABLE
    // HAS ID
    // HAS NAME
    public static final String CREATIONDATE  = "creation_date";
    public static final String DOTIMES = "doTimes";

    public DBConnection(Context context){
        super(context, DBNAME,null,3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE TASK("
                + "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "NAME TEXT,"
                + "DOTIMES INTEGER,"
                + "PHOTOID INTEGER,"
                + "CREATION_DATE STRING);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TASK);
        onCreate(db);
    }

}
