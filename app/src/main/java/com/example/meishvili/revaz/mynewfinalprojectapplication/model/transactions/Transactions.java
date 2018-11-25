
package com.example.meishvili.revaz.mynewfinalprojectapplication.model.transactions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Transactions {

    @SerializedName("OutcomeSum")
    @Expose
    private Double outcomeSum;
    @SerializedName("IncomeSum")
    @Expose
    private Double incomeSum;
    @SerializedName("MyOperations")
    @Expose
    private List<MyOperation> myOperations = null;

    public Double getOutcomeSum() {
        return outcomeSum;
    }

    public void setOutcomeSum(Double outcomeSum) {
        this.outcomeSum = outcomeSum;
    }

    public Double getIncomeSum() {
        return incomeSum;
    }

    public void setIncomeSum(Double incomeSum) {
        this.incomeSum = incomeSum;
    }

    public List<MyOperation> getMyOperations() {
        return myOperations;
    }

    public void setMyOperations(List<MyOperation> myOperations) {
        this.myOperations = myOperations;
    }

}
