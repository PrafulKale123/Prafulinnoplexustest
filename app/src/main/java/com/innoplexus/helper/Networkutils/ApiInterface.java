package com.innoplexus.helper.Networkutils;

/**
 * Created by praful.kale on 06-02-2018.
 */

import com.innoplexus.pojos.ContactDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {

    @GET("/users")
    Call<List<ContactDetails>> getFlightsInfo();
}