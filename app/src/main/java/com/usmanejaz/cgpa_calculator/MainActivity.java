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
    Button clear, clearAll;
    @SuppressLint({"ResourceType", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

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
                    double gpaDouble;
                    double chDouble;
                    String text2 = ch1.getText().toString();
                    String text = gpa1.getText().toString();
                    if(text.equals("")) gpaDouble =0.0;
                    else gpaDouble = Double.parseDouble(text);

                    double gpaVal = findGrade(gpaDouble);

                    if(text2.equals("")) chDouble=0.0;
                    else chDouble = Double.parseDouble(text2);

                    gpa += (gpaVal*chDouble);
                    ch += chDouble;
                }

                Double CGPA = gpa/ch;

                val.setText(""+String.format("%.2f",CGPA));
            }
        });

        LinearLayout layout = findViewById(R.id.ll);
        LinearLayout save = findViewById(R.id.save);
        clearAll = findViewById(R.id.clear);
        clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 1;
                layout.removeAllViews();
                layout.addView(save);
            }
        });


    }

    public void addButton() {
        LinearLayout layout = (LinearLayout)findViewById(R.id.ll);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(10,10,10,10);



        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setBackground(getResources().getDrawable(R.drawable.ll_border));
        ll.setPadding(5,5,5,5);
        ll.setLayoutParams(params);
        name = new TextView(this);
        course = new EditText(this);
        grade = new EditText(this);

        name.setGravity(View.TEXT_ALIGNMENT_GRAVITY);
        grade.setGravity(View.TEXT_ALIGNMENT_GRAVITY);
      //  course.setGravity(View.TEXT_ALIGNMENT_GRAVITY);

        name.setPadding(5,0 , 5, 5);

        name.setText("Course" + i);
        name.setTextSize(20);

        course.setHint("/100");
        course.setTextSize(20);

        grade.setHint("Credit hrs.");
        grade.setTextSize(20);

        name.setLayoutParams(params);
        course.setLayoutParams(params);
        grade.setLayoutParams(params);

        name.setTextColor(Color.parseColor("#355e3b"));
        name.setBackgroundColor(Color.parseColor("#d8e4bc"));

        grade.setId(j);
        course.setId(i);

        i++;
        j++;




        ll.addView(name);
        ll.addView(course);
        ll.addView(grade);

        layout.addView(ll);

    }

    public double findGrade(double num){

        double grade = 0.0;

        if(num >= 85){
            grade = 4.0;
        }
        else if(num < 85 && num >= 80){
            grade = 3.7;
        }
        else if(num < 80 && num >=75){
            grade = 3.3;
        }
        else if(num <75 && num >= 70){
            grade = 3.0;
        }
        else if(num < 70 && num >=65){
            grade = 2.7;
        }
        else if(num < 65 && num >=60){
            grade = 2.3;
        }
        else if(num < 60 && num >=58){
            grade = 2.0;
        }
        else if(num < 58 && num >= 55){
            grade = 1.7;
        }
        else if(num < 55 && num >=50){
            grade = 1.0;
        }
        else{
            grade = 0.0;
        }
        return grade;
    }
}



