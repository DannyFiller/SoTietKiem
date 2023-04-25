package com.example.sotietkiem.fragment;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sotietkiem.ListAdapter;
import com.example.sotietkiem.ListAdapter.ListViewHolder;
import com.example.sotietkiem.R;
import com.example.sotietkiem.SignInActivity;

import java.util.ArrayList;
import java.util.List;

import InOut.DetailActivity;
import data.DataQuery;
import data.QuerySoTietKiem;
import data.SoTietKiem;


 public class ListFragment extends Fragment implements ListAdapter.ListCallBack{

    public static ListAdapter listAdapter;
    static public ArrayList<SoTietKiem> lstStk;
    RecyclerView rcSoTietKiem;

    static public SoTietKiem curList;
    private SearchView searchView;
//    private List<SoTietKiem>






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


         //Tạo thanh tìm kiếm
         searchView = v.findViewById(R.id.searchView);
         searchView.clearFocus();
         searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
             @Override
             public boolean onQueryTextSubmit(String query) {
                 return false;
             }

             @Override
             public boolean onQueryTextChange(String newText) {
                 filterList(newText);
                 return false;
             }
         });

        return v;
    }

     private void filterList(String text) {
         ArrayList<SoTietKiem> filterList = new ArrayList<>();
         for (SoTietKiem stk : lstStk){
             if(stk.getTenSo().toLowerCase().contains(text.toLowerCase())){
                 filterList.add(stk);
             }
         }
         
         if(filterList.isEmpty()){
             Toast.makeText(getContext(), "không tìm thấy sổ", Toast.LENGTH_SHORT).show();
         }
         else {
             setFilteredList(filterList);
         }
     }

     @Override
     public void OnItemClick(int id,SoTietKiem stk) {
        Intent i = new Intent(getActivity(), DetailActivity.class);
        i.putExtra("ten",lstStk.get(id).getTenSo());
        i.putExtra("tien",String.valueOf(lstStk.get(id).getTienTietKiem()));
        i.putExtra("han",lstStk.get(id).getDaoHan());
        i.putExtra("date",lstStk.get(id).getDate());
        curList = new SoTietKiem(lstStk.get(id).getId(),lstStk.get(id).getTenSo(),lstStk.get(id).getDate(),lstStk.get(id).getDaoHan(),lstStk.get(id).getTienTietKiem());
        startActivity(i);
     }

     @Override
     public void setFilteredList(ArrayList<SoTietKiem> filteredList) {
             ListAdapter.lstStk =  filteredList;
             listAdapter.notifyDataSetChanged();
     }


//     void resetData()
//     {
//         lstStk.clear();
//         lstStk.addAll(DataQuery.getAll(getContext()));
//         listAdapter.notifyDataSetChanged();
//     }

//     @Override
//     public void DeleteClick(int id,SoTietKiem stk) {
//         boolean rs = QuerySoTietKiem.delete(getActivity(), id);
//         if(rs)
//         {
//             Toast.makeText(getContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();
////             resetData();
//         }
//         else
//         {
//             Toast.makeText(getContext(), "Xóa thất bại", Toast.LENGTH_SHORT).show();
//         }
//     }



 }