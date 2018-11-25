package com.example.meishvili.revaz.mynewfinalprojectapplication.main.history;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.meishvili.revaz.mynewfinalprojectapplication.R;
import com.example.meishvili.revaz.mynewfinalprojectapplication.model.transactions.MyOperation;

import java.util.ArrayList;
import java.util.List;

public class HistoryRecViewAdapter extends RecyclerView.Adapter<HistoryRecViewHolder> {


    private List<MyOperation> data = new ArrayList<>();

    @NonNull
    @Override
    public HistoryRecViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_history,viewGroup,false);

        return new HistoryRecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryRecViewHolder historyRecViewHolder, int i) {
        historyRecViewHolder.setData(data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void  setData(List<MyOperation> data){
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }
}
