package com.example.proiectandroid.classes;

import android.app.Application;

import java.util.Date;

public class Profile extends Application {
    private String name;
    private String surname;
    private String CNP;
    private Date emission_date;
    private Date expiration_date;
    private String ID_series;
    private String ID_number;
    private String place_of_birth;
    private String ocuppation;
    private String company;
    private String country;
    private float income;
    private String email;
    private String phone_number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public Date getEmission_date() {
        return emission_date;
    }

    public void setEmission_date(Date emission_date) {
        this.emission_date = emission_date;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getID_series() {
        return ID_series;
    }

    public void setID_series(String ID_series) {
        this.ID_series = ID_series;
    }

    public String getID_number() {
        return ID_number;
    }

    public void setID_number(String ID_number) {
        this.ID_number = ID_number;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public String getOcuppation() {
        return ocuppation;
    }

    public void setOcuppation(String ocuppation) {
        this.ocuppation = ocuppation;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Profile(String name, String surname, String CNP, Date emission_date,
                   Date expiration_date, String ID_series, String ID_number,
                   String place_of_birth, String ocuppation, String company,
                   String country, float income, String email, String phone_number) {
        this.name = name;
        this.surname = surname;
        this.CNP = CNP;
        this.emission_date = emission_date;
        this.expiration_date = expiration_date;
        this.ID_series = ID_series;
        this.ID_number = ID_number;
        this.place_of_birth = place_of_birth;
        this.ocuppation = ocuppation;
        this.company = company;
        this.country = country;
        this.income = income;
        this.email = email;
        this.phone_number = phone_number;
    }

    public Profile (){

    }





    public void writeInJSON(Profile profile){

    }
}
