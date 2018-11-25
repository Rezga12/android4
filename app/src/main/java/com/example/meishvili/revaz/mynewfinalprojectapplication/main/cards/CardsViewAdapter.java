package com.example.meishvili.revaz.mynewfinalprojectapplication.main.cards;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.meishvili.revaz.mynewfinalprojectapplication.R;
import com.example.meishvili.revaz.mynewfinalprojectapplication.model.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class CardsViewAdapter extends RecyclerView.Adapter<CardsViewHolder> {

    private List<Card> data = new ArrayList<>();


    @NonNull
    @Override
    public CardsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_card,viewGroup,false);

        return new CardsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardsViewHolder cardsViewHolder, int i) {
        cardsViewHolder.setData(data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Card> data){
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }
}
