package com.c.phoneotpfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {




    private EditText emobile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        emobile = findViewById( R.id.pno );

        findViewById(R.id.send).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile = emobile.getText().toString().trim();

                if(mobile.isEmpty() || mobile.length() < 10){
                    emobile.setError("Enter a valid mobile");
                    emobile.requestFocus();
                    return;
                }

                Intent intent = new Intent(MainActivity.this, Verifyphone.class);
                intent.putExtra("mobile", mobile);
                startActivity(intent);
            }
        } );

    }
}