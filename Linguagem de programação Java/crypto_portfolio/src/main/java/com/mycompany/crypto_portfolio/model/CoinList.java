package com.mycompany.crypto_portfolio.model;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinList {

    private ArrayList<String> myCoinsSymbol;
    private ArrayList<Coin> coinList;

    public CoinList() {
        this.coinList = new ArrayList<>();
        this.myCoinsSymbol = new ArrayList<>(Arrays.asList("ada", "grt", "uni", "link", "zil"));
    }

    public CoinList(ArrayList<Coin> coinList) {
        this.coinList = coinList;
        this.myCoinsSymbol = new ArrayList<>(Arrays.asList("ada", "grt", "uni", "link", "zil"));
    }

    public ArrayList<String> getMyCoinsSymbol() {
        return myCoinsSymbol;
    }

    public void setMyCoinsSymbol(ArrayList<String> myCoinsSymbol) {
        this.myCoinsSymbol = myCoinsSymbol;
    }

    public ArrayList<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(ArrayList<Coin> coinList) {
        this.coinList = coinList;
    }

    public void addCoin(Coin coin){
        coinList.add(coin);
    }
    
}
