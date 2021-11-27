package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;

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

public class StudentEditActivity extends AppCompatActivity {

    List<Student> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_edit);
        setTitle("Edit");
        data = Model.instance.getAllStudents();
        //the student data
        Bundle extra = getIntent().getExtras();
        //get the date form the parent intent

        int index = extra.getInt("pos");
        Student student = data.get(index);

        //bring the view to the code
        EditText name = findViewById(R.id.studentedit_name);
        EditText id = findViewById(R.id.studentedit_id);
        EditText address = findViewById(R.id.studentedit_addres);
        EditText phone = findViewById(R.id.studentedit_phone);
        CheckBox cb = findViewById(R.id.studentedit_cb);
        Button saveBtn = findViewById(R.id.studentedit_save);
        Button cancelBtn = findViewById(R.id.studentedit_cancel);
        Button deleteBtn = findViewById(R.id.studentedit_delete);

        //update the data
        name.setText(student.getName());
        id.setText(student.getId());
        address.setText(student.getAddress());
        phone.setText(student.getPhone());
        cb.setChecked(student.isFlag());

        Intent intent = new Intent(this, StudentListRvActivity.class);
        //when we save or delete we want to go to homepage

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "CANCEL!");
                finish();
            }
        });


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //update the student
                student.setName(name.getText().toString());
                student.setId(id.getText().toString());
                student.setAddress(address.getText().toString());
                student.setPhone(phone.getText().toString());
                student.setFlag(cb.isChecked());

                data.remove(index);
                data.add(index, student);
                Log.d("TAG", "Save new data");
                startActivity(intent);

            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.remove(index);
                Log.d("TAG", "delete data");
                startActivity(intent);
            }
        });

    }
}