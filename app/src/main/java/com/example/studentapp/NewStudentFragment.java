package com.example.studentapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.studentapp.model.Model;
import com.example.studentapp.model.Student;

import java.util.List;

public class NewStudentFragment extends Fragment {

    List<Student> data;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_student, container, false);

        data = Model.instance.getAllStudents();

        EditText name = view.findViewById(R.id.newstudent_name_et);
        EditText id = view.findViewById(R.id.newstudent_id_et);
        EditText address = view.findViewById(R.id.newstudent_address_et);
        EditText phone = view.findViewById(R.id.newstudent_phone_et);
        CheckBox cb = view.findViewById(R.id.newstudent_cb);

        Button saveBtn = view.findViewById(R.id.newstudent_save_btn);
        //Intent intent = new Intent(this, StudentListRvFragment.class);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(name.getText().toString(), id.getText().toString(), address.getText().toString(),
                        phone.getText().toString(), cb.isChecked());
                data.add(student);
                Log.d("TAG", "save student");
                //after we save in this way we return to the parent page
                Navigation.findNavController(v).navigateUp();
                //startActivity(intent);
            }
        });

        Button cancelBtn = view.findViewById(R.id.newstudent_cancel_btn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigateUp();
            }
        });

        return view;
    }



}