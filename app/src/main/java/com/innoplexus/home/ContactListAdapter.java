package com.innoplexus.home;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.innoplexus.pojos.ContactDetails;
import com.innoplexus.R;
import com.innoplexus.contacts.ContactDetailsActivity;

import java.util.List;

/**
 * Created by praful.kale on 06-02-2018.
 */
public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder> {
    private List<ContactDetails> resultList;
    private Context con;

    private ViewHolder holder;

    public ContactListAdapter(Context con, List<ContactDetails> resultList) {
        this.con = con;
        this.resultList = resultList;

    }


    // Create new views (invoked by the layout manager)
    @Override
    public ContactListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_contact, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        holder = viewHolder;
        holder.tvname.setText(""+resultList.get(position).getName());
        holder.tvemail.setText(""+resultList.get(position).getEmail());
        holder.tvphone.setText(""+resultList.get(position).getPhone());

        holder.contactLyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contactDetailsIntent=   new Intent(con, ContactDetailsActivity.class);
                contactDetailsIntent.putExtra("CONTACT",resultList.get(position));
                con.startActivity(contactDetailsIntent);
            }
        });
    }


    // inner class to hold a reference to each item of RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvname,tvemail,tvphone;
        LinearLayout contactLyt;
        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            tvname =(TextView)itemLayoutView.findViewById(R.id.tvname);
            tvemail =(TextView)itemLayoutView.findViewById(R.id.tvemail);
            tvphone =(TextView)itemLayoutView.findViewById(R.id.tvphone);
            contactLyt=(LinearLayout)itemLayoutView.findViewById(R.id.contactLyt);

        }

    }


    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return resultList.size();
    }
}