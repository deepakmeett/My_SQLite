package com.example.my_sqlite;

public class Model {

    String email;
    String password;

    public Model(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public Model(){
        
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
