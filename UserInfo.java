package com.example.rightsville_rental;
import java.time.*;

public class UserInfo {
    public String firstname;
    public String middlename;
    public String lastname;
    public String street;
    public String city;
    public String state;
    public String zipcode;
    public String card_no;
    public String card_exp;
    public String card_sec;
    public String days;
    public UserInfo(String firstname, String middlename, String lastname,String street, String city, String state, String zipcode,
                    String card_no, String card_exp, String card_sec, String days){
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.card_no = card_no;
        this.card_exp = card_exp;
        this.card_sec = card_sec;
        this.days = days;
    }
}
