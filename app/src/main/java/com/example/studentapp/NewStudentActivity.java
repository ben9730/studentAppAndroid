package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentapp.model.Model;
import com.example.studentapp.model.Student;

import java.util.List;

public class NewStudentActivity extends AppCompatActivity {

    List<Student> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);
        setTitle("Enroll new student ");
        data = Model.instance.getAllStudents();

        EditText name = findViewById(R.id.newstudent_name_et);
        EditText id = findViewById(R.id.newstudent_id_et);
        EditText address = findViewById(R.id.newstudent_address_et);
        EditText phone = findViewById(R.id.newstudent_phone_et);
        CheckBox cb = findViewById(R.id.newstudent_cb);

        Button saveBtn = findViewById(R.id.newstudent_save_btn);
        Intent intent = new Intent(this,StudentListRvActivity.class);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(name.getText().toString(), id.getText().toString(), address.getText().toString(),
                        phone.getText().toString(), cb.isChecked());
                data.add(student);
                Log.d("TAG", "save student");
                startActivity(intent);
            }
        });

        Button cancelBtn = findViewById(R.id.newstudent_cancel_btn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

}