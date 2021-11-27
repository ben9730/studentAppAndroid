package com.example.studentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.studentapp.model.Model;
import com.example.studentapp.model.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class StudentListRvActivity extends AppCompatActivity {

    List<Student> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        data = Model.instance.getAllStudents();
        //give us all the data in synchrony with the another code

        RecyclerView list = findViewById(R.id.studentListRv_rv);
        list.setHasFixedSize(true);

        list.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = new Intent(this, StudentDetailsActivity.class);
        //intent is to go form one screen to another  1 => 2
        //intent to go to StudentDetailsActivity

        MyAdapter adapter = new MyAdapter();
        list.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d("TAG", "row was click " + position);
                intent.putExtra("pos", position);
                //this way to send data to new activity
                startActivity(intent);
                //go to =>details
            }
        });

        addNewStudent();
        //ctrl + alt + m for take code and put in function


    }

    private void addNewStudent() {
        Intent intent = new Intent(this, NewStudentActivity.class);
        FloatingActionButton addBtn = findViewById(R.id.Rv_addBtn_fab);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent); // gp from here => new student
                //this is for go from this activity to new student activity
            }
        });
    }


    interface OnItemClickListener {
        void onItemClick(int position);
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        OnItemClickListener listener;

        public void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }

        @NonNull
        @Override

        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.student_list_row, parent, false);
            MyViewHolder holder = new MyViewHolder(view, listener);

            Log.d("TAG", "holder create ");

            return holder;
            //all this create the Row in the layout
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            //here we give the view the student data to show

            Student student = data.get(position);
            holder.nameTv.setText(student.getName());
            holder.idTv.setText(student.getId());
            holder.cb.setOnCheckedChangeListener(null); // reset the checkbox
            holder.cb.setChecked(student.isFlag());

            holder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    //find the state of the cb

                    student.setFlag(isChecked);
                    Log.d("TAG", "cb is click student is press " + student.isFlag());
                }
                //here we created checkbox listener, get the cb event here
            });

            Log.d("TAG", "scroll " + position);
            //this is the scroll up/down

        }


        @Override
        public int getItemCount() {
            return data.size();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv;
        TextView idTv;
        CheckBox cb;

        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.listRow_name_tv);
            idTv = itemView.findViewById(R.id.listRow_id_tv);
            cb = itemView.findViewById(R.id.listRow_cb);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();

                    //this is the row click
                    listener.onItemClick(pos);


                }
            });
        }

    }
}