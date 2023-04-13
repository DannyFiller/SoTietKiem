package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {



    //tên và id database
    private static final String DATABASE_NAME = "DoAn1";
    private static final int DATABASE_VERSION = 1;

    //Các cột trong database

//    tạo bảng
//    private static final String TABLE_CREATE = "CREATE TABLE "
//            + TABLE_NAME
//            + "("
//            + COLUMN_ID + " INTER PRIMARY KEY AUTOINCREMENT, "
//            + COLUMN_USERNAME +" TEXT,"
//            + COLUMN_PASSWORD + " TEXT,"
//            + COLUMN_MONEY +" INT  );";




    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_USER_TABLE = " CREATE TABLE " + Utils.TABLE_NAME + "("
                + Utils.COLUMN_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Utils.COLUMN_USERNAME+ " TEXT, "
                + Utils.COLUMN_PASSWORD+" TEXT, "
                + Utils.COLUMN_MONEY + " INT "
                +")";
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);

        String CREATE_SoTietKiem_TABLE = " CREATE TABLE " + Utils.TABLE_NAME1 + "("
                + Utils.COLUMN_ID_SOTIETKIEM+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Utils.COLUMN_ID_USER+ " int, "
                + Utils.COLUMN_NAME_SO+" TEXT, "
                + Utils.COLUMN_MONEY_SO + " INT "
                +")";
        sqLiteDatabase.execSQL(CREATE_SoTietKiem_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Utils.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }






//    public int show()
//    {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//
//        Cursor cursor= db.query((TABLE_NAME,allColumns,"username",null,null,null,null);
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_USERNAME, String.valueOf(cursor));
//    }


}
