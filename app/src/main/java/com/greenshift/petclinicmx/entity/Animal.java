package com.greenshift.petclinicmx.entity;

import java.util.Date;

public class Animal {

    private int id;
    private String name;
    private String species;
    private String breed;
    private char sex;
    private Date datebirth;

    public Animal() {}
    public Animal(int id, String name, String species, String breed, char sex, Date datebirth) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.sex = sex;
        this.datebirth = datebirth;
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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getDatebirth() {
        return datebirth;
    }

    public void setDatebirth(Date datebirth) {
        this.datebirth = datebirth;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", breed='" + breed + '\'' +
                ", sex=" + sex +
                ", datebirth=" + datebirth +
                '}';
    }
}
