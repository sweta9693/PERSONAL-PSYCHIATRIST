package com.example.personalpsychiatrist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DoctorDetails extends AppCompatActivity {
    private static final int Request_Call = 1;
    private Button call_btn, call_btn1, call_btn2;
    private TextView CallText, CallText1, CallText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_doctor_details);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_700)));
        getSupportActionBar().setTitle("Doctor Details");
        CallText = findViewById(R.id.tc1);
        CallText = findViewById(R.id.tc2);
        CallText = findViewById(R.id.tc3);
        call_btn = findViewById(R.id.bt1);
        call_btn1 = findViewById(R.id.bt2);
        call_btn2 = findViewById(R.id.bt3);
        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallButton();
            }
        });

    }

    private void CallButton() {
        String num = CallText.getText().toString();
        if (num.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(DoctorDetails.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(DoctorDetails.this, new String[]{Manifest.permission.CALL_PHONE}, Request_Call);
            } else {
                String dial = "tel:" + num;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == Request_Call) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                CallButton();
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}