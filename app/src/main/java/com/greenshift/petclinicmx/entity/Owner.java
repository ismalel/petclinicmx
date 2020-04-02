package com.greenshift.petclinicmx.entity;

public class Owner {

    private int id;
    private String name;
    private String address;
    private String tel;
    private String email;
    private int avatar;

    public Owner(){}
    public Owner(int id, String name, String tel, String email, int avatar){
        this.setId(id);
        this.setName(name);
        this.setTel(tel);
        this.setEmail(email);
        this.setAvatar(avatar);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", avatar=" + avatar +
                '}';
    }
}
