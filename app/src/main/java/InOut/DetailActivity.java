package InOut;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

//        btnRutStk.setOnClickListener(view -> addUserDialog());
        btnGuiStk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(DetailActivity.this);
                alertDialog.setTitle("Rút tiền");
                LayoutInflater inflater = DetailActivity.this.getLayoutInflater();
                View dialogView =inflater.inflate(R.layout.dialog_layout,null);
                alertDialog.setView(dialogView);
                EditText edRut = findViewById(R.id.edRutStk);

                alertDialog.setPositiveButton("Dông Ý",(dialog,which) -> {
                    String name = edRut.getText().toString();
                });
            }
        });

        btnRutStk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

//    void addUserDialog(){
//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(DetailActivity.this);
//        alertDialog.setTitle("Rút tiền");
//        LayoutInflater inflater = DetailActivity.this.getLayoutInflater();
//        View dialogView =inflater.inflate(R.layout.dialog_layout,null);
//        alertDialog.setView(dialogView).setPositiveButton()
//        EditText edRut = findViewById(R.id.edRutStk);
//
////        alertDialog.setPositiveButton("Dông Ý",(dialog,which) -> {
////            String name = edRut.getText().toString();
////        });
//
//        alertDialog.create();
//        alertDialog.show();
//    }
}