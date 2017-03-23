package BSHELPER;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlite extends SQLiteOpenHelper {
    public String usuarios = "CREATE TABLE usuarios(idusuario INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,apellidos TEXT," +
            "edad INTEGER)";
    public sqlite(Context context,String name,SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(usuarios);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
