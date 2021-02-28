package com.example.rajendra.agecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    EditText mYearEt;
    Button mCalBtn;
    TextView mAgeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mYearEt = findViewById(R.id.yearEditText);
         mCalBtn = findViewById(R.id.calculate_btn);
         mAgeTv = findViewById(R.id.ageTextView);

        mCalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userDOB = mYearEt.getText().toString();

                int year = Calendar.getInstance().get(Calendar.YEAR);
                if(userDOB.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter your birth year", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(userDOB.compareTo(String.valueOf(year))  > 0){
                    Toast.makeText(MainActivity.this, "Birth Year should be less than current year  ", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    int myAge = year - Integer.parseInt(userDOB);
                    mAgeTv.setText("Your age is" + " " +myAge + " " + "year");
                    return;
                }
            }
        });

    }
}
