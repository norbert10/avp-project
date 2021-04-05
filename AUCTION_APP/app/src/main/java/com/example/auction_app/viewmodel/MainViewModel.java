package com.example.auction_app.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.auction_app.data.BidItem;
import com.example.auction_app.network.RepoInstance;
import com.example.auction_app.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    MutableLiveData<List<BidItem>> bids;
    BidItem mBid;
    public LiveData<List<BidItem>> getBids(){
        Call<List<BidItem>> bidCall = RetrofitInstance.getRetrofit().create(RepoInstance.class).getBids();
        bidCall.enqueue(new Callback<List<BidItem>>() {
            @Override
            public void onResponse(@NonNull Call<List<BidItem>> call,@NonNull Response<List<BidItem>> response) {
                bids = new MutableLiveData<>();
                bids.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<BidItem>> call,@NonNull Throwable t) {

            }
        });
        return bids;
    }
    public BidItem postBid(BidItem bid){
        Call<BidItem> postBidCall = RetrofitInstance.getRetrofit().create(RepoInstance.class).postBid(bid);
        postBidCall.enqueue(new Callback<BidItem>() {
            @Override
            public void onResponse(@NonNull Call<BidItem> call,@NonNull Response<BidItem> response) {
                if (response.isSuccessful()){
                    mBid = response.body();
                }
            }

            @Override
            public void onFailure(@NonNull Call<BidItem> call, @NonNull Throwable t) {

            }
        });
        return bid;
    }
}
