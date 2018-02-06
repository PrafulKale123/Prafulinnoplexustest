package com.innoplexus.home;

import android.content.Context;
import android.widget.Toast;

import com.innoplexus.pojos.ContactDetails;
import com.innoplexus.helper.Networkutils.ApiClient;
import com.innoplexus.helper.Networkutils.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by praful.kale on 06-02-2018.
 */
public class HomeScreenPresenterImpl implements HomeScreenPresenter {
    HomeScreenView homeScreenView;

    HomeScreenPresenterImpl(HomeScreenView homeScreenView) {
        this.homeScreenView = homeScreenView;
    }

    public void fetchContacts(final Context con) {
    
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<ContactDetails>> call = apiService.getFlightsInfo();
        call.enqueue(new Callback<List<ContactDetails>>() {
            @Override
            public void onResponse(Call<List<ContactDetails>> call, Response<List<ContactDetails>> response) {
              homeScreenView.setItems(response.body(),1);
            }
          @Override
            public void onFailure(Call<List<ContactDetails>> call, Throwable t) {
              Toast.makeText(con, "Something went Wrong" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}
