package InOut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sotietkiem.R;

public class DetailActivity extends AppCompatActivity {

    TextView tvTen,tvTien ;
    Button btnGuiStk,btnRutStk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTen = findViewById(R.id.tvTenStkDetail);
        tvTien = findViewById(R.id.tvSoTienTietkiem);

        Bundle goi = getIntent().getExtras();
        String ten =goi.getString("ten");
        String tien =goi.getString("tien");

        tvTen.setText(ten);
        tvTien.setText(tien+" VND");

        btnGuiStk=findViewById(R.id.btnNapStk);
        btnRutStk=findViewById(R.id.btnRutTienStk);

        btnGuiStk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnRutStk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

    }
}