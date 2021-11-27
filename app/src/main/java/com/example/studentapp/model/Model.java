package com.example.studentapp.model;

import java.util.LinkedList;
import java.util.List;

public class Model {

    //our singleton
    public static final Model instance = new Model();

    //our constructor to be private
    private Model() {
        for (int i = 0; i < data.size(); i++) {
//            Student s = new Student("name",""+i,""+i,""+i,false);
//            data.add(s);
              Student s = data.get(i);
        }
    }


    List<Student> data = new LinkedList<Student>();

    public List<Student> getAllStudents() {
        return data;
    }

    public void addStudent(Student student) {
        data.add(student);
    }


}
