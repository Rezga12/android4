
package com.example.meishvili.revaz.mynewfinalprojectapplication.model.assetsandliabilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Asset {

    @SerializedName("ProductType")
    @Expose
    private String productType;
    @SerializedName("AmountBase")
    @Expose
    private Double amountBase;
    @SerializedName("ProductName")
    @Expose
    private String productName;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Double getAmountBase() {
        return amountBase;
    }

    public void setAmountBase(Double amountBase) {
        this.amountBase = amountBase;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}
