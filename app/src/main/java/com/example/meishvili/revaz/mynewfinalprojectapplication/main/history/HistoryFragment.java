package com.example.meishvili.revaz.mynewfinalprojectapplication.main.history;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.meishvili.revaz.mynewfinalprojectapplication.R;
import com.example.meishvili.revaz.mynewfinalprojectapplication.model.transactions.Transactions;
import com.example.meishvili.revaz.mynewfinalprojectapplication.network.Api;
import com.example.meishvili.revaz.mynewfinalprojectapplication.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HistoryFragment extends Fragment {

    public static HistoryFragment newInstance(String sessionId) {

        Bundle args = new Bundle();
        args.putString("id",sessionId);
        HistoryFragment fragment = new HistoryFragment();
        fragment.setArguments(args);
        return fragment;
    }


    private TextView incomeAmountText;
    private TextView outcomeAmountText;

    private RecyclerView recyclerView;

    private HistoryRecViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_history,container,false);

        incomeAmountText = view.findViewById(R.id.history_income_amount);
        outcomeAmountText = view.findViewById(R.id.history_outcome_amount);

        recyclerView = view.findViewById(R.id.history_rec_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new HistoryRecViewAdapter();
        recyclerView.setAdapter(adapter);

        getTransactionHistory();
        return view;
    }

    private void getTransactionHistory(){

        Retrofit retrofit = RetrofitInstance.getRetrofitInstance(getArguments().getString("id"));
        Api api = retrofit.create(Api.class);

        api.getTransactions().enqueue(new Callback<Transactions>() {
            @Override
            public void onResponse(Call<Transactions> call, Response<Transactions> response) {
                //Log.i("Assert",response.body().getIncomeSum().toString());
                adapter.setData(response.body().getMyOperations());
                incomeAmountText.setText(response.body().getIncomeSum().toString());
                outcomeAmountText.setText(response.body().getOutcomeSum().toString());
            }

            @Override
            public void onFailure(Call<Transactions> call, Throwable t) {
                Log.i("Assert",t.getMessage());
            }
        });


    }
}
