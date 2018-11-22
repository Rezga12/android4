package com.example.meishvili.revaz.mynewfinalprojectapplication.main.actives;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.meishvili.revaz.mynewfinalprojectapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ActivesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> data = new ArrayList<Object>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_recycle,viewGroup,false);



        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_asset,viewGroup,false);



        return new AssetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Log.i("Assert","asdasdsad");
        if(data.get(i) instanceof String){

        }else{
            Pair<String,Double> pair = ((Pair<String, Double>) data.get(i));
            ((AssetViewHolder)viewHolder).setData(pair.first,pair.second + "");
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void  setData(List<Object> data){
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();

    }
}
