package com.example.auction_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.auction_app.data.BidItem;
import com.example.auction_app.viewmodel.MainViewModel;

import org.w3c.dom.Text;

public class Bids extends AppCompatActivity {
TextView start,end,bids;
EditText price;
BidItem item;
Button bid;
MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bids);
        start = findViewById(R.id.start);
        end = findViewById(R.id.end);
        bids = findViewById(R.id.bids);
        price = findViewById(R.id.price);
        bid = findViewById(R.id.bid);
        viewModel = new ViewModelProvider.AndroidViewModelFactory(this.getApplication()).create(MainViewModel.class);
        initIntent();
        bid.setOnClickListener(this::sendBidBtn);

    }
    void initIntent(){
        Intent intent = getIntent();
        item = intent.getParcelableExtra("bid");
        start.setText(item.getStart());
        end.setText(item.getEnd());
        bids.setText(item.getBids());

    }

    public void sendBidBtn(final View view){
        BidItem mItem = new BidItem(item.getStart(),item.getEnd(),item.getPrice(),item.getImageUrl(),price.getText().toString().trim());
        viewModel.postBid(mItem);
        Intent intent = new Intent(this, Response.class);
        startActivity(intent);
    }
}