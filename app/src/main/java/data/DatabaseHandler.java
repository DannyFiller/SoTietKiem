package data;

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
    public static final String COLUMN_USERNAME ="username";
    public static final String COLUMN_PASSWORD ="password";

    public static final String COLUMN_ID = "id";

    public static final String COLUMN_MONEY = "money";


    //Bảng SoTietKiem
    public static final String TABLE_NAME1 = "SoTietKiem";
    public static final String COLUMN_ID_SOTIETKIEM = "id";
    public static final String COLUMN_ID_USER = "idUser";
    public static final String COLUMN_NAME_SO = "tenSo";
    public static final String COLUMN_MONEY_SO = "soTien";



    private String[] allColumns = {DatabaseHandler.COLUMN_USERNAME,DatabaseHandler.COLUMN_PASSWORD};
//    tạo bảng
    private static final String TABLE_CREATE = "CREATE TABLE "
            + TABLE_NAME
            + "( "
            + COLUMN_ID + " INTER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_USERNAME +" TEXT,"
            + COLUMN_PASSWORD + " TEXT,"
            + COLUMN_MONEY +" INT  );";




    public DatabaseHandler(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "
                + TABLE_NAME
                + "( "
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_USERNAME +" TEXT,"
                + COLUMN_PASSWORD + " TEXT,"
                + COLUMN_MONEY +" INT  );");

        db.execSQL("CREATE TABLE "
                + TABLE_NAME1
                + "( "
                + COLUMN_ID_SOTIETKIEM + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_ID_USER +" INT NOT NULL,"
                + COLUMN_NAME_SO + " TEXT,"
                + COLUMN_MONEY_SO +" INT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        this.onCreate(db);
    }

    public void  addNewUser (String username,String password)
    {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME,username);
        values.put(COLUMN_PASSWORD,password);

        db.insert(TABLE_NAME,null,values);
    }

    public void opendb ()
    {
        SQLiteDatabase db = getWritableDatabase();

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
