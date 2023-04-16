package com.usmanejaz.cgpa_calculator.CGPA;

import static com.usmanejaz.cgpa_calculator.MainActivity.i;

import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.usmanejaz.cgpa_calculator.MainActivity;

public class calculator extends MainActivity {


    public void errormsg(View view){
        Snackbar.make(view, "Max course limit reached", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public double calculateCGPA(){

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
        return CGPA;

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
