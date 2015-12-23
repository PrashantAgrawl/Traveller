package com.strangers.traveller;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by root on 16/12/15.
 */
public class Register extends Fragment {
    private final String TAG = "Signup Fragment";

    private String uname;
    private String email;
    private String passwd;
    private String confirm;
    private String phone;
    private String dob;
    private int dateofbirth;
    EditText _uname;
    EditText _email;
    EditText _passwd;
    EditText _confirm;
    EditText _phone;
    EditText _dob;

    private ImageButton signUpButton;

    public Register() {
        // Required empty public constructor
        Log.d(TAG,"Constructor called");
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.form, null);
        Log.d(TAG,"signup created");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG,"signup clicked1");
        signUpButton=(ImageButton)getActivity().findViewById(R.id.signupButton);

        Log.d(TAG, "SignUp Clicked2");
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dbManage = new UserDBHandler(getContext(), null, null, 1);
                Log.d(TAG, "SignUp Clicked3");
                //date_set();
                _uname = (EditText) getActivity().findViewById(R.id.name);
                _email = ((EditText) getActivity().findViewById(R.id.email));
                _passwd = ((EditText) getActivity().findViewById(R.id.password));
                _confirm = ((EditText) getActivity().findViewById(R.id.confirm));
                _phone = ((EditText) getActivity().findViewById(R.id.mobile));
                _dob = ((EditText) getActivity().findViewById(R.id.dob));

                uname = _uname.getText().toString().trim();
                email = _email.getText().toString().trim();
                passwd = _passwd.getText().toString().trim();
                confirm = _confirm.getText().toString().trim();
                phone = _phone.getText().toString().trim();
                dob = _dob.getText().toString().trim();

                Log.d(TAG, "Before Validation "+phone+"   "+dob);

                CheckValidation check = new CheckValidation();
                int flag = 0;
                if (!check.check_name(getContext(), uname)) {
                    _uname.setError("Invalid Name");
                    _uname.setText("");
                    flag = 1;
                }

                if (!check.check_email(getContext(), email)) {
                    _email.setText("");
                    _email.setError("Invalid Email");
                    flag = 1;
                }


                if (!check.check_passwd(getContext(), passwd)) {
                    _passwd.setText("");
                    _passwd.setError("Invalid Password");
                    flag = 1;
                }

                if (!check.check_confirm(getContext(), confirm, passwd)) {
                    _passwd.setText("");
                    _passwd.setError("Invalid Password");
                    _confirm.setText("");
                    _confirm.setError("Passwords do not match");
                    flag = 1;
                }

                if (!check.check_phone(getContext(), phone)) {
                    _phone.setText("");
                    _phone.setError("Invalid Phone Number");
                    flag = 1;
                }

                Log.d(TAG, "After validation");


            }
        });
        }



    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}