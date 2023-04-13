package com.example.sotietkiem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import data.DataQuery;
import data.DatabaseHandler;
import data.User;

//import data.DatabaseHandler;

public class RegisterActivity extends AppCompatActivity {

    EditText edUserName, edPassword,edPhone,edConfimrPassword,edGmail;
    Button btDangKy;
    Context context;

//    private SharedPreferences.Editor editor;
//    SharedPreferences sharedPreferences;

    SQLiteDatabase database ;


//    private final Gson gson = new Gson();
    DatabaseHandler helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        sharedPreferences = getSharedPreferences(Utils.SHARE_PREFERENCES_APP, Context.MODE_PRIVATE);
//        editor = sharedPreferences.edit();
        anhxa();

        btDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edUserName.getText().toString().trim();
                String password = edPassword.getText().toString().trim();
                String rePassword = edConfimrPassword.getText().toString().trim();
                int phone = Integer.valueOf(edPhone.getText().toString().trim());
                String gmail = edGmail.getText().toString().trim();

                DataQuery query = new DataQuery();;
                User CPuser = query.checkLogin(RegisterActivity.this,name,password);

                if (CPuser!=null)
                {
                    Toast.makeText(RegisterActivity.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(rePassword.equals(password))
                    {
                        User user = new User(0,name,password,phone,gmail,50);
                        DataQuery.insertUser(RegisterActivity.this,user);

                        Intent i = new Intent(RegisterActivity.this, SignInActivity.class  );
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                    }
                }

                
            }
        });


    }


    void anhxa()
    {
        btDangKy = findViewById(R.id.btDK);

        edUserName = findViewById(R.id.edUserNameRe);
        edPassword = findViewById(R.id.edPaswordRe);
        edConfimrPassword = findViewById(R.id.edConfirmPasswordRe);
        edPhone = findViewById(R.id.edPhoneNumberRe);
        edGmail = findViewById(R.id.edGmailRe);
    }


}