package InOut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.sotietkiem.MainActivity;
import com.example.sotietkiem.R;
import com.example.sotietkiem.SignInActivity;

import java.text.DateFormat;
import java.util.Calendar;

import data.DataQuery;
import data.QuerySoTietKiem;
import data.SoTietKiem;

public class MoneyInActivity extends AppCompatActivity {

    Button btnGui;
    EditText edTen,edSodu,edGuiTien,edNoiDung;

    AutoCompleteTextView acKyHanView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_in);


        edTen = findViewById(R.id.edTenUser);
        edSodu = findViewById(R.id.edSodu);
        btnGui = findViewById(R.id.btnGui);
        edGuiTien = findViewById(R.id.edGuiTien);
        edNoiDung = findViewById(R.id.edNoiDung);

        edTen.setText(SignInActivity.loginUser.getUserName());
        edSodu.setText(String.valueOf(SignInActivity.loginUser.getMoney()));
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String soTienGui = edGuiTien.getText().toString().trim();
                String noiDung = edNoiDung.getText().toString().trim();

                SoTietKiem SoMoi = new SoTietKiem(SignInActivity.loginUser.getId(),noiDung,Integer.parseInt(soTienGui));
                QuerySoTietKiem.insert(MoneyInActivity.this,SoMoi);

                if(Integer.parseInt(soTienGui) < SignInActivity.loginUser.getMoney())
                {
                    Tru();
                    Intent i = new Intent(MoneyInActivity.this,MainActivity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MoneyInActivity.this, "Tài khoản của bạn không đủ để gửi tiết kiệm", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    void Tru(){
        String sotien = edGuiTien.getText().toString();
        int a = Integer.parseInt(sotien);
        int b = SignInActivity.loginUser.getMoney();
        int c = b - a;
        SignInActivity.loginUser.setMoney(c);
        DataQuery.insertMoney(MoneyInActivity.this,SignInActivity.loginUser);
    }
}