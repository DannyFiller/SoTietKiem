package com.example.sotietkiem.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sotietkiem.MainActivity;
import com.example.sotietkiem.R;
import com.example.sotietkiem.SignInActivity;


public class InfoFragment extends Fragment {
    TextView tvTen,tvPassword,tvPhone,tvGmail;
    ImageView ivEditName,ivEditPhone,ivEditGmail;

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
                SignInActivity.loginUser = null;
            }
        });

        return v;
    }
}