package com.company;

public class Contact {
    private String name;
    private String email;
    private String phone;

    Contact (String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPhone(){
        return this.phone;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    public String toString() {
        return this.getName() + " - - - " + this.getEmail() + " - - - " + this.getPhone();
    }



}
