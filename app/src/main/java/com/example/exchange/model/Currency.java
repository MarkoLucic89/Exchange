package com.example.exchange.model;

import java.io.Serializable;

public class Currency implements Serializable {

    public int imageUrl;
    public String shortName;
    public String fullName;
    public double valuePerDollar;

    public Currency(int imageUrl, String shortName, String fullName, double valuePerDollar) {
        this.imageUrl = imageUrl;
        this.shortName = shortName;
        this.fullName = fullName;
        this.valuePerDollar = valuePerDollar;
    }
}
