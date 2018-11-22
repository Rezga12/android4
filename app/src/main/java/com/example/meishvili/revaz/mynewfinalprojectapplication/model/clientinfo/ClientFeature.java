package com.example.meishvili.revaz.mynewfinalprojectapplication.model.clientinfo;

public class ClientFeature {

    /* "Contact": "sample string 1",
      "Route": "sample string 2",
      "DefaultContact": "sample string 3",
      "ContactName": "sample string 4",
      "Mail": "sample string 5",
      "Mobile": {},
      "Device": {}*/

    private String Contact;
    private String Route;
    private String DefaultContact;
    private String Mail;
    private String Mobile;
    private String Device;

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getRoute() {
        return Route;
    }

    public void setRoute(String route) {
        Route = route;
    }

    public String getDefaultContact() {
        return DefaultContact;
    }

    public void setDefaultContact(String defaultContact) {
        DefaultContact = defaultContact;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getDevice() {
        return Device;
    }

    public void setDevice(String device) {
        Device = device;
    }
}
