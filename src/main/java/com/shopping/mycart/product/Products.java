package com.shopping.mycart.product;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class Products implements Serializable {


    @JsonProperty("productName")
       String productName;

    @JsonProperty("prductQuantity")
       int prductQuantity;




    public Products(int prductQuantity,String productName) {
        this.productName = productName;
        this.prductQuantity=prductQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrductQuantity() {
        return prductQuantity;
    }

    public void setPrductQuantity(int prductQuantity) {
        this.prductQuantity = prductQuantity;
    }



   /* @Override
    public String toString() {
        return productName ;
    }*/

    @Override
    public String toString() {
        return "Products{" +
                "productName='" + productName + '\'' +
                ", prductQuantity=" + prductQuantity +
                '}';
    }


}
