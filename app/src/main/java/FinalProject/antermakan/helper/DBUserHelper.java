package FinalProject.antermakan.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import FinalProject.antermakan.models.User;

public class DBUserHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "DB_USER";
    private static final int DB_VERSION = 1;

    private static final String TABLE_USER = "user";
    private static final String TABLE_USER_ID = "id";
    private static final String TABLE_USER_NAMA = "nama";
    private static final String TABLE_USER_EMAIL = "email";
    private static final String TABLE_USER_TELPON = "telpon";
    private static final String TABLE_USER_ALAMAT = "alamat";
    private static final String TABLE_USER_PASSWORD = "password";

    public DBUserHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreateUser = "CREATE TABLE " + TABLE_USER + "(" + TABLE_USER_NAMA + " TEXT," + TABLE_USER_EMAIL + " TEXT," + TABLE_USER_TELPON + " TEXT," + TABLE_USER_ALAMAT + " TEXT," + TABLE_USER_PASSWORD + " TEXT" + ")";
        db.execSQL(queryCreateUser);
    }
//+ TABLE_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

    public ArrayList<User> get_users(){
        ArrayList<User> users = new ArrayList<User>();
        String queryGetAllUser = "SELECT * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(queryGetAllUser, null);

        if(cursor.moveToFirst()){
            do{
                String nama = cursor.getString(0);
                String email = cursor.getString(1);
                String telpon = cursor.getString(2);
                String alamat = cursor.getString(3);
                String password = cursor.getString(4);

                users.add(new User(nama, email, telpon, alamat, password));

            }while(cursor.moveToNext());
        }

        return users;
    }

    public void insert_user(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
//        cv.put("id", user.getId());
        cv.put(TABLE_USER_NAMA, user.getNama());
        cv.put(TABLE_USER_EMAIL, user.getEmail());
        cv.put(TABLE_USER_TELPON, user.getTelpon());
        cv.put(TABLE_USER_ALAMAT, user.getAlamat());
        cv.put(TABLE_USER_PASSWORD, user.getPassword());
        db.insert(TABLE_USER, null, cv);
    }
}