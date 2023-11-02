package com.example.recyclerview;

public class Contacts {
    private String name;
    private String email;
    private String imgURl;

    public Contacts(String name, String email, String imgURl) {
        this.name = name;
        this.email = email;
        this.imgURl = imgURl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgURl() {
        return imgURl;
    }

    public void setImgURl(String imgURl) {
        this.imgURl = imgURl;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", imgURl='" + imgURl + '\'' +
                '}';
    }
}
