package com.example.meishvili.revaz.mynewfinalprojectapplication.model.clientinfo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClientInfo {

    @SerializedName("Client")
    private Client client;

    @SerializedName("ClientAddresses")
    private List<ClientAddress> clientAddresses;

    @SerializedName("ClientMails")
    private List<ClientFeature> clientMails;

    @SerializedName("ClientPhones")
    private List<ClientFeature> clientPhones;

    @SerializedName("ClientDevices")
    private List<ClientFeature> clientDevices;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ClientAddress> getClientAddresses() {
        return clientAddresses;
    }

    public void setClientAddresses(List<ClientAddress> clientAddresses) {
        this.clientAddresses = clientAddresses;
    }

    public List<ClientFeature> getClientMails() {
        return clientMails;
    }

    public void setClientMails(List<ClientFeature> clientMails) {
        this.clientMails = clientMails;
    }

    public List<ClientFeature> getClientPhones() {
        return clientPhones;
    }

    public void setClientPhones(List<ClientFeature> clientPhones) {
        this.clientPhones = clientPhones;
    }

    public List<ClientFeature> getClientDevices() {
        return clientDevices;
    }

    public void setClientDevices(List<ClientFeature> clientDevices) {
        this.clientDevices = clientDevices;
    }
}
