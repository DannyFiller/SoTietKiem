package com.example.sotietkiem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sotietkiem.fragment.ListFragment;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import data.QuerySoTietKiem;
import data.SoTietKiem;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    ArrayList<SoTietKiem> lstStk;
    ArrayList<SoTietKiem> listFind;
    Context context;
    ListCallBack listCallBack;


    public ListAdapter(ArrayList<SoTietKiem> lstStk,ListCallBack listCallBack)
    {
        this.lstStk = lstStk;
        this.listCallBack = listCallBack;
    }

//    public void SetListCallBack(ListCallBack listCallBack) {this.listCallBack = listCallBack;}

    @NonNull
    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View listView = inflater.inflate(R.layout.itemlayout,parent,false);
        ListViewHolder viewHolder = new ListViewHolder(listView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ListViewHolder holder, int position) {
        SoTietKiem item =lstStk.get(position);

        holder.tvNameSo.setText(item.getTenSo());
//        holder.tvTien.setText(String.valueOf(item.getTienTietKiem()));
//        holder.tvTien.setText(item.getDate());
        holder.itemView.setOnClickListener(view -> listCallBack.OnItemClick(position,item));
//        holder.btnXoa.setOnClickListener(view -> listCallBack.DeleteClick(position,item));
    }

    @Override
    public int getItemCount() {
        return lstStk.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvNameSo,tvTien;
        Button btnXoa;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameSo = itemView.findViewById(R.id.tvName);
//            tvTien = itemView.findViewById(R.id.tvTienStk);
//            btnXoa = itemView.findViewById(R.id.btXoa);
        }
    }

//    public Filter getFiller(){
//
//        return filler;
//    }
//
//    Filter filler = new Filter() {
//        // run on background
//        @Override
//        protected FilterResults performFiltering(CharSequence charSequence) {
//            if(charSequence.toString().isEmpty()){
////                list.addAll(QuerySoTietKiem.ListTenSoTietKiem(context,SignInActivity.loginUser));
//                lstStk = listFind;
//            }
//            else
//            {
//                ArrayList<SoTietKiem> list = new ArrayList<>();
//                for(SoTietKiem stk : listFind)
//                {
//                    if(stk.getTenSo().toLowerCase().contains(charSequence.toString().toLowerCase()))
//                    {
//                        list.add(stk);
//                    }
//                }
//                lstStk = list;
//            }
//            FilterResults filterResults = new FilterResults();
//            filterResults.values = lstStk;
//            return  filterResults;
//        }
//
//        //run on ui
//        @Override
//        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
//            lstStk = (ArrayList<SoTietKiem>) filterResults.values;
////            lstStk.addAll((Collection<? extends SoTietKiem>) filterResults.values);
//            notifyDataSetChanged();
//        }
//    };




    public interface ListCallBack {
        void OnItemClick(int id,SoTietKiem stk);
//        void DeleteClick(int id,SoTietKiem stk);
//        }
    }
}

