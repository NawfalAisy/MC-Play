package com.example.a2502009715_mcs_uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a2502009715_mcs_uas.databinding.ActivityRegisterBinding;

import java.util.ArrayList;

public class register extends AppCompatActivity {

    ActivityRegisterBinding binding;

    Database database;

    Button signUp;

    EditText email, password, confirmPass;
    TextView SignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.emailregister);
        password = findViewById(R.id.passwordregister);
        confirmPass = findViewById(R.id.confirmpassregister);
        database = new Database(this);
        signUp = findViewById(R.id.registbutton);
        SignIn = findViewById(R.id.signinText);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_person = email.getText().toString().trim();
                String password_person = password.getText().toString().trim();
                String confirmpassword_person = confirmPass.getText().toString().trim();

                if (email_person.equals("") || password_person.equals("") || confirmpassword_person.equals(""))
                    Toast.makeText(register.this, "All field are mandatory", Toast.LENGTH_SHORT).show();
                else{
                    if (password_person.equals(confirmpassword_person)){
                        Boolean checkUseremail = database.checkEmail(email_person);

                        if (checkUseremail == false){
                            Boolean insert = database.insertData(email_person, password_person);

                            if (insert == true){
                                Toast.makeText(register.this, "Signup Succesfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(register.this, Login.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(register.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(register.this, "User Already Exist", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(register.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(register.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}