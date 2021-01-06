package com.example.proiectandroid;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.util.JsonReader;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.proiectandroid.classes.App;
import com.example.proiectandroid.classes.Profile;

import org.json.JSONException;
import org.json.JSONObject;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProfileActivity extends AppCompatActivity{


    AwesomeValidation awesomeValidation;
    App app  = new App();
    Context context = App.getContext();

    String name, surname, CNP, emision_date, expiration_date;
    String CI_series, CI_number, place_of_birth, income, country;
    String email, phone_number, company, ocupation;

    EditText nameInput;
    EditText surnameInput;
    EditText CNPInput;
    EditText emision_dateInput;
    EditText expiration_dateInput;
    EditText CI_seriesInput;
    EditText CI_numberInput;
    EditText place_of_birthInput;
    EditText incomeInput;
    EditText ocupationInput;
    EditText companyInput;
    EditText countryInput;
    EditText emailInput;
    EditText phone_numberInput;


    private Button bt_submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameInput = (EditText) findViewById(R.id.et_nume);
        surnameInput = (EditText) findViewById(R.id.et_prenume);
        CNPInput = (EditText) findViewById(R.id.et_CNP);
        emision_dateInput = (EditText) findViewById(R.id.et_emision_date);
        expiration_dateInput = (EditText) findViewById(R.id.et_expiration_date);
        CI_seriesInput = (EditText) findViewById(R.id.et_series);
        CI_numberInput = (EditText) findViewById(R.id.et_series_number);
        place_of_birthInput = (EditText) findViewById(R.id.et_place_of_birth);
        incomeInput = (EditText) findViewById(R.id.et_income);
        ocupationInput = (EditText) findViewById(R.id.et_ocupation);
        companyInput = (EditText) findViewById(R.id.et_company);
        countryInput = (EditText) findViewById(R.id.et_country);
        emailInput = (EditText) findViewById(R.id.et_email);
        phone_numberInput = (EditText) findViewById(R.id.et_phone_number);

        //Initialize Validation Style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        // Validation
        awesomeValidation.addValidation(this, R.id.et_nume,
                "^[A-Za-z]+$", R.string.invalid_name);
        awesomeValidation.addValidation(this, R.id.et_prenume,
                "^[A-Za-z]+$", R.string.invalid_name);
        awesomeValidation.addValidation(this, R.id.et_CNP,
                "[0-9]{13}$", R.string.invalid_CNP);
        awesomeValidation.addValidation(this, R.id.et_emision_date,
                "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/(19[0-9]{2}|20[0-9]{2})$", R.string.invalid_date);
        awesomeValidation.addValidation(this, R.id.et_expiration_date,
                "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/(19[0-9]{2}|20[0-9]{2})$", R.string.invalid_date);
        awesomeValidation.addValidation(this, R.id.et_series,
                "[A-Z]{2}$", R.string.invalid_series);
        awesomeValidation.addValidation(this, R.id.et_series_number,
                "^[0-9]*$", R.string.ivalid_series_number);
        awesomeValidation.addValidation(this, R.id.et_place_of_birth,
                RegexTemplate.NOT_EMPTY, R.string.not_empy);
        awesomeValidation.addValidation(this, R.id.et_income,
                "^[0-9]*$", R.string.invalid_income);
        awesomeValidation.addValidation(this, R.id.et_ocupation,
                RegexTemplate.NOT_EMPTY, R.string.not_empy);
        awesomeValidation.addValidation(this, R.id.et_company,
                RegexTemplate.NOT_EMPTY, R.string.not_empy);
        awesomeValidation.addValidation(this, R.id.et_country,
                RegexTemplate.NOT_EMPTY, R.string.not_empy);
        awesomeValidation.addValidation(this, R.id.et_email,
                Patterns.EMAIL_ADDRESS,  R.string.not_empy);
        awesomeValidation.addValidation(this, R.id.et_phone_number,
                "[+]{1}[4]{1}[0]{1}[0-9]{10}$", R.string.invalid_phone_number);


        bt_submit = findViewById(R.id.bt_submit);
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(awesomeValidation.validate()){
                    //On success

                    //preluam datele din formular
                    name = nameInput.getText().toString();
                    surname = surnameInput.getText().toString();
                    CNP = CNPInput.getText().toString();
                    emision_date = emision_dateInput.getText().toString();
                    expiration_date = expiration_dateInput.getText().toString();
                    CI_series = CI_seriesInput.getText().toString();
                    CI_number = CI_numberInput.getText().toString();
                    place_of_birth = place_of_birthInput.getText().toString();
                    income = incomeInput.getText().toString();
                    email = emailInput.getText().toString();
                    phone_number = phone_numberInput.getText().toString();
                    country = countryInput.getText().toString();
                    company = companyInput.getText().toString();
                    ocupation = ocupationInput.getText().toString();



                    // convertesc datele din String in Date
                    try {
                        Date dateEmision = new SimpleDateFormat("dd/MM/yyyy").parse(emision_date);
                        Date dateExpiration = new SimpleDateFormat("dd/MM/yyyy").parse(expiration_date);

                        // convertesc income din string in float

                        float f_income = Float.parseFloat(income);

                        // Construim obiectul profile

                        Profile profile = new Profile();

                        // asignam datele din edit texturi atributelor din obiectul profile
                        profile.setName(name);
                        profile.setSurname(surname);
                        profile.setCNP(CNP);
                        profile.setEmission_date(dateEmision);
                        profile.setExpiration_date(dateExpiration);
                        profile.setID_series(CI_series);
                        profile.setID_number(CI_number);
                        profile.setCompany(company);
                        profile.setCountry(country);
                        profile.setEmail(email);
                        profile.setPhone_number(phone_number);
                        profile.setOcuppation(ocupation);
                        profile.setPlace_of_birth(place_of_birth);
                        profile.setIncome(f_income);

                        showToast("Mergeeee");



                        // cream un obiect JSON cu datele salvate in obiectul profile
                        JSONObject jsonObject = new JSONObject();

                        JSONObject json_comited = new JSONObject();
                        json_comited.put("j_completed", "true");


                        JSONObject json_personal_info = new JSONObject();
                        json_personal_info.put("name", profile.getName());
                        json_personal_info.put("surname", profile.getSurname());
                        json_personal_info.put("CNP", profile.getCNP());
                        json_personal_info.put("place_of_birth", profile.getPlace_of_birth());


                        JSONObject json_ID_data = new JSONObject();
                        json_ID_data.put("emision_date", profile.getEmission_date());
                        json_ID_data.put("expiration_date", profile.getExpiration_date());
                        json_ID_data.put("ID_series", profile.getID_series());
                        json_ID_data.put("ID_series", profile.getID_series());
                        json_ID_data.put("ID_number", profile.getID_number());

                        JSONObject json_profesional_info = new JSONObject();
                        json_profesional_info.put("occupation", profile.getOcuppation());
                        json_profesional_info.put("company", profile.getCompany());
                        json_profesional_info.put("income", profile.getIncome());
                        json_profesional_info.put("country", profile.getCountry());

                        JSONObject json_contact_info = new JSONObject();
                        json_contact_info.put("email", profile.getEmail());
                        json_contact_info.put("phone_number", profile.getEmail());

                        jsonObject.put("completed", json_comited);
                        jsonObject.put("personal_info", json_personal_info);
                        jsonObject.put("ID_data", json_ID_data);
                        jsonObject.put("profesional_info", json_profesional_info);
                        jsonObject.put("contact_info", json_contact_info);

                        //Convert JSONObject to String Format
                        String userString = jsonObject.toString();
                        Log.v("error_test", "Conversie obiect JSON in String");
                        Log.v("error_test", userString);


                        // Scriere in fisier JSON

                          File file = new File(context.getFilesDir(), "test.json");
                /*        try (FileWriter fileWriter = new FileWriter(file)) {
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            bufferedWriter.write(userString);
                            bufferedWriter.close();

                            Log.v("error_test", "Scriere in fisier JSON");

                        } catch (IOException e) {
                            e.printStackTrace();
                            Log.v("error_test",e.toString());
                            Log.v("error_test","eroare la scierea in fisier");
                        }*/


                    } catch (ParseException e) {
                        e.printStackTrace();
                        String error = e.toString();
                        Log.v("data_error",error);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    showToast("Form Validate Succesfully...");
                }else{
                    showToast("Validation Failed");
                }

            }
        });

        get_json();

    }

    public void get_json(){
        String json;

        try {
            InputStream is = getAssets().open("profile.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");


            JSONObject reader = new JSONObject(json);

            JSONObject completed = reader.getJSONObject("completed");
            String j_completed = completed.getString("j_completed");
            Log.v("json", j_completed);
            if (j_completed.equals("true")){
                Log.v("json", "e completat");
            }else{
                Log.v("json", "nu e completat");
            }


            JSONObject personal_info = reader.getJSONObject("personal_info");
            String j_name = personal_info.getString("name");
            Log.v("json", j_name);

            String j_surname = personal_info.getString("surname");
            String j_CNP = personal_info.getString("CNP");
            String j_place_of_birth = personal_info.getString("place_of_birth");


            JSONObject ID_data = reader.getJSONObject("ID_data");
            String j_emision_date = ID_data.getString("emision_date");
            Log.v("json",j_emision_date);
            String expiration_date = ID_data.getString("expiration_date");
            String ID_series = ID_data.getString("ID_series");
            String ID_number = ID_data.getString("ID_number");

            JSONObject profesional_info = reader.getJSONObject("profesional_info");
            String j_occupation = profesional_info.getString("occupation");
            String j_company = profesional_info.getString("company");
            String j_income = profesional_info.getString("income");
            String j_country = profesional_info.getString("country");

            JSONObject contact_info = reader.getJSONObject("contact_info");
            String j_email = contact_info.getString("email");
            String j_phone_number = contact_info.getString("phone_number");
            Log.v("json", j_phone_number);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

//    private void writeToFile(String data, Context context){
//        try {
//            OutputStreamWriter outputStreamWriter =
//                    new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
//            outputStreamWriter.write(data);
//            outputStreamWriter.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            Log.e("Exception", "File write failed: " + e.toString());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


//    public void submited_data(View view) {
//        Toast.makeText(this, "date salvate!", Toast.LENGTH_SHORT).show();
//    }
}