package com.example.a2502009715_mcs_uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a2502009715_mcs_uas.databinding.ActivityLoginBinding;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    ActivityLoginBinding binding;

    Database database;

    Button login;

    EditText email_check, password_check;

    TextView SignUp;

    private boolean passwordVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_login);

        database = new Database(this);
        login = findViewById(R.id.loginbutton);
        email_check = findViewById(R.id.emaillogin);
        password_check = findViewById(R.id.passwordlogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_check.getText().toString();
                String password = password_check.getText().toString();

                if (email.equals("") || password.equals(""))
                    Toast.makeText(Login.this,"All fields are mandatory", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkCredentials = database.checkEmailPassword(email, password);

                    if (checkCredentials == true){
                        Toast.makeText(Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, Section.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        SignUp = findViewById(R.id.signupText);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(Login.this, register.class);
                startActivity(signUp);
                finish();
            }
        });

    }
}

//        password.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                final int right = 2;
//                if(event.getAction() == MotionEvent.ACTION_UP){
//                    if (event.getRawX() >= password.getRight()-password.getCompoundDrawables()[right].getBounds().width()){
//                        int selection = password.getSelectionEnd();
//                        if (passwordVisible) {
//                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.togglepassword_off, 0);
//                            // hide password
//                            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                            passwordVisible = false;
//                        }
//                        else {
//                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.togglepassword_on, 0);
//                            // show password
//                            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                            passwordVisible = true;
//                        }
//                        password.setSelection(selection);
//                        return true;
//                    }
//                }
//
//                return false;
//            }
//        });