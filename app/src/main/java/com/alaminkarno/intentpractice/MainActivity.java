package com.alaminkarno.intentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText phoneET;
    Button callButton;
    public static String phoneNo = "PhoneNO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneET = findViewById(R.id.phoneET);
        callButton = findViewById(R.id.callBTN);

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = phoneET.getText().toString();

                if(phone.isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter phone number", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+phone));
                    startActivity(intent);
                }


            }
        });

    }

    public void intent(View view) {

        String phone = phoneET.getText().toString();

        if(phone.isEmpty()){
            Toast.makeText(MainActivity.this, "Enter phone number", Toast.LENGTH_SHORT).show();
        }
        else {

            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra(phoneNo,phone);
            startActivity(intent);
        }


    }
}