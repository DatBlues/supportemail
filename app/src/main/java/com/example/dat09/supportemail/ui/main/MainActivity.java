package com.example.dat09.supportemail.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.dat09.supportemail.R;
import com.example.dat09.supportemail.ui.composer.ComposerActivity;
import com.example.dat09.supportemail.ui.template.TemplateActivity;

public class MainActivity extends AppCompatActivity {
    LinearLayout lineTemplete,lineSoanMail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();

        lineTemplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,TemplateActivity.class);
                startActivity(intent);
            }
        });
        lineSoanMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, ComposerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void anhXa() {
        lineTemplete= (LinearLayout) findViewById(R.id.line_templete);
        lineSoanMail= (LinearLayout) findViewById(R.id.line_soanmail);
    }
}
