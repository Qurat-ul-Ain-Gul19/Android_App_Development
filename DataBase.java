package pk.edu.uiit.Arid2432.Registrationform;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {

    private static final String database_name = "MyDatabase";
    private static final String table_name = "signup";
    private static final String table_col_name = "signup";
    private static final int db_version = 1;
    SQLiteDatabase sqLiteDatabase;

    public DataBase(Context context) {
        super(context, database_name, null, db_version);
        sqLiteDatabase = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS " + table_name + "( name VARCHAR,email VARCHAR,password VARCHAR,phone VARCHAR,country VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + table_name);
        onCreate(db);
    }

    public long signup(String email, String password, String name, String Gender, String Subject) {

        //  SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("phone", Gender);
        contentValues.put("country", Subject);
        long user_data = sqLiteDatabase.insert(table_name, null, contentValues);
        return user_data;

    }

    public Cursor login(String email, String password) {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor user_data = sqLiteDatabase.rawQuery("SELECT name from " + table_name + " WHERE email='" + email + "'" + "AND password ='" + password + "'", null);

        return user_data;
    }


}

