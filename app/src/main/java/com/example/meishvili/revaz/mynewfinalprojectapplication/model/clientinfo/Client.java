package com.example.meishvili.revaz.mynewfinalprojectapplication.model.clientinfo;

public class Client {
    /*"CategoryType": "sample string 1"
            "FirstName": "sample string 2",
            "LastName": "sample string 3",
            "FirstNameInt": "sample string 4",
            "LastNameInt": "sample string 5",
            "Sex": "sample string 6",
            "BirthDate": 7,
            "TranStatus": "sample string 8",
            "Resident": "sample string 9",
            "Pin": "sample string 10",
            "ClientCategory": "sample string 11"*/
    private String CategoryType;
    private String FirstName;
    private String LastName;
    private String FirstNameInt;
    private String LastNameInt;

    private String Sex;
    private String BirthDate;
    private String TranStatus;
    private String Resident;
    private String Pin;
    private String ClientCategory;

    public String getCategoryType() {
        return CategoryType;
    }

    public void setCategoryType(String categoryType) {
        CategoryType = categoryType;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstNameInt() {
        return FirstNameInt;
    }

    public void setFirstNameInt(String firstNameInt) {
        FirstNameInt = firstNameInt;
    }

    public String getLastNameInt() {
        return LastNameInt;
    }

    public void setLastNameInt(String lastNameInt) {
        LastNameInt = lastNameInt;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public String getTranStatus() {
        return TranStatus;
    }

    public void setTranStatus(String tranStatus) {
        TranStatus = tranStatus;
    }

    public String getResident() {
        return Resident;
    }

    public void setResident(String resident) {
        Resident = resident;
    }

    public String getPin() {
        return Pin;
    }

    public void setPin(String pin) {
        Pin = pin;
    }

    public String getClientCategory() {
        return ClientCategory;
    }

    public void setClientCategory(String clientCategory) {
        ClientCategory = clientCategory;
    }
}
