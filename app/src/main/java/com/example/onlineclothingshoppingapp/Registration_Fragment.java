package com.example.onlineclothingshoppingapp;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Registration_Fragment extends Fragment implements View.OnClickListener {

    EditText name,username,password;
    Button register;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_registration_, container, false);


        name=view.findViewById(R.id.et_name);
        username=view.findViewById(R.id.et_username);
        password=view.findViewById(R.id.et_password);
        register=view.findViewById(R.id.btn_register);
        register.setOnClickListener(this);

        preferences=getActivity().getSharedPreferences("APP", Context.MODE_PRIVATE);
        editor=preferences.edit();



        return view;

    }


    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btn_register){
            String value_name=name.getText().toString();
            String value_username=username.getText().toString();
            String value_password=password.getText().toString();

            if (value_name.isEmpty()){
                name.setError("Enter the name");
                name.requestFocus();
            }
            else if (value_username.isEmpty()){
                username.setError("Enter the username");
                username.requestFocus();
            }
            else  if (value_password.isEmpty()){
                password.setError("Enter the password");
                password.requestFocus();
            }
            else {
                editor.putString("VALUE1", value_name).commit();
                editor.putString("VALUE2",value_username).commit();
                editor.putString("VALUE3",value_password).commit();

                Toast.makeText(getActivity(), preferences.getString("VALUE1","Not registered")+"You are registered", Toast.LENGTH_SHORT).show();



            }
        }



    }
}
