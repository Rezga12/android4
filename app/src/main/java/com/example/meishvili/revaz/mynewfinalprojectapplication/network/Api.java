package com.example.meishvili.revaz.mynewfinalprojectapplication.network;

import com.example.meishvili.revaz.mynewfinalprojectapplication.model.assetsandliabilities.AssetsAndLiabilities;
import com.example.meishvili.revaz.mynewfinalprojectapplication.model.clientinfo.ClientInfo;
import com.example.meishvili.revaz.mynewfinalprojectapplication.model.login.Login;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface Api {
    @GET("api/Clients/Login/{username}/{password}")
    Call<Login> getLogin(@Path("username") String username, @Path("password") String password);

    @Headers({"Content-Type: application/json"})
    @GET("api/Clients/ClientInfo/{sessionId}")
    Call<ClientInfo> getClientInfo(@Path("sessionId") String sessionId);

    @Headers({"Content-Type: application/json"})
    @GET("api/Products/AssetsAndLiabilities/{sessionId}")
    Call<AssetsAndLiabilities> getAssetsAndLiabilities();

}
