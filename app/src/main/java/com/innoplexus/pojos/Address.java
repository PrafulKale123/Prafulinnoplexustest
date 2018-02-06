package com.innoplexus.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by praful.kale on 05-02-2018.
 */

public class Address implements Serializable {


    private final static long serialVersionUID = -3361118030378343475L;
    @SerializedName("street")
    @Expose
    private String street;

    @SerializedName("suite")
    @Expose
    private String suite;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("zipcode")
    @Expose
    private String zipcode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

}
