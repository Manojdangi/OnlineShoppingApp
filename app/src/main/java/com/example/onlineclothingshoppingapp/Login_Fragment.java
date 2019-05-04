package com.example.onlineclothingshoppingapp;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login_Fragment extends Fragment implements View.OnClickListener {

    EditText username, password;
    Button login;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_, container, false);

        username = view.findViewById(R.id.et_username);
        password = view.findViewById(R.id.et_password);
        login = view.findViewById(R.id.btn_login);

        preferences = getActivity().getSharedPreferences("APP", Context.MODE_PRIVATE);
        editor = preferences.edit();


        login.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_login) {
            String enter_username = username.getText().toString();
            String enter_password = password.getText().toString();
            if (enter_password.isEmpty()) {
                username.setError("Enter the username");
                username.requestFocus();

            }
            else if (enter_username.isEmpty()){
                password.setError("Enter the password");
                password.requestFocus();
            }

            else if (enter_username.equals(preferences.getString("VALUE2","NO VALUE"))
                    && enter_password.equals(preferences.getString("VALUE3","NO VALUE"))){

                Intent intent =new Intent(getActivity(),ItemAdd.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "Welcome"+preferences.getString("VALUE2","NULL"), Toast.LENGTH_SHORT).show();


            }

            else {
                Toast.makeText(getActivity(), "Username or Password incorrect", Toast.LENGTH_SHORT).show();
            }



        }
    }
}
