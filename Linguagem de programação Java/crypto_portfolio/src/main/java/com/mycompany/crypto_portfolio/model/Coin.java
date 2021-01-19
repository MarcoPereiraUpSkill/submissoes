
package com.mycompany.crypto_portfolio.model;

import java.util.Objects;

public class Coin {
    private String name;
    private String id;
    private double price;
    
    private static final String DEFAULT_NAME = "Undefined";
    private static final String DEFAULT_ID = "UND";
    private static final double DEFAULT_PRICE = 0;

    public Coin(String name, String id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public Coin() {
        name = DEFAULT_NAME;
        id = DEFAULT_ID;
        price = DEFAULT_PRICE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coin other = (Coin) obj;
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Coin{" + "name=" + name + ", id=" + id + ", price=" + price + '}';
    }
    
    
}
