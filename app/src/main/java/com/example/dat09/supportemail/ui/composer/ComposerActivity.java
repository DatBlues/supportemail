package com.example.dat09.supportemail.ui.composer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dat09.supportemail.R;
import com.example.dat09.supportemail.model.Template;
import com.google.gson.Gson;

public class ComposerActivity extends AppCompatActivity {
    EditText edtSupject,edtContent;
    AutoCompleteTextView edtTo;
    Button btnSend;
    public static final String[] EMAILS= new String[]{"dattran45678@gmail.com", "gjundat95@gmail.com" };
    Template template;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_composer);

        anhXa();
        
        sendMail();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, EMAILS);
        edtTo.setAdapter(adapter);
        Intent intent = this.getIntent();
        String json = intent.getStringExtra("template");

        Gson gson = new Gson();

       template = gson.fromJson(json, Template.class);
//        Toast.makeText(this,template.getContent(), Toast.LENGTH_SHORT).show();
        edtContent.setText(template.getContent());
        edtSupject.setText(template.getSubject());

    }

    private void sendMail() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Send email", "");
                String[] TO = new String[5];
                TO[1] = edtTo.getText().toString();
                String[] CC = {""};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_CC, CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, edtSupject.getText().toString());
                emailIntent.putExtra(Intent.EXTRA_TEXT, edtContent.getText().toString());

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ComposerActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    public void anhXa(){
        edtTo= (AutoCompleteTextView) findViewById(R.id.edt_to);
        edtSupject= (EditText) findViewById(R.id.edt_supject);
        edtContent= (EditText) findViewById(R.id.edt_content);
        btnSend= (Button) findViewById(R.id.btn_send);
    }
}
