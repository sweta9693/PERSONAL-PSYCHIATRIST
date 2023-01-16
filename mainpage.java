package com.example.personalpsychiatrist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class mainpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mainpage);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_700)));
        getSupportActionBar().setTitle("main page");
    }
    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }
    public void displayToastMsg(View v) {
        toastMsg("things  will get better");
    }

    public void toastMsg1(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }
    public void displayToastMsg1(View v) {
        toastMsg("WOW that's great you are improving!!");
    }

    public void toastMsg2(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }
    public void displayToastMsg2(View v) {
        toastMsg("It is okay to be confused you will find the answer!!");
    }
    public void openBalance(View view) {
        startActivity(new Intent(this,Balance.class));
    }

    public void openAssessment(View view) {
        startActivity(new Intent(this,Assessment.class));
    }

    public void openDoctorDetails(View view) {
        startActivity(new Intent(this,DoctorDetails.class));

    }
}