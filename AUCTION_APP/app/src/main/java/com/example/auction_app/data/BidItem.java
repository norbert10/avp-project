package com.example.auction_app.data;

public class BidItem {
    String start, end,price, bids,imageUrl;

    public BidItem(String start, String end, String price, String bids,String imageUrl) {
        this.start = start;
        this.end = end;
        this.price = price;
        this.bids = bids;
        this.imageUrl = imageUrl;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBids() {
        return bids;
    }

    public void setBids(String bids) {
        this.bids = bids;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
