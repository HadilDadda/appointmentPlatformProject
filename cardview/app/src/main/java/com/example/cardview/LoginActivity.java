package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText txtUsername;
    private EditText txtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }

    public void loginUser (View v){
        String numStudent = this.txtUsername.getText().toString();
        String password = this.txtPassword.getText().toString();

        dbWorkerLogin dbw = new dbWorkerLogin(this);
        dbw.execute(numStudent, password);

        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}