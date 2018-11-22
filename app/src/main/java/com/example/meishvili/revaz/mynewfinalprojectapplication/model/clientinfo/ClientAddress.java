package com.example.meishvili.revaz.mynewfinalprojectapplication.model.clientinfo;

public class ClientAddress {

    /*"AddressType": "sample string 1",
      "ClientKey": 2,
      "CountryCode": "sample string 3",
      "RegionCode": "sample string 4",
      "Street": "sample string 5",
      "Building": "sample string 6",
      "Appartment": 7,
      "District": "sample string 8",
      "NonCity": "sample string 9",
      "UrbanType": "sample string 10"*/

    private String AddressType;
    private Integer ClientKey;
    private String CountryCode;
    private String RegionCode;
    private String Street;
    private String Building;
    private Integer Appartment;
    private String District;
    private String NonCity;
    private String UrbanType;

    public String getAddressType() {
        return AddressType;
    }

    public void setAddressType(String addressType) {
        AddressType = addressType;
    }

    public Integer getClientKey() {
        return ClientKey;
    }

    public void setClientKey(Integer clientKey) {
        ClientKey = clientKey;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getRegionCode() {
        return RegionCode;
    }

    public void setRegionCode(String regionCode) {
        RegionCode = regionCode;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getBuilding() {
        return Building;
    }

    public void setBuilding(String building) {
        Building = building;
    }

    public Integer getAppartment() {
        return Appartment;
    }

    public void setAppartment(Integer appartment) {
        Appartment = appartment;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getNonCity() {
        return NonCity;
    }

    public void setNonCity(String nonCity) {
        NonCity = nonCity;
    }

    public String getUrbanType() {
        return UrbanType;
    }

    public void setUrbanType(String urbanType) {
        UrbanType = urbanType;
    }
}
