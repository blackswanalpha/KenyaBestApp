package com.example.kenyabestapp;

public class UserHelperClass {
    String username ,fullname, email, password;

    public UserHelperClass(String fullname, String username, String email, String password){
        this.username =username;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
    }


    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
