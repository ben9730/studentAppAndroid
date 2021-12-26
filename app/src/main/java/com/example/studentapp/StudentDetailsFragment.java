package com.example.studentapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import android.widget.TextView;

import com.example.studentapp.model.Model;
import com.example.studentapp.model.Student;

import java.util.List;

public class StudentDetailsFragment extends Fragment {


    List<Student> data;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_details, container, false);

        data = Model.instance.getAllStudents();
        //bring the view to the code
        TextView name = view.findViewById(R.id.studentdetails_name_tv);
        TextView id = view.findViewById(R.id.studentdetails_id_tv);
        TextView address = view.findViewById(R.id.studentdetails_addres_tv);
        TextView phone = view.findViewById(R.id.studentdetails_phone_tv);
        CheckBox cb = view.findViewById(R.id.studentdetails_cb);

        Button editBtn = view.findViewById(R.id.studentdetails_save_btn);
        Button cancelBtn = view.findViewById(R.id.studentdetails_cancelbtn);

        int studentIndex = StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentIndex();
        //get the data we send with the parent fragment from the student list fragment
        //need to define var and is type in the nevGraph xml

        Student student = data.get(studentIndex);

        name.setText(student.getName());
        id.setText(student.getId());
        address.setText(student.getAddress());
        phone.setText(student.getPhone());
        cb.setChecked(student.isFlag());
        //bind the view with the data

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "Edit data");
                Navigation.findNavController(v).navigate(StudentDetailsFragmentDirections.actionStudentDetailsFragmentToStudentEditFragment(studentIndex));
                //from student details to student edit page
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "cancel click");
                Navigation.findNavController(v).navigateUp();
                //return us to the parent fragment and save data if need
            }
        });

        return view;
    }


}