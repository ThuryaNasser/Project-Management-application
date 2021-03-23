package com.example.manaagementapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Dialog addNewProject ;
    Button doneButton;
    Database DB = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNewProject = new Dialog(this);
        addNewProject.setContentView(R.layout.add_new_project);
        doneButton = addNewProject.findViewById(R.id.AddButton);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewProject();
            }
        });

        FloatingActionButton fab = findViewById(R.id.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewProject.show();
            }
        });
    }

    private void NewProject(){
        //database insertion
        EditText ProjectNameInput = addNewProject.findViewById(R.id.ProjectNameEditText);
        EditText DescriptionInput = addNewProject.findViewById(R.id.Description);
        EditText GoalInput = addNewProject.findViewById(R.id.GoalInput);
        EditText StartDateInput = addNewProject.findViewById(R.id.StartDateInput);
        EditText EndDateInput = addNewProject.findViewById(R.id.EndDateInput);


        String ProjectName = ProjectNameInput.getText().toString();
        String Description = DescriptionInput.getText().toString();
        String Goal = GoalInput.getText().toString();
        String StartDate = StartDateInput.getText().toString();
        String EndDate = EndDateInput.getText().toString();


        Boolean checking = DB.insertuserdata(ProjectName,Description,Goal,StartDate,EndDate);

        if(checking){
            addNewProject.dismiss();
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "added a new project successfully", Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "try again", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

}