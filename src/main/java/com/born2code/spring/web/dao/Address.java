package com.born2code.spring.web.dao;

public class Address {
    private int id;
    private String street;
    private String postcode;
    private String city;
    private String country;

    public Address() {

    }

    public Address(String street, String postcode, String city, String country) {
        this.street = street;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
    }

    public Address(int id, String street, String postcode, String city, String country) {
        this.id = id;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", street=" + street + ", postcode=" + postcode + ", city=" + city
                + ", country=" + country + "]";
    }
}