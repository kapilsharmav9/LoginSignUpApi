package com.example.loginsignupapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class LoginActivity extends AppCompatActivity {
EditText eEmail,ePassword;
Button btnLogin;
TextView txtSignup;
    String Email, Passwordd;
    private  static  final String url="https://mukulyadav222.000webhostapp.com/login.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
getUserInfo();
            }
        });
        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });
    }


    private  void initView()
    {
        eEmail=findViewById(R.id.edtEmailL);
        ePassword=findViewById(R.id.editpasswordL);
        btnLogin=findViewById(R.id.btnLogin);
        txtSignup=findViewById(R.id.signuptxt);
    }
    private void getUserInfo() {
        if (eEmail.getText().toString().isEmpty() || ePassword.getText().toString().isEmpty()) {
            if (eEmail.getText().toString().isEmpty()) {
                eEmail.setError("fill Email");
                eEmail.requestFocus();
            } else if (ePassword.getText().toString().isEmpty() || ePassword.getText().toString().isEmpty()) {
                ePassword.setError("minimum pasword length 6");
                ePassword.requestFocus();

            }
        } else {

            Email = eEmail.getText().toString();
            Passwordd = ePassword.getText().toString();
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
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
                    userDetail.put("email", Email);    //send the values from here as sent from postman
                    userDetail.put("password", Passwordd);

                    return userDetail;

                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
            requestQueue.add(request);
        }

    }
}