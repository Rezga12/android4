package com.example.meishvili.revaz.mynewfinalprojectapplication.network;

import com.example.meishvili.revaz.mynewfinalprojectapplication.model.assetsandliabilities.AssetsAndLiabilities;
import com.example.meishvili.revaz.mynewfinalprojectapplication.model.cards.Card;
import com.example.meishvili.revaz.mynewfinalprojectapplication.model.clientinfo.ClientInfo;
import com.example.meishvili.revaz.mynewfinalprojectapplication.model.login.Login;
import com.example.meishvili.revaz.mynewfinalprojectapplication.model.transactions.Transactions;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface Api {
    @GET("api/Clients/Login/{username}/{password}")
    Call<Login> getLogin(@Path("username") String username, @Path("password") String password);


    @GET("api/Clients/ClientInfo")
    Call<ClientInfo> getClientInfo();


    @GET("api/Products/AssetsAndLiabilities")
    Call<AssetsAndLiabilities> getAssetsAndLiabilities();


    @GET("api/Products/Transactions")
    Call<Transactions> getTransactions();


    @GET("api/Products/Cards")
    Call<List<Card>> getCards();

}
