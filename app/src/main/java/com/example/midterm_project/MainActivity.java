package com.example.midterm_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etname, etage, etgender;
    Button btnsave;
    ListView listView;
    String name, age, gender;
    ArrayList< LvItem > arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = findViewById(R.id.etname);
        etage = findViewById(R.id.etage);
        etgender = findViewById(R.id.etgender);
        listView = findViewById(R.id.lv);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etname.getText().toString();
                age = etage.getText().toString();
                gender = etgender.getText().toString();

                LvItem lvItem = new LvItem();
                lvItem.setName(name);
                lvItem.setGender(gender);
                lvItem.setAge(age);
                arrayList.add(lvItem);

                ContactAdapter contactAdapter = new ContactAdapter(arrayList, MainActivity.this);
                listView.setAdapter(contactAdapter);
            }
        });

    }
}