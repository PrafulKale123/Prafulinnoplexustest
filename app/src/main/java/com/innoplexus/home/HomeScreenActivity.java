package com.innoplexus.home;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.innoplexus.pojos.ContactDetails;
import com.innoplexus.R;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by praful.kale on 06-02-2018.
 */
public class HomeScreenActivity extends AppCompatActivity implements HomeScreenView, View.OnClickListener {

    private HomeScreenPresenterImpl homeScreenPresenter;


    private int sortByAscending = 1;
    private int sortByDescending = 2;
    private int currentSort = 1;
    private List<ContactDetails> resultList;

    @BindView(R.id.rvContactsList)
    RecyclerView rvContactsList;

    @BindView(R.id.sortBtn)
    FloatingActionButton sortBtn;

    @BindView(R.id.loaderLyt)
    LinearLayout loaderLyt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        sortBtn.setOnClickListener(this);
        homeScreenPresenter = new HomeScreenPresenterImpl(this);
        loaderLyt.setVisibility(View.VISIBLE);
        homeScreenPresenter.fetchContacts(this);


    }


    @Override
    public void setItems(List<ContactDetails> resultList, int sortBY) {
        this.resultList = resultList;
        loaderLyt.setVisibility(View.GONE);
        rvContactsList.setHasFixedSize(true);
        rvContactsList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        rvContactsList.setLayoutManager(layoutManager);
        Collections.sort(resultList, ALPHABETICAL_ORDER);

        if (sortBY == sortByAscending) {
        } else if (sortBY == sortByDescending) {
            Collections.reverse(resultList);
        }
        rvContactsList.setAdapter(new ContactListAdapter(this, resultList));

    }


    private static Comparator<ContactDetails> ALPHABETICAL_ORDER = new Comparator<ContactDetails>() {
        public int compare(ContactDetails str1, ContactDetails str2) {
            int res = String.CASE_INSENSITIVE_ORDER.compare(str1.getName(), str1.getName());
            if (res == 0) {
                res = str1.getName().compareTo(str2.getName());
            }
            return res;
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sortBtn:
                if (currentSort == 1) {
                    currentSort = 2;
                    setItems(resultList, sortByDescending);

                } else {
                    currentSort = 1;
                    setItems(resultList, sortByAscending);
                }
                break;
        }

    }
}
