package com.example.loginsignupapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    Button btnsignup;
    TextView txtlogin;
    EditText eName, eEmail, ePassword;
    //    Spinner spinGender, spinCountry;
    String Name, Email, Passwordd;
    String url = "https://mukulyadav222.000webhostapp.com/Register.php";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        intiView();
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
getUserInfo();
            }
        });
        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });
    }


    private void intiView() {
        eName = findViewById(R.id.editNameS);
        eEmail = findViewById(R.id.editEmailS);
        ePassword = findViewById(R.id.editpasswordS);
//        spinGender = findViewById(R.id.spinnerG);
//        spinCountry = findViewById(R.id.spinnerC);
        txtlogin = findViewById(R.id.loginText);
        btnsignup = findViewById(R.id.btnSignUp);
    }

    private void getUserInfo() {
        if (eName.getText().toString().isEmpty() || ePassword.getText().toString().isEmpty() || eEmail.getText().toString().isEmpty()) {
            if (eName.getText().toString().isEmpty()) {
                eName.setError("fill name");
                eName.requestFocus();
            } else if (ePassword.getText().toString().isEmpty() || ePassword.getText().toString().isEmpty()) {
                ePassword.setError("minimum pasword length 6");
                ePassword.requestFocus();

            } else if (eEmail.getText().toString().isEmpty()) {
                eName.setError("fill Email");
                eName.requestFocus();

            }
        } else {
            Name = eName.getText().toString();
            Email = eEmail.getText().toString();
            Passwordd = ePassword.getText().toString();
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> userDetail = new HashMap<String, String>();
                    userDetail.put("name", Name);
                    userDetail.put("email", Email);    //send the values from here as sent from postman
                    userDetail.put("password", Passwordd);

                    return userDetail;

                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(SignUpActivity.this);
            requestQueue.add(request);
        }

    }


}