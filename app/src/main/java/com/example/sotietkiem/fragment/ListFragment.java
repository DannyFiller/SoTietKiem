package com.example.sotietkiem.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sotietkiem.ListAdapter;
import com.example.sotietkiem.ListAdapter.ListViewHolder;
import com.example.sotietkiem.R;
import com.example.sotietkiem.SignInActivity;

import java.util.ArrayList;
import java.util.List;

import InOut.DetailActivity;
import data.QuerySoTietKiem;
import data.SoTietKiem;


 public class ListFragment extends Fragment implements ListAdapter.ListCallBack{

    ListAdapter listAdapter;
    ArrayList<SoTietKiem> lstStk;
    RecyclerView rcSoTietKiem;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        lstStk = QuerySoTietKiem.ListSoTietKiem(getContext(), SignInActivity.loginUser);
        listAdapter = new ListAdapter(lstStk,this);

        rcSoTietKiem =v.findViewById(R.id.rcSoTietKiem);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcSoTietKiem.setAdapter(listAdapter);
        rcSoTietKiem.setLayoutManager(layoutManager);


//        rcSoTietKiem.setAdapter(new ListAdapter(getContext()));
        return v;
    }

     @Override
     public void OnItemClick(int id) {
        Intent i = new Intent(getActivity(), DetailActivity.class);
        startActivity(i);
     }


 }