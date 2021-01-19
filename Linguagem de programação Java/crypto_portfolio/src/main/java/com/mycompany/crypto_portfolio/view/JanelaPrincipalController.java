/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crypto_portfolio.view;


import com.mycompany.crypto_portfolio.controller.AplicacaoController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import org.json.JSONArray;

/**
 * FXML Controller class
 *
 * @author marco
 */
public class JanelaPrincipalController implements Initializable {

    @FXML
    private ListView<String> coinList;

    private AplicacaoController appController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        appController = new AplicacaoController();
    }

    @FXML
    private void updateCoinBtn(ActionEvent event) throws IOException {
        getCoins();
    }

    private void getCoins() throws MalformedURLException, IOException {
        HttpURLConnection con = null;
        String line;
        StringBuffer responseContent = new StringBuffer();
        BufferedReader reader;

        try {
            URL url = new URL("https://api.coingecko.com/api/v3/coins/markets?vs_currency=eur&order=market_cap_desc&per_page=100&page=1&sparkline=false");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            con.setRequestProperty("Content-Type", "application/json");

            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            int status = con.getResponseCode();

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }

            JSONArray content = parse(responseContent.toString());
            
            ArrayList<String> myCoins = appController.getMyCoinsSymbol();
            
            for(int i = 0; i < content.length(); i++){
                for(int a = 0; a < myCoins.size(); a++){
                    if(content.getJSONObject(i).get("symbol").toString().equalsIgnoreCase(myCoins.get(a))){
                        appController.addNewCoin(content.getJSONObject(i).get("name").toString(), content.getJSONObject(i).get("id").toString(), 
                                Double.parseDouble(content.getJSONObject(i).get("current_price").toString()));
                    }
                }
            }
            
            updateCoinView();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }

    public static JSONArray parse(String responseBody) {
        JSONArray coins = new JSONArray(responseBody);
        
        return coins;
    }
    
    public void updateCoinView(){
        ObservableList<String> items = FXCollections.observableArrayList();
        
        for(int i = 0; i < appController.getMyCoins().size(); i++){
            items.add(appController.getMyCoins().get(i).toString());
        }
        
        coinList.setItems(items);
    }
}
