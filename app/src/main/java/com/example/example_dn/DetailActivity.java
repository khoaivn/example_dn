package com.example.example_dn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        int value = intent.getIntExtra("position", -1);
        Item item = MainActivity.items.get(value);

        EditText editText_fullname = (EditText) findViewById(R.id.tv_full_name);
        editText_fullname.setText(item.getFull_name());
        EditText editText_diem_tin = (EditText) findViewById(R.id.tv_diem_tin);
        editText_fullname.setText(item.getDiem_tin());
        EditText editText_diem_toan = (EditText) findViewById(R.id.tv_diem_toan);
        editText_fullname.setText(item.getDiem_toan());
        EditText editText_diem_ltdd = (EditText) findViewById(R.id.tv_diem_ltdd);
        editText_fullname.setText(item.getDiem_ltdd());

        Button button = (Button) findViewById(R.id.bt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.setFull_name(String.valueOf(editText_fullname.getText()));
                item.setDiem_tin(Integer.parseInt(String.valueOf(editText_diem_tin.getText())));
                item.setDiem_toan(Integer.parseInt(String.valueOf(editText_diem_toan.getText())));
                item.setDiem_ltdd(Integer.parseInt(String.valueOf(editText_diem_ltdd.getText())));

                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(myIntent);
            }
        });

    }
}