package com.example.anand.newapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.parse.ParseUser;

import static com.parse.ParseUser.*;

/**
 * Created by anand on 22-03-2016.
 */
public class account extends Fragment {
    View account;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        account=inflater.inflate(R.layout.account,container,false);
        Button logout=(Button)account.findViewById(R.id.button6);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                //currentUser = getCurrentUser(); // should be null but isn't...
                //invalidateOptionsMenu();
                Toast.makeText(getActivity(), "LOGOUT SUCCESS", Toast.LENGTH_LONG).show();
                Intent ie=new Intent(getActivity(),MainActivity.class);
                startActivity(ie);
            }
        });
        return account;


    }
}
