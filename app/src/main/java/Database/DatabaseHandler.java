package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {



    //tên và id database
    private static final String DATABASE_NAME = "UserData";
    private static final int DATABASE_VERSION = 1;

    //Các cột trong database
    public static final String TABLE_NAME = "listUser";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";

    public static final String COLUMN_NAME = "name";



    private String[] allColumns = {DatabaseHandler.COLUMN_USERNAME,DatabaseHandler.COLUMN_PASSWORD};
    //tạo bảng
    private static final String TABLE_CREATE = "create table " + TABLE_NAME + "( " + COLUMN_ID + " integer primary key autoincrement, "+ COLUMN_USERNAME +" text not null," + COLUMN_PASSWORD + " text not null);";


    public DatabaseHandler(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void  addNewUser (String username,String password)
    {

        int i = 20;

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_ID,i);
        values.put(COLUMN_USERNAME,username);
        values.put(COLUMN_PASSWORD,password);

        db.insert(TABLE_NAME,null,values);

        db.close();
    }

//    public int show()
//    {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//
//        Cursor cursor= db.query((TABLE_NAME,allColumns,"username",null,null,null,null);
//
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_USERNAME, String.valueOf(cursor));
//    }


}
