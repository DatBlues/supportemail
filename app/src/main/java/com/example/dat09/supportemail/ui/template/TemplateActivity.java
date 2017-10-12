package com.example.dat09.supportemail.ui.template;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.dat09.supportemail.R;
import com.example.dat09.supportemail.data.MyDatabase;
import com.example.dat09.supportemail.model.Template;

import java.util.ArrayList;
import java.util.List;

public class TemplateActivity extends AppCompatActivity {
    public RecyclerView recyclerView;
    public CustomTemplateAdapter customTemplateAdapter;
    public List<Template> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_templete);

        recyclerView= (RecyclerView) findViewById(R.id.recy_recyclerView);
        recyclerView.setHasFixedSize(true);

        getData();

        customTemplateAdapter = new CustomTemplateAdapter(data, getBaseContext());
        recyclerView.setAdapter(customTemplateAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void getData() {
        MyDatabase myDatabase= new MyDatabase(this);

        Cursor cursor = myDatabase.getTemplateEmal();
        while (cursor.moveToNext()){
//            Toast.makeText(
//                    this,
//                    cursor.getString(0) + "-" +cursor.getString(1) + cursor.getString(2) + cursor.getString(3),
//                    Toast.LENGTH_SHORT).show();
            Template template = new Template(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)

            );
            data.add(template);
        }
    }
}
