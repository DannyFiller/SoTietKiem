package com.example.doan;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import Database.DatabaseHandler;

public class MainActivity extends AppCompatActivity {

    EditText edSoTien;
    Button btnXacNhan,btnDangNhap;
    TextView tvKetQua,tvTen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        edSoTien = findViewById(R.id.edSotien);
        btnXacNhan = findViewById(R.id.btnXacNhan);
        tvKetQua = findViewById(R.id.tvKetQua);
        tvTen = findViewById(R.id.tvTen );

        Bundle goi =  getIntent().getExtras();

        String usename = goi.getString("usename");

        tvTen.setText(usename);

        btnXacNhan.setOnClickListener(view -> Cong());

    }

    void ShowData(int rs){
        tvKetQua.setText(String.valueOf(rs));
    }

    void Cong(){
        String txtSoTienCong = edSoTien.getText().toString();
        String txtSoTienHienTai = tvKetQua.getText().toString();
        if (txtSoTienCong.isEmpty()){
            tvKetQua.setText("Số tiền hiện có");
            return;
        }
        int a = Integer.valueOf(txtSoTienHienTai);
        int b = Integer.valueOf(txtSoTienCong);

        int c = a+b;

        ShowData(c);
    }
}

