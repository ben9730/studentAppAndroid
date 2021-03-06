package com.example.studentapp.model;

public class Student {
    String name = "";
    String id = "";
    String address = "";
    String phone = "";
    boolean flag = false;

    public Student(Student student) {
        this.name = student.name;
        this.id = student.id;
        this.address = student.address;
        this.phone = student.phone;
        this.flag = student.flag;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Student() {
    }

    public Student(String name, String id, String address, String phone, boolean flag) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.flag = flag;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
