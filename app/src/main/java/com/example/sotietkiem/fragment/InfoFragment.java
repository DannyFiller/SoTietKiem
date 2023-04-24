package com.example.sotietkiem.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sotietkiem.MainActivity;
import com.example.sotietkiem.R;
import com.example.sotietkiem.SignInActivity;

import InOut.DetailActivity;
import data.DataQuery;


public class InfoFragment extends Fragment {
    TextView tvTen,tvPassword,tvPhone,tvGmail;
    ImageButton ivEditName,ivEditPhone,ivEditGmail;

    Button btnLgOut;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_info, container, false);

        tvTen = v.findViewById(R.id.tvUserNameInfo);
//        tvPassword = v.findViewById(R.id.tvPasswordInfo);
        tvPhone = v.findViewById(R.id.tvPhoneInfo);
        tvGmail = v.findViewById(R.id.tvGmailInfo);
        ivEditName = v.findViewById(R.id.ivEditName);
        ivEditPhone = v.findViewById(R.id.ivEditPhone);
        ivEditGmail = v.findViewById(R.id.ivEditGmail);
        btnLgOut = v.findViewById(R.id.btnLgOut);

        //lấy thông tin từ Intent SignIn

//        Bundle goi = getActivity().getIntent().getExtras();
        String ten = SignInActivity.loginUser.getUserName();
        String password = SignInActivity.loginUser.getPassword();
        String std = String.valueOf(SignInActivity.loginUser.getPhoneNumber());
        String gmail = SignInActivity.loginUser.getEmail();

        tvTen.setText(ten);
//        tvPassword.setText(password);
        tvPhone.setText(std);
        tvGmail.setText(gmail);

//        ivEditName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        btnLgOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),SignInActivity.class);
                startActivity(i);
//                SignInActivity.loginUser = null;
            }
        });


        ivEditName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("Tên người dùng");
//                LayoutInflater inflater = DetailActivity.this.getLayoutInflater();
                View dialogView =getLayoutInflater().inflate(R.layout.dialog_layout_info,null);
                alertDialog.setView(dialogView);
                EditText edTen = (EditText) dialogView.findViewById(R.id.edInfo);


                alertDialog.setPositiveButton("OK", (dialog, which) -> {
                    String ten = edTen.getText().toString();
                    SignInActivity.loginUser.setUserName(ten);
                    DataQuery.UpdateName(getContext(),SignInActivity.loginUser);
                    dialog.dismiss();
                    tvTen.setText(SignInActivity.loginUser.getUserName());
                    Toast.makeText(getActivity(), "Đổi tên thành công", Toast.LENGTH_SHORT).show();
                });
                // create and show the alert dialog
                AlertDialog dialog = alertDialog.create();
                dialog.show();
            }
        });

        ivEditGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("Gmail");
//                LayoutInflater inflater = DetailActivity.this.getLayoutInflater();
                View dialogView =getLayoutInflater().inflate(R.layout.dialog_layout_info,null);
                alertDialog.setView(dialogView);
                EditText edGmail = (EditText) dialogView.findViewById(R.id.edInfo);


                alertDialog.setPositiveButton("OK", (dialog, which) -> {
                    String gmail = edGmail.getText().toString();
                    SignInActivity.loginUser.setEmail(gmail);
                    DataQuery.UpdateGmail(getContext(),SignInActivity.loginUser);
                    dialog.dismiss();
                    tvGmail.setText(SignInActivity.loginUser.getEmail());
                    Toast.makeText(getActivity(), "Đổi gmail thành công", Toast.LENGTH_SHORT).show();
                });
                // create and show the alert dialog
                AlertDialog dialog = alertDialog.create();
                dialog.show();
            }
        });

        ivEditPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("Số điển thoại");
//                LayoutInflater inflater = DetailActivity.this.getLayoutInflater();
                View dialogView =getLayoutInflater().inflate(R.layout.dialog_layout,null);
                alertDialog.setView(dialogView);
                EditText edPhone = (EditText) dialogView.findViewById(R.id.edRutStk);


                alertDialog.setPositiveButton("OK", (dialog, which) -> {
                    String phone = edPhone.getText().toString();
                    SignInActivity.loginUser.setPhoneNumber(Integer.parseInt(phone));
                    DataQuery.UpdatePhone(getContext(),SignInActivity.loginUser);
                    dialog.dismiss();
                    tvPhone.setText(String.valueOf(SignInActivity.loginUser.getPhoneNumber()));
                    Toast.makeText(getActivity(), "Đổi số diện thoại thành công", Toast.LENGTH_SHORT).show();
                });
                // create and show the alert dialog
                AlertDialog dialog = alertDialog.create();
                dialog.show();
            }
        });
        return v;
    }
}