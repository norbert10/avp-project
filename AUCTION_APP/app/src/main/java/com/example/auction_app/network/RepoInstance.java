package com.example.auction_app.network;

import com.example.auction_app.data.BidItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RepoInstance {
    @POST("/placebid")
    Call<BidItem> postBid(@Body BidItem item);
    @GET("/getbids")
    Call<List<BidItem>> getBids();
}
