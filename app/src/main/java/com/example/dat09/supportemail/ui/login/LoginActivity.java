package com.example.dat09.supportemail.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dat09.supportemail.R;
import com.example.dat09.supportemail.ui.main.MainActivity;

public class LoginActivity extends AppCompatActivity {
    EditText edtMail,edtPassword;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhXa();
        fakeData();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=edtMail.getText().toString();
                String pass=edtPassword.getText().toString();
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
                    if (mail.equals("dattran45678@gmail.com")){
                        if (pass.equals("123")){
                            Intent intent= new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }
                }

            }
        });
    }
    public void anhXa(){
        edtMail= (EditText) findViewById(R.id.edt_mail);
        edtPassword= (EditText) findViewById(R.id.edt_password);
        btnLogin= (Button) findViewById(R.id.btn_login);
    }
    private void fakeData() {
        edtMail.setText("dattran45678@gmail.com");
        edtPassword.setText("123");
    }
}
