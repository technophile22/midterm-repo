package com.example.midterm_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    FloatingActionButton fab;
    ListView listView;
    String name, age, gender;
    ArrayList< LvItem > arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.lv);
        fab = findViewById(R.id.flot);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.fabitem);
                final EditText etname = dialog.findViewById(R.id.etname);
                final EditText etgender = dialog.findViewById(R.id.etgender);
                final EditText etage = dialog.findViewById(R.id.etage);
                Button btnsave = dialog.findViewById(R.id.btnsave);



                btnsave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        name = etname.getText().toString();
                        age = etage.getText().toString();
                        gender = etgender.getText().toString();

                        LvItem lvItem = new LvItem();
                        lvItem.setName(name);
                        lvItem.setGender(gender);
                        lvItem.setAge(age);
                        arrayList.add(lvItem);
                        dialog.dismiss();

                        ContactAdapter contactAdapter = new ContactAdapter(arrayList, MainActivity.this);
                        listView.setAdapter(contactAdapter);

                    }
                });
                dialog.show();

            }
        });


    }
}