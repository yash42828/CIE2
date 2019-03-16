package com.example.hp.cie2;

import android.location.Address;

public class Users {
    private String Email,Address,Password,Lname,Fname,Mobile,Enrol;

    public Users(String email,String password,String fname,String lname,String address,String mobile,String enrol) {
        Email = email;
        Password = password;
        Lname = lname;
        Fname = fname;
        Address = address;
        Mobile = mobile;
        Enrol = enrol;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getLname() {
        return Lname ;
    }
    public String getFname() {
        return Fname ;
    }
    public String getAddress() {
        return Address ;
    }
    public String getEnrol() {
        return Enrol ;
    }

    public String getMobile() {
        return Mobile;
    }

}
