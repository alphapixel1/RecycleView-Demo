package com.example.recycleviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//https://www.youtube.com/watch?v=HtwDXRWjMcU
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Todo> todoList= new ArrayList<>(Arrays.asList(new Todo("First",false),new Todo("Second",true)));
        TodoAdapter adapter=new TodoAdapter(todoList);

        RecyclerView rvTodos=findViewById(R.id.rvTodos);
        rvTodos.setAdapter(adapter);
        rvTodos.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.btnAddTodo).setOnClickListener(v->{
            todoList.add(new Todo(((EditText)findViewById(R.id.etTodo)).getText().toString(),false));
            adapter.notifyItemInserted(todoList.size()-1);
        });
    }
}