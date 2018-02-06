package com.innoplexus.contacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.innoplexus.pojos.ContactDetails;
import com.innoplexus.R;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by praful.kale on 06-02-2018.
 */
public class ContactDetailsActivity extends AppCompatActivity {

    ContactDetails contactDetails;


    @BindView(R.id.tvname)
    TextView tvname;

    @BindView(R.id.tvphone)
    TextView tvphone;

    @BindView(R.id.tvemail)
    TextView tvemail;

    @BindView(R.id.tvwebsite)
    TextView tvwebsite;

    @BindView(R.id.tvaddress)
    TextView tvaddress;

    @BindView(R.id.tvcompany)
    TextView tvcompany;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);
        ButterKnife.bind(this);
        contactDetails = (ContactDetails) getIntent().getSerializableExtra("CONTACT");


        tvname.setText(contactDetails.getName());
        tvphone.setText(contactDetails.getPhone());
        tvemail.setText(contactDetails.getEmail());
        tvaddress.setText(contactDetails.getAddress().getSuite()+", "+contactDetails.getAddress().getStreet()+", "+contactDetails.getAddress().getCity()+", "+contactDetails.getAddress().getZipcode());
        tvcompany.setText(contactDetails.getCompany().getName());
        tvwebsite.setText(contactDetails.getWebsite());

    }
}
