package com.example.abc.girishsharma;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ShareDetailsFragment extends Fragment implements  View.OnClickListener {
    private EditText firstname,lastname,email,middlename, phoneno,DOB,DOA, DOB2 ;
    private Button submit;
    private DatePickerDialog datePickerDialog1, datePickerDialog2, datePickerDialog3;
    private Spinner gender,profession,bloodgrp;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_share_details,container,false);
        //Bind views with their ids
        bindViews (view);

        //Set listeners of views
        setViewActions();

        // Spinner element1
        Spinner spinner1 = (Spinner)view.findViewById ( R.id.spGender );

        // Spinner click listener
        spinner1.setOnItemSelectedListener ( (AdapterView.OnItemSelectedListener) gender );

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add ( "Female" );
        categories.add ( "Male" );
        categories.add ( "Third Gender" );

        // Creating adapter for spinner1
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String> ( getActivity(), android.R.layout.simple_spinner_item, categories );

        // Drop down layout style - list view with radio button1
        dataAdapter.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );

        // attaching data adapter to spinner
        spinner1.setAdapter ( dataAdapter );

        // Spinner element2
        Spinner spinner2 = (Spinner) view.findViewById ( R.id.spProf );

        // Spinner click listener
        spinner2.setOnItemSelectedListener ((AdapterView.OnItemSelectedListener) profession);

        // Spinner Drop down elements
        List<String> categories2 = new ArrayList<String> ();
        categories2.add ( "Student" );
        categories2.add ( "None" );
        categories2.add ( "Government Service" );
        categories2.add ( "Private Service" );

        // Creating adapter for spinner2
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String> ( getActivity(), android.R.layout.simple_spinner_item, categories2 );

        // Drop down layout style - list view with radio button2
        dataAdapter2.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );

        // attaching data adapter to spinner
        spinner2.setAdapter ( dataAdapter2 );

        // Spinner element3
        Spinner spinner3 = (Spinner) view.findViewById ( R.id.spBloodGrp );

        // Spinner click listener
        spinner3.setOnItemSelectedListener ((AdapterView.OnItemSelectedListener) bloodgrp);

        // Spinner Drop down elements
        List<String> categories3 = new ArrayList<String> ();
        categories3.add ( "O+" );
        categories3.add ( "O-" );
        categories3.add ( "A+" );
        categories3.add ( "A-" );
        categories3.add ( "B+" );
        categories3.add ( "B-" );
        categories3.add ( "AB+" );
        categories3.add ( "AB-" );

        // Creating adapter for spinner3
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String> (getActivity(), android.R.layout.simple_spinner_item, categories3 );

        // Drop down layout style - list view with radio button3
        dataAdapter3.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );

        // attaching data adapter to spinner
        spinner3.setAdapter ( dataAdapter3 );

        //Create DatePickerDialog to show a calendar to user to select birthdate
        prepareDatePickerDialog ();
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener( new View.OnKeyListener()
        {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event )
            {
                if( keyCode == KeyEvent.KEYCODE_BACK )
                {
                    getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    return true;
                }
                return false;
            }
        } );
        return view;
    }
    private void bindViews(View view) {
        firstname = view.findViewById ( R.id.etFirstName );
        lastname = view.findViewById ( R.id.etLastName );
        email = view.findViewById ( R.id.etEmail );
        middlename = view.findViewById ( R.id.etMidName );
        phoneno = view.findViewById ( R.id.etPhoneNo );
        DOB = view.findViewById ( R.id.birthday );
        DOB2 = view.findViewById ( R.id.birthday2 );
        DOA = view.findViewById ( R.id.etDOA );
        submit = view.findViewById ( R.id.btnSubmit );
    }

    private void setViewActions() {
        DOB.setOnClickListener(this);
        DOB2.setOnClickListener(this);
        DOA.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.birthday:
                datePickerDialog1.show();
                //Show a Calendar
                break;
            case R.id.birthday2:
                datePickerDialog3.show();
                //Show a Calendar
                break;
            case R.id.etDOA:
                datePickerDialog2.show();
                //Show a Calendar
                break;
            case R.id.btnSubmit:
                //show toast with typed and selected values
                break;
        }
    }
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition ( position ).toString ();

        // Showing selected spinner item
        Toast.makeText ( parent.getContext (), "Selected: " + item, Toast.LENGTH_LONG ).show ();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void prepareDatePickerDialog() {
        //Get current date
        Calendar calendar = Calendar.getInstance ();

        //Create datePickerDialog with initial date which is current and decide what happens when a date is selected.
        datePickerDialog1 = new DatePickerDialog ( getActivity(), new DatePickerDialog.OnDateSetListener () {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //When a date is selected, it comes here.
                //Change  dateOfBirth's text and dismiss dialog.
                DOB.setText ( dayOfMonth + "/" + monthOfYear + "/" + year );
                datePickerDialog1.dismiss ();
            }
        }, calendar.get ( Calendar.YEAR ), calendar.get ( Calendar.MONTH ), calendar.get ( Calendar.DAY_OF_MONTH ) );

        datePickerDialog2 = new DatePickerDialog ( getActivity(), new DatePickerDialog.OnDateSetListener () {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //When a date is selected, it comes here.
                //Change  dateOfBirth's text and dismiss dialog.
                DOA.setText ( dayOfMonth + "/" + monthOfYear + "/" + year );
                datePickerDialog2.dismiss ();
            }
        }, calendar.get ( Calendar.YEAR ), calendar.get ( Calendar.MONTH ), calendar.get ( Calendar.DAY_OF_MONTH ) );

        datePickerDialog3 = new DatePickerDialog ( getActivity(), new DatePickerDialog.OnDateSetListener () {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //When a date is selected, it comes here.
                //Change  dateOfBirth's text and dismiss dialog.
                DOB2.setText ( dayOfMonth + "/" + monthOfYear + "/" + year );
                datePickerDialog3.dismiss ();
            }
        }, calendar.get ( Calendar.YEAR ), calendar.get ( Calendar.MONTH ), calendar.get ( Calendar.DAY_OF_MONTH ) );
    }
}
