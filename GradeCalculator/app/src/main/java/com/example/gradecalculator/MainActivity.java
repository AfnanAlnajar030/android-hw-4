package com.example.gradecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.graphics.Color.argb;

public class MainActivity extends AppCompatActivity {


    @Override
  protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //I declared them here because when I declared them outside
        // the function but inside the class I got an error and my project stopped working.

        final EditText quiz = findViewById(R.id.firstOne);
        final EditText hw = findViewById(R.id.secondOne);
        final EditText midterms = findViewById(R.id.thirdOne);
        final EditText finals = findViewById(R.id.fourthOne);
        final Button cal = findViewById(R.id.cal);
        final TextView results = findViewById(R.id.results);
        final Button reset = findViewById(R.id.reset);



        //Calculate Button:
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int first = Integer.parseInt(quiz.getText().toString());
                int second = Integer.parseInt(hw.getText().toString());
                int third = Integer.parseInt(midterms.getText().toString());
                int fourth = Integer.parseInt(finals.getText().toString());
                int grade = first + second + third + fourth;


                String letterGrade = gradeGenerator(grade);
//              System.out.println(letterGrade);

                results.setText(grade + " =                  " + letterGrade);
                results.setBackgroundColor(Color.parseColor("#" + (colorGenerator(grade))));



            }
        });

        //Reset Button:

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quiz.setText("");
                quiz.setHint("Quizzes %15");
                hw.setText("");
                hw.setHint("Homework %25");
                midterms.setText("");
                midterms.setHint("Mid terms 30%");
                finals.setText("");
                finals.setHint("Final 30%");
                results.setBackgroundColor(Color.TRANSPARENT);
                results.setText("");


            }
        });


    }
    //hw 1, changed to give String.
    public static String gradeGenerator( int x){

        if (x >= 90){
            return "A";

        } else if ( 80 <= x && x < 90){
            return "B";

        } else if (70 <= x && x < 80 ) {
            return "C";

        } else if (60 <= x && x < 70) {
            return "D";

        } else if ( x < 60) {
            return "F";

        }
        return "E";
    }

    public static String colorGenerator(int x) {

        if (x >= 90){
            return "3498DB";

        }if ( 80 <= x && x < 90){
            return "00FF00";

        } else if (70 <= x && x < 80 ) {
            return "FFFF00";

        } else if (60 <= x && x < 70) {
            return "FF4500";

        } else if ( x < 60) {
            return "FF0000";

        }
        return "000000";

    }

}