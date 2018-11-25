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

    private static final int HEADER_VIEW = 0;
    private static final int INFO_VIEW = 1;

    private List<Object> data = new ArrayList<Object>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        if(i == HEADER_VIEW){
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_header,viewGroup,false);
            return new HeaderViewHolder(view);
        }

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_asset,viewGroup,false);



        return new AssetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Log.i("Assert","asdasdsad");
        if(data.get(i) instanceof String){
            ((HeaderViewHolder)viewHolder).setTitle((String)data.get(i));
        }else if(data.get(i) instanceof Pair){
            Pair pair = ((Pair) data.get(i));
            ((AssetViewHolder)viewHolder).setData(pair.first.toString(),pair.second.toString() + "");
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

    @Override
    public int getItemViewType(int position) {
        if(data.get(position) instanceof String){
            return HEADER_VIEW;
        }

        return INFO_VIEW;
    }

}
