package com.usmanejaz.cgpa_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static int i = 1;
    public static int j = i+20;
    EditText course, grade;
    TextView name;
    LinearLayout ll;
    Double gpatotal =10.0;
    Double chtotal =3.0;
    Double resultValue =0.0;
    @SuppressLint({"ResourceType", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        Button btn = (Button)findViewById(R.id.b1);
        TextView val = (TextView)findViewById(R.id.result);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                if(i == 10) {
                    Snackbar.make(view, "Max course limit reached", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else {
                    addButton();
                }
            }

        });

        Button result = findViewById(R.id.r1);
        result.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                int index = 0;
                EditText gpa1, ch1;
                Double gpa = 0.0;
                Double ch = 0.0;
                for (int k = 1; k <i; k++){

                    gpa1 = findViewById(k);
                    ch1 = findViewById(k+20);
                    String text2 = ch1.getText().toString();
                    String text = gpa1.getText().toString();
                    double gpaDouble = Double.parseDouble(text);
                    double chDouble = Double.parseDouble(text2);

                    gpa += (gpaDouble*chDouble);
                    ch += chDouble;
                }

                Double CGPA = gpa/ch;

                val.setText("GPA = " + CGPA);
            }
        });


    }

    public void addButton() {
        LinearLayout layout = (LinearLayout)findViewById(R.id.ll);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(20,20,20,20);


        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        name = new TextView(this);
        course = new EditText(this);
        grade = new EditText(this);

        name.setGravity(View.TEXT_ALIGNMENT_GRAVITY);
        grade.setGravity(View.TEXT_ALIGNMENT_GRAVITY);
      //  course.setGravity(View.TEXT_ALIGNMENT_GRAVITY);

        name.setPadding(5,0 , 5, 5);


        name.setText("Course" + i);
        name.setTextSize(20);

        course.setHint("GPA");
        course.setTextSize(20);

        grade.setHint("Credit hrs.");
        grade.setTextSize(20);

        name.setLayoutParams(params);
        course.setLayoutParams(params);
        grade.setLayoutParams(params);

        grade.setId(j);
        course.setId(i);
        i++;
        j++;
        ll.addView(name);
        ll.addView(course);
        ll.addView(grade);
        layout.addView(ll);

    }
}



