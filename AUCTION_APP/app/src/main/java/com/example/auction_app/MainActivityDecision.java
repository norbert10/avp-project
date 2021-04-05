package com.example.auction_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.auction_app.data.BidItem;
import com.example.auction_app.viewmodel.MainViewModel;

import java.util.List;

public class MainActivityDecision extends AppCompatActivity {
RecyclerView recyclerView;
ItemAdapter adapter;
List<BidItem> modelList;
MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_decision);
        recyclerView = findViewById(R.id.bids_recycler);
        viewModel = new ViewModelProvider.AndroidViewModelFactory(this.getApplication()).create(MainViewModel.class);
    }
    void setUpRecycler(){
        viewModel.getBids().observe(this, new Observer<List<BidItem>>() {
            @Override
            public void onChanged(List<BidItem> bidItems) {
                modelList = bidItems;
                adapter = new ItemAdapter(modelList);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivityDecision.this));
                recyclerView.setClipToPadding(true);
                recyclerView.setAdapter(adapter);
            }
        });
    }


}