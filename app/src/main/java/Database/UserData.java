//package Database;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
//import android.provider.ContactsContract;
//import android.util.Log;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserData {
//    private SQLiteDatabase database;
//    private DatabaseHandler dbHelper;
//
//    private String[] allColumns = {DatabaseHandler.COLUMN_USERNAME,DatabaseHandler.COLUMN_PASSWORD,DatabaseHandler.COLUM_NAME};
//
//    public UserData(Context context)
//    {
//        dbHelper = new DatabaseHandler(context);
//    }
//
//    public void open() throws SQLException{
//        database = dbHelper.getWritableDatabase();
//    }
//
//    public void close()
//    {
//        dbHelper.close();
//    }
//
//    public  User CreateUser(String userName, String password)
//    {
//        ContentValues values = new ContentValues();
//        values.put(DatabaseHandler.COLUMN_USERNAME,userName);
//        values.put(DatabaseHandler.COLUMN_PASSWORD,password);
//
//
//        long insertId = database.insert(DatabaseHandler.TABLE_NAME,null,values);
//        Cursor cursor = database.query(DatabaseHandler.TABLE_NAME,allColumns,
//                DatabaseHandler.COLUMN_ID + " = " + insertId,
//                null,null,null,null);
//        cursor.moveToFirst();
//        User newUser = cursortoUser(cursor);
//        cursor.close();
//
//        Log.e("SQLite", "Đã tạo");
//
//        return  newUser;
//    }
//
//    public void deleteUser(User user)
//    {
//        String id = user.getUserName();
//        Log.e("SQLite", "User entry deleted with id: " + id);
//        database.delete(DatabaseHandler.TABLE_NAME,DatabaseHandler.COLUMN_ID + " = "+ id,null );
//    }
//
//    private User cursortoUser(Cursor cursor)
//    {
//        User user = new User();
//        user.setId ((cursor.getLong(0)));
//        user.setUserName((cursor.getString(1)));
//        user.setPassword((cursor.getString(2)));
//        user.setName((cursor.getString(3)));
//        return  user;
//    }
//
//    public List<User> getAllUsers(){
//        List<User> users = new ArrayList<>();
//
//        Cursor cursor = database.query(DatabaseHandler.TABLE_NAME,allColumns,null,null,null,null,null);
//
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast())
//        {
//            User user = cursortoUser(cursor);
//            users.add(user);
//            cursor.moveToNext();
//        }
//        cursor.close();
//        return users;
//    }
//}
