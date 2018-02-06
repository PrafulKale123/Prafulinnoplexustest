package com.innoplexus.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by praful.kale on 06-02-2018.
 */

public class ContactDetails implements Serializable {

    private final static long serialVersionUID = -336111803039983475L;
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("email")
    @Expose
    private String email;


    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("website")
    @Expose
    private String website;


    @SerializedName("address")
    @Expose
    private Address address;

    @SerializedName("company")
    @Expose
    private Company company;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



}
