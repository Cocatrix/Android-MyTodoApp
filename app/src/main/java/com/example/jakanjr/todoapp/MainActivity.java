package com.example.jakanjr.todoapp;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageButton send;
    EditText inputTask;

    RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    List<MyTask> pool = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = (ImageButton) findViewById(R.id.imageButton);
        inputTask = (EditText) findViewById(R.id.editText);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task = inputTask.getText().toString();
                Log.d("Adding Task :", "la tache a ajouter est :" + task + " et la stack est "+pool.toString());
                Log.d("curiosité", mAdapter.getClass().getName().toString());
                if(!task.equals("")){
                    Log.d("Adding Task :","Task sent");
                    MyTask newTask = new MyTask(task);
                    pool.add(newTask);
                    mAdapter.notifyDataSetChanged();
                   //mAdapter.notifyItemChanged(pool.size()-1);
                }
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(pool);
        recyclerView.setAdapter(mAdapter);
    }



}
