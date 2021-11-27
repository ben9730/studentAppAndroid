package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.studentapp.model.Model;
import com.example.studentapp.model.Student;

import java.util.List;

public class StudentDetailsActivity extends AppCompatActivity {

    List<Student> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        data = Model.instance.getAllStudents();
        setTitle("Details");

        //bring the view to the code
        TextView name = findViewById(R.id.studentdetails_name_tv);
        TextView id= findViewById(R.id.studentdetails_id_tv);
        TextView address = findViewById(R.id.studentdetails_addres_tv);
        TextView phone = findViewById(R.id.studentdetails_phone_tv);
        CheckBox cb = findViewById(R.id.studentdetails_cb);

        Button editBtn = findViewById(R.id.studentdetails_save_btn);

        Bundle extra = getIntent().getExtras();
        int i = extra.getInt("pos");
        //get the data we send with the intent from the student list activity need key => value

        Student student = data.get(i);

        name.setText(student.getName());
        id.setText(student.getId());
        address.setText(student.getAddress());
        phone.setText(student.getPhone());
        cb.setChecked(student.isFlag());
        //bind the view with the data

        Intent intent = new Intent(this,StudentEditActivity.class);
        intent.putExtra("pos",i);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(intent);
                Log.d("TAG","Edit data");
            }
        });

    }
}