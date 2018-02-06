package com.innoplexus.home;

import com.innoplexus.pojos.ContactDetails;

import java.util.List;

/**
 * Created by praful.kale on 06-02-2018.
 */
public interface HomeScreenView {
    void setItems(List<ContactDetails> items, int sortBy);
}
