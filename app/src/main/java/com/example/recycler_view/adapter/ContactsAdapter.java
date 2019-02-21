package com.example.recycler_view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.recycler_view.R;
import com.example.recycler_view.models.Contact;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter <ContactsAdapter.ViewHolder> {

    //atribut
    private List<Contact> mContacts;

    //constructor
    public  ContactsAdapter(List<Contact> mContacts){
        this.mContacts = mContacts;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ///menghubungkan item_conctact.xml ke adapter
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.item_contact,viewGroup,false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //menghubungkan/mensetting nilai masing2 item

        Contact itemContact = mContacts.get(i);

        TextView textView = viewHolder.nameTextView;
        textView.setText(itemContact.getmName());

        Button button = viewHolder.massageButton;
        button.setText(itemContact.ismOnline()? "Massage" : "Offline");
        button.setEnabled(itemContact.ismOnline());

    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nameTextView;
        private Button massageButton ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.contact_name);
            massageButton = itemView.findViewById(R.id.contact_name);
        }
    }

}
