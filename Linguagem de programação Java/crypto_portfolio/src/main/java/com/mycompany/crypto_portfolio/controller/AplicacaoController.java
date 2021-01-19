
package com.mycompany.crypto_portfolio.controller;

import com.mycompany.crypto_portfolio.model.Coin;
import com.mycompany.crypto_portfolio.model.CoinList;
import java.util.ArrayList;

public class AplicacaoController {
    private CoinList coinList;

    public AplicacaoController() {
        coinList = new CoinList();
    }

    public ArrayList<String> getMyCoinsSymbol(){
        return coinList.getMyCoinsSymbol();
    }
    
    public ArrayList<Coin> getMyCoins(){
        return coinList.getCoinList();
    }
    
    public void addNewCoin(String name, String id, double price){
        Coin coin = new Coin(name, id, price);
        
        coinList.addCoin(coin);
    }
}
